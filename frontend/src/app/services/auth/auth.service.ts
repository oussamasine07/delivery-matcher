import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {loginForm} from '../../models/types/loginForm';
import {catchError, Observable, throwError} from 'rxjs';
import {Token} from '../../models/interfaces/token';

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

}
