import { Component } from '@angular/core';
import { Prenotazione } from '../prenota/prenota.model'
import { HttpClient } from '@angular/common/http';
 
@Component({
  selector: 'app-prenota',
  standalone:false,
  templateUrl: './prenota.component.html',
  styleUrl: './prenota.component.scss'
})
export class PrenotaComponent {
   prenotazioneDTO: Prenotazione = {
    nome: '',
    cognome: '',
    dataPrenotazione: '',
    nPersone: 1,
    pasto: '',
    telefono: '',
    note: ''
  };

  constructor(private http: HttpClient) {}

  inviaPrenotazione() {
    this.http.post('http://localhost:8080/crea', this.prenotazioneDTO)
      .subscribe({
        next: response => {
          alert('Prenotazione inviata con successo!');
        },
        error: error => {
          alert('Errore nell\'invio della prenotazione');
          console.error(error);
        }
    });
  }
}