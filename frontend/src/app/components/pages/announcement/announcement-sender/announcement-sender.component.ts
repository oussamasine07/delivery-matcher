import {Component, inject, Input, OnInit} from '@angular/core';
import {AnnouncementCreateModalComponent} from '../announcement-create-modal/announcement-create-modal.component';
import {AnnouncementDeleteComponent} from '../announcement-delete/announcement-delete.component';
import {AnnouncementUpdateComponent} from '../announcement-update/announcement-update.component';
import {NgForOf, NgIf} from '@angular/common';
import {Announcement} from '../../../../models/interfaces/announcement';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';
import {ApplyModalComponent} from '../../application/apply-modal/apply-modal.component';
import {AuthService} from '../../../../services/auth/auth.service';
import {Application} from '../../../../models/interfaces/application';

@Component({
  selector: 'app-announcement-sender',
  imports: [
    NgForOf,
    NgIf,
    ApplyModalComponent
  ],
  templateUrl: './announcement-sender.component.html',
  styleUrl: './announcement-sender.component.css'
})
export class AnnouncementSenderComponent implements OnInit {

  token: string | null = localStorage.getItem("token") ? localStorage.getItem("token") : null;

  announcementService: AnnouncementService = inject(AnnouncementService);
  authService: AuthService = inject(AuthService);

  userId: number | null | undefined = null;

  announcements: Announcement[] = [];

  hasUserApplied(announcement: Announcement | null ): boolean {
    return announcement?.applications?.some(app => app.sender?.id === this.userId) ?? false;
  }

  ngOnInit() {

    this.userId = this.authService.getDecodedToken(this.token)?.id;

    this.announcementService.getAllAnnouncements().subscribe({
      next: (anns: Announcement[]) => {
        this.announcements = anns;
        console.log(this.announcements)
      },
      error: e => {
        console.log(e);
      }
    })
  }

  @Input() applyAnnouncement: Announcement | null = null;
  showApplicationModal = false;
  openApplicationModal (announcement: Announcement) {
    this.showApplicationModal = true;
    this.applyAnnouncement = announcement
  }
  closeApplicationModal() {
    this.showApplicationModal = false;
  }

}
