import {Component, inject, OnInit} from '@angular/core';
import {AnnouncementCreateModalComponent} from '../announcement-create-modal/announcement-create-modal.component';
import {AnnouncementDeleteComponent} from '../announcement-delete/announcement-delete.component';
import {AnnouncementUpdateComponent} from '../announcement-update/announcement-update.component';
import {NgForOf, NgIf} from '@angular/common';
import {Announcement} from '../../../../models/interfaces/announcement';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';

@Component({
  selector: 'app-announcement-sender',
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './announcement-sender.component.html',
  styleUrl: './announcement-sender.component.css'
})
export class AnnouncementSenderComponent implements OnInit {

  announcementService: AnnouncementService = inject(AnnouncementService);

  announcements: Announcement[] = [];

  ngOnInit() {
    this.announcementService.getAllAnnouncements().subscribe({
      next: (anns: Announcement[]) => {
        this.announcements = anns;
      },
      error: e => {
        console.log(e);
      }
    })
  }

}
