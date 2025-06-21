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

  getAllAnnouncements (): Observable<Announcement[]> {
    return this.httpClient.get<Announcement[]>("http://localhost:8080/api/v1/announcement").pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err);
      })
    )
  }

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

  updateAnnouncement (body: announcementForm, annoucementId: number | null | undefined): Observable<Announcement> {

    return this.httpClient.put<Announcement>(`http://localhost:8080/api/v1/announcement/update/${annoucementId}`, body).pipe(
      catchError((err: HttpErrorResponse)=> {
        return throwError(() => err);
      })
    )
  }

  deleteAnnouncement ( announcementId: number | null | undefined): Observable<any> {
    return this.httpClient.delete(`http://localhost:8080/api/v1/announcement/delete/${announcementId}`).pipe(
      catchError((err: HttpErrorResponse) => {
        return throwError(() => err)
      })
    )
  }

}
