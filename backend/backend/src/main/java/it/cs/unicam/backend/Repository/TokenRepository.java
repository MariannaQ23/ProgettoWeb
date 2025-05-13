package it.cs.unicam.backend.Repository;


import it.cs.unicam.backend.Entity.Account;
import it.cs.unicam.backend.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findAllAccessTokensByAccount(Account account);

    Optional<Token> findByAccessToken(String token);

    Optional<Token > findByRefreshToken(String token);
}
