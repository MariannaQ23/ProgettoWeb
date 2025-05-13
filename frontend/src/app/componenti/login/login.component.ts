import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
/*  email: string = '';
  password: string = '';
  errorMessage: string | null = null;
  constructor(private authService: AuthService, private router: Router) { }

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

  }*/



}
