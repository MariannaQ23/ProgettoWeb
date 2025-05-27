package it.cs.unicam.backend.Services;


import it.cs.unicam.backend.Auth.ExistingUserException;
import it.cs.unicam.backend.Entity.Account;
import it.cs.unicam.backend.Repository.AccountRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account createAccount(String email, String password, String username) throws ExistingUserException {
        Optional<Account> account = accountRepository.findByEmail(email);
        if (account.isPresent()) {
            throw new ExistingUserException("L'account esiste già");
        }
        Account newAccount = new Account(email, password, username);
        accountRepository.save(newAccount);
        return newAccount;
    }


    public void saveAccount(@NonNull Account account) {
        accountRepository.save(account);
    }


    public Optional<Account> getAccount(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }


}
