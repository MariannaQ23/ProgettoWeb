package it.cs.unicam.backend.Auth;


import it.cs.unicam.backend.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailServiceImpl {

    @Autowired
    private AccountService accountServices;

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> accountServices.getAccount(email)
                .orElseThrow(() -> new UsernameNotFoundException("Nessun account trovato per l'utente: " + email));
    }
}


