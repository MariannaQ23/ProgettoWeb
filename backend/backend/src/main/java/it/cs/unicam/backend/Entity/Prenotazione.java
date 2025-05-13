package it.cs.unicam.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;


import java.time.LocalDate;
@Entity
@Getter
public class Prenotazione {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cognome;

    private int nPersone;

    private LocalDate dataPrenotazione;

    public LocalDate getData() {
        return dataPrenotazione;
    }

    public enum Pasto {
        Pranzo,
        Cena
    }

    public Pasto pasto;

    private String telefono;

    private String note;

    @ManyToOne
    private Account account;

    public Prenotazione (){

    }

    public Prenotazione (String nome, String cognome, int nPersone, LocalDate dataPrenotazione, Pasto pasto, String telefono, String note, Account account){
        this.nome = nome;
        this.cognome = cognome;
        this.nPersone = nPersone;
        this.dataPrenotazione = dataPrenotazione;
        this.pasto = pasto;
        this.telefono = telefono;
        this.note = note;
        this.account = account;
    }
}