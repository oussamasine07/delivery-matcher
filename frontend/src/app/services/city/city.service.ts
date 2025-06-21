import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {City} from '../../models/interfaces/city';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  httpClient: HttpClient = inject(HttpClient);

  getCities (): Observable<City[]> {
    return this.httpClient.get<City[]>("http://localhost:8080/api/v1/city").pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err);
      })
    );
  }

}
