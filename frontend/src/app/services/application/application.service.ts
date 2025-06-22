import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {Application} from '../../models/interfaces/application';
import {applicationForm} from '../../models/types/applicationForm';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  httpClient: HttpClient = inject(HttpClient);

  applyForAnnouncement (body: applicationForm): Observable<Application> {
    return this.httpClient.post<Application>("http://localhost:8080/api/v1/application/apply", body).pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err);
      })
    )
  }

}
