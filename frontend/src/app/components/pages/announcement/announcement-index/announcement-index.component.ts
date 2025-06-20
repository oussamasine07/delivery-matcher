import {Component, inject, OnInit} from '@angular/core';
import {AnnouncementCreateModalComponent} from '../announcement-create-modal/announcement-create-modal.component';
import {NgFor, NgIf} from '@angular/common';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';
import {Announcement} from '../../../../models/interfaces/announcement';
import {AnnouncementUpdateComponent} from '../announcement-update/announcement-update.component';

@Component({
  selector: 'app-announcement-index',
  imports: [
    AnnouncementCreateModalComponent,
    NgIf,
    NgFor,
    AnnouncementUpdateComponent
  ],
  templateUrl: './announcement-index.component.html',
  styleUrl: './announcement-index.component.css'
})
export class AnnouncementIndexComponent implements OnInit{

  announcementService: AnnouncementService = inject(AnnouncementService);

  showModal = false;
  openModal() {
    this.showModal = true;
  }
  closeModal() {
    this.showModal = false;
  }

  showUpdateModal = false;
  openUpdateModal (announcement: Announcement) {
    this.showUpdateModal = true;
    this.updateAnnouncement = announcement
  }
  closeUpdateModal () {
    this.showUpdateModal = false;
  }


  announcements: Announcement[] = [];
  updateAnnouncement: Announcement | null = null;

  ngOnInit() {
    this.announcementService.getAnnouncementsByAuthenticatedDriver().subscribe({
      next: (res) => {
        this.announcements = res;
      },
      error: (e) => {
        console.log(e.error)
      }
    })
  }

  addNewAnnoucement ( announcement: Announcement) {
    this.announcements.push(announcement);
  }

}
















