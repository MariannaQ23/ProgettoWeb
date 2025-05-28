package it.cs.unicam.backend.Controller;

import it.cs.unicam.backend.DTO.PrenotazioneDTO;
import it.cs.unicam.backend.Entity.Account;
import it.cs.unicam.backend.Entity.Prenotazione;
import it.cs.unicam.backend.Services.AccountService;
import it.cs.unicam.backend.Services.PrenotazioneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/crea")
    public ResponseEntity<String> creaPrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Account account = (Account) authentication.getPrincipal();
            account = accountService.getAccountById(account.getId());
            this.prenotazioneService.creaPrenotazione(
                prenotazioneDTO.getNome(),
                prenotazioneDTO.getCognome(),
                prenotazioneDTO.getNPersone(),
                prenotazioneDTO.getDataPrenotazione(),
                prenotazioneDTO.getPasto(),
                prenotazioneDTO.getTelefono(),
                prenotazioneDTO.getNote(),
                account
            );
            return ResponseEntity.ok("Prenotazione effetuata");
       
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Si è verificato un errore, prenotazione NON effettuata");
        }
    }


     @GetMapping("/visualizzaPrenotazioni")
    public ResponseEntity<?> visualizzaPrenotazioni () {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Account account = (Account) authentication.getPrincipal();
            account = accountService.getAccountById(account.getId());
            
            return ResponseEntity.ok(this.prenotazioneService.getPrenotazioniAccount(account));

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Si è verificato un errore");
        }
    }
}