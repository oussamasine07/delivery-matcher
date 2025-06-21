import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {Journy} from '../../models/interfaces/journy';
import {journyForm} from '../../models/types/journyForm';

@Injectable({
  providedIn: 'root'
})
export class JournyService {

  httpClient: HttpClient = inject(HttpClient);

  getAllJourniesByDriverId (): Observable<Journy[]> { // TODO update the backend so that we get journies by driver id
    return this.httpClient.get<Journy[]>("http://localhost:8080/api/v1/journy").pipe(
      catchError((err: HttpErrorResponse)=> {
        return throwError(() => err);
      })
    )
  }

  createJourny ( body: journyForm): Observable<Journy> {
    return this.httpClient.post<Journy>("http://localhost:8080/api/v1/journy/create", body).pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err);
      })
    )
  }

  updateJourny ( body: journyForm, journyId: number | null | undefined ): Observable<Journy> {
    return this.httpClient.put<Journy>(`http://localhost:8080/api/v1/journy/update/${ journyId }`, body).pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err);
      })
    )
  }

}
