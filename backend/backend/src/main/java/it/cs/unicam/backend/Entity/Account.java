package it.cs.unicam.backend.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.regex.Pattern;

@Getter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;



    public Account(@NonNull String email, @NonNull String password, @NonNull String username) {
        setEmail(email);
        setPassword(password);
        this.username = username;

    }

    public void setEmail(@NonNull String email) {
        if (!checkEmail(email)) {
            throw new IllegalArgumentException("Email non valida.");
        }
        this.email = email;
    }


    public void setPassword(@NonNull String password) {
        if (checkPassword(password)) {
            throw new IllegalArgumentException("Password non valida.");
        }
        this.password = password;
    }

    private static boolean checkEmail(@NonNull String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private static boolean checkPassword(@NonNull String password) {
        return password.length() < 8 || !password.matches(".*[0-9].*");
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
