package it.cs.unicam.backend.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
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

    @JsonProperty("nPersone") // forza il nome nel JSON
    private Integer nPersone; 

    private LocalDate dataPrenotazione;

    private Prenotazione.Pasto pasto;

    private String telefono;

    private String note;

}
