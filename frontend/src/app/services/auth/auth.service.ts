import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {loginForm} from '../../models/types/loginForm';
import {catchError, Observable, throwError} from 'rxjs';
import {Token} from '../../models/interfaces/token';
import {registerForm} from '../../models/types/registerForm';
import {Driver} from '../../models/interfaces/driver';
import {Sender} from '../../models/interfaces/sender';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  httpClient: HttpClient = inject(HttpClient);

  authenticateUser (body: loginForm): Observable<Token> {
    return this.httpClient.post<Token>("http://localhost:8080/user/login", body).pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err)
      })
    );
  }

  registerUser ( body: registerForm ): Observable<Driver | Sender> {
    return this.httpClient.post<Driver | Sender>("http://localhost:8080/user/register", body).pipe(
      catchError ((err: HttpErrorResponse) => {
        return throwError(() => err)
      })
    );
  }

}
