package it.cs.unicam.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Token {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String accessToken;

    @Setter
    @Getter
    private String refreshToken;

    @Setter
    @Getter
    private boolean loggedOut;

    @Setter
    @Getter
    @ManyToOne
    private Account account;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
