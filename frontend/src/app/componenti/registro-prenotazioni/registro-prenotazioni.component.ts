import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro-prenotazioni',
  standalone:false,
  templateUrl: './registro-prenotazioni.component.html',
  styleUrl: './registro-prenotazioni.component.scss'
})
export class RegistroPrenotazioniComponent implements OnInit {

  prenotazioni: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/visualizzaPrenotazioni')
      .subscribe({
        next: (data) => {
          this.prenotazioni = data;
          console.log(this.prenotazioni)
        },
        error: (err) => {
          console.error('Errore nel recupero delle prenotazioni:', err);
          alert('Errore durante il recupero delle prenotazioni');
        }
      });
  }
}

