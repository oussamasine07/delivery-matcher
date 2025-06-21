import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import {Announcement} from '../../../../models/interfaces/announcement';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';

@Component({
  selector: 'app-announcement-delete',
  imports: [],
  templateUrl: './announcement-delete.component.html',
  styleUrl: './announcement-delete.component.css'
})
export class AnnouncementDeleteComponent {

  announcementService: AnnouncementService = inject(AnnouncementService);

  @Input() currentAnnouncement: Announcement | null = null;
  @Output() confiremDelete = new EventEmitter();
  @Output() cancelDelete = new EventEmitter();

  onConfirmDeleteClick () {
    this.announcementService.deleteAnnouncement(this.currentAnnouncement?.id).subscribe({
      next: (res) => {
        this.confiremDelete.emit(res);
      },
      error: e => {
        console.log(e);
      }
    })
  }

  onCancelDeleteClick () {
    this.cancelDelete.emit();
  }
}
