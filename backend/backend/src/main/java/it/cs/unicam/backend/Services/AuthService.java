package it.cs.unicam.backend.Services;


import it.cs.unicam.backend.Auth.AuthResponse;
import it.cs.unicam.backend.Auth.ExistingUserException;
import it.cs.unicam.backend.Auth.LoginRequest;
import it.cs.unicam.backend.Auth.RegisterRequest;

import it.cs.unicam.backend.Entity.Account;
import it.cs.unicam.backend.Entity.Token;
import it.cs.unicam.backend.Repository.AccountRepository;
import it.cs.unicam.backend.Repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse register(RegisterRequest request) throws ExistingUserException {
        if (accountRepository.existsAccountByEmail(request.email())) {
            throw new ExistingUserException("L'utente esiste già");
        }

        Account account = accountService.createAccount(request.email(), passwordEncoder.encode(request.password()), request.username());
        String accessToken = jwtService.generateAccessToken(account);
        String refreshToken = jwtService.generateRefreshToken(account);
        saveUserToken(accessToken, refreshToken, account);
        return new AuthResponse(accessToken, refreshToken, "Registrazione avvenuta con successo");
    }

    public AuthResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        Account account = accountService.getAccount(request.email()).orElseThrow();
        String accessToken = jwtService.generateAccessToken(account);
        String refreshToken = jwtService.generateRefreshToken(account);

        revokeAllTokenByUser(account);
        saveUserToken(accessToken, refreshToken, account);
        return new AuthResponse(accessToken, refreshToken, "User login was successful");

    }

    private void revokeAllTokenByUser(Account user) {
        List<Token> validTokens = tokenRepository.findAllAccessTokensByAccount(user);
        if (validTokens.isEmpty()) {
            return;
        }
        validTokens.forEach(t -> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }

    private void saveUserToken(String accessToken, String refreshToken, Account account) {
        Token token = new Token();
        token.setAccessToken(accessToken);
        token.setRefreshToken(refreshToken);
        token.setLoggedOut(false);
        token.setAccount(account);
        tokenRepository.save(token);
    }

    public ResponseEntity refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        String token = authHeader.substring(7);
        String username = jwtService.extractUsername(token);
        Account account = accountService.getAccount(username)
                .orElseThrow(() -> new RuntimeException("No user found"));
        if (jwtService.isValidRefreshToken(token, account)) {
            String accessToken = jwtService.generateAccessToken(account);
            String refreshToken = jwtService.generateRefreshToken(account);

            revokeAllTokenByUser(account);
            saveUserToken(accessToken, refreshToken, account);

            return new ResponseEntity(new AuthResponse(accessToken, refreshToken, "New token generated"), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);

    }
}