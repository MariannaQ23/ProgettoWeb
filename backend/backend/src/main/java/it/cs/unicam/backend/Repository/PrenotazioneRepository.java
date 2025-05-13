package it.cs.unicam.backend.Repository;

import it.cs.unicam.backend.Entity.Account;
import it.cs.unicam.backend.Entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

   List<Prenotazione> findByaccount(Account account);

   List<Prenotazione> findAll();
}