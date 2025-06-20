import {Component, inject, OnInit} from '@angular/core';
import {AnnouncementCreateModalComponent} from '../announcement-create-modal/announcement-create-modal.component';
import {NgIf} from '@angular/common';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';

@Component({
  selector: 'app-announcement-index',
  imports: [
    AnnouncementCreateModalComponent,
    NgIf
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

  announcements: any[] = [];

  ngOnInit() {
    this.announcementService.getAnnouncementsByAuthenticatedDriver().subscribe({
      next: (res) => {
        //this.announcements = res;
      },
      error: (e) => {
        console.log(e.error)
      }
    })
  }


}
















