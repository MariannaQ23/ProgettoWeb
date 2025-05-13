import { Component } from '@angular/core';
import { AuthenticationService } from '../../Auth/AuthenticationService';
import { LoginRequest } from '../../Auth/LoginRequest';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  errorMessage: string | null = null;
  constructor(private authService: AuthenticationService, private router: Router) { }

  onLogin(): void {
    this.errorMessage = null;
    const loginRequest = new LoginRequest(this.email, this.password);
    this.authService.login(loginRequest).subscribe({
      next: (response) => {
        this.authService.saveTokens(response);
        this.router.navigate(['/prenotazione']);
      }, error: (error: HttpErrorResponse) => {
        if (error.error && typeof error.error === 'string') {
          this.errorMessage = "Ops qualcosa è andato storto...";
        } else {
          this.errorMessage = "Ops qualcosa è andato storto...";
        }
      },
    });

  }

}
