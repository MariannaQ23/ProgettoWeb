package it.cs.unicam.backend.DTO;

import it.cs.unicam.backend.Entity.Account;
import it.cs.unicam.backend.Entity.Prenotazione;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrenotazioneDTO {
    private String nome;

    private String cognome;

    private int nPersone;

    private LocalDate dataPrenotazione;

    private Prenotazione.Pasto pasto;

    private String telefono;

    private String note;
}
