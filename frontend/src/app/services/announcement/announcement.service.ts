import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  constructor() { }

  httpClient: HttpClient = inject(HttpClient)

  getAnnouncementsByAuthenticatedDriver () {
    // todo make sure to add interfaces types for announcements
    return this.httpClient.get("http://localhost:8080/api/v1/announcement/announcements-by-dirver-id").pipe(
      catchError((err: HttpErrorResponse)=> {
        return throwError(() => err);
      })
    );
  }

}
