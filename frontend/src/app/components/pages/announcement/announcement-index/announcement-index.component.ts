import { Component } from '@angular/core';
import {AnnouncementCreateModalComponent} from '../announcement-create-modal/announcement-create-modal.component';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-announcement-index',
  imports: [
    AnnouncementCreateModalComponent,
    NgIf
  ],
  templateUrl: './announcement-index.component.html',
  styleUrl: './announcement-index.component.css'
})
export class AnnouncementIndexComponent {
  showModal = false;

  openModal() {
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }
}
