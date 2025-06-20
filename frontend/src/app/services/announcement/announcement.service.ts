import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {Announcement} from '../../models/interfaces/announcement';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  constructor() { }

  httpClient: HttpClient = inject(HttpClient)

  getAnnouncementsByAuthenticatedDriver (): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/api/v1/announcement/announcements-by-dirver-id").pipe(
      catchError((err: HttpErrorResponse)=> {
        return throwError(() => err);
      })
    );
  }

}
