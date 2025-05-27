import { Component } from '@angular/core';
import { AuthenticationService } from '../../Auth/AuthenticationService';
import { RegisterRequest } from '../../Auth/RegisterRequest';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-reg',
  standalone:false,
  templateUrl: './reg.component.html',
  styleUrl: './reg.component.scss'
})

export class RegComponent {
  email: string = '';
  username: string = '';
  password: string = '';
  errorMessage: string | null = null;

  constructor(private authService: AuthenticationService, private router: Router) {
  }

  onRegister(): void {

    console.log('onRegister() chiamato');


    this.errorMessage = null;
    const registerRequest = new RegisterRequest(this.email, this.password, this.username);
    
    console.log('Dati inviati per la registrazione:', registerRequest);
    
    
    this.authService.register(registerRequest).subscribe({
      next: (response) => {

        console.log('Registrazione avvenuta con successo:', response);

        this.authService.saveTokens(response);
        this.router.navigate(['/prenotazione']);
      }, error: (error: HttpErrorResponse) => {

        console.error('Errore durante la registrazione:', error);

        if (error.error && typeof error.error === 'string') {
          this.errorMessage = "Si è verificato un problema";
        } else {
          this.errorMessage =  "Si è verificato un problema";
        }
      },
    });
  }

}
