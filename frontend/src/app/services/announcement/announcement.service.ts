import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {Announcement} from '../../models/interfaces/announcement';
import {announcementForm} from '../../models/types/annoucementForm';

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

  createAnnouncement (body: announcementForm): Observable<Announcement> {
    return this.httpClient.post<Announcement>("http://localhost:8080/api/v1/announcement/create", body).pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err);
      })
    )
  }

}
