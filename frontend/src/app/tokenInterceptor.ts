import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { catchError, switchMap } from 'rxjs/operators';
import { AuthenticationService } from "./Auth/AuthenticationService";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(private authenticationService: AuthenticationService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (req.url.includes('/login') || req.url.includes('/register')) {
      return next.handle(req);
    }

    const token = this.authenticationService.getAccessToken();
    if (token) {
      req = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${token}`)
      });
    }
    return next.handle(req).pipe(
      catchError((error) => {
        if (error.status === 401 && !req.url.includes('/refresh_token')) {

          return this.authenticationService.refreshToken().pipe(
            switchMap(() => {
              const refreshedToken = this.authenticationService.getAccessToken();
              if (refreshedToken) {
                req = req.clone({
                  headers: req.headers.set('Authorization', `Bearer ${refreshedToken}`)
                });
              }
              return next.handle(req);
            })
          );
        }
        return throwError(() => error);
      })
    );
  }
}
