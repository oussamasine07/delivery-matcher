import {Component, inject, OnInit} from '@angular/core';
import {AnnouncementCreateModalComponent} from '../announcement-create-modal/announcement-create-modal.component';
import {NgFor, NgIf} from '@angular/common';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';
import {Announcement} from '../../../../models/interfaces/announcement';
import {AnnouncementUpdateComponent} from '../announcement-update/announcement-update.component';
import {AnnouncementDeleteComponent} from '../announcement-delete/announcement-delete.component';

@Component({
  selector: 'app-announcement-index',
  imports: [
    AnnouncementCreateModalComponent,
    NgIf,
    NgFor,
    AnnouncementUpdateComponent,
    AnnouncementDeleteComponent
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
    this.announcment = announcement
  }
  closeUpdateModal () {
    this.showUpdateModal = false;
  }

  showDeleteModal = false
  openDeleteModal ( announcement: Announcement | null  ) {
    this.showDeleteModal = true;
    this.announcment = announcement
  }
  closeDeleteModal () {
    this.showDeleteModal = false;
    this.announcment = null;
  }


  announcements: Announcement[] = [];
  announcment: Announcement | null = null;

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

  updatedAnnouncment ( announcement: Announcement) {
    this.announcements = this.announcements.map(ann => ann.id == announcement.id ? announcement : ann)
  }

  confirmDeleteMessage ( res : any) {
    const ann = res.announcement;
    this.announcements = this.announcements.filter(announcement => announcement.id != ann.id && announcement)
    this.closeDeleteModal()
  }

}
















