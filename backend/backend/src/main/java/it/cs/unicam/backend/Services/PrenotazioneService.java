package it.cs.unicam.backend.Services;

import it.cs.unicam.backend.Entity.Account;
import it.cs.unicam.backend.Entity.Prenotazione;
import it.cs.unicam.backend.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione creaPrenotazione(String nome, String cognome, int nPersone, LocalDate dataPrenotazione, Prenotazione.Pasto pasto, String telefono, String note, Account account){
        Prenotazione prenotazione = new Prenotazione(nome,cognome, nPersone, dataPrenotazione, pasto, telefono, note, account);
        this.prenotazioneRepository.save(prenotazione);
        return prenotazione;
    }

    public List<Prenotazione> getPrenotazioniAccount( Account account){
        return this.prenotazioneRepository.findByaccount(account);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteExpiredGroups() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        for (Prenotazione p : prenotazioni) {
            if (currentDate.isAfter(p.getData())) {
                prenotazioneRepository.delete(p);
            }
        }
    }

}