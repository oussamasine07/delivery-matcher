import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
import {NgClass, NgForOf} from '@angular/common';
import {Journy} from '../../../../models/interfaces/journy';
import {JournyService} from '../../../../services/journy/journy.service';
import {announcementForm} from '../../../../models/types/annoucementForm';
import {FormsModule} from '@angular/forms';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';
import {Announcement} from '../../../../models/interfaces/announcement';

@Component({
  selector: 'app-announcement-create-modal',
  imports: [
    NgClass,
    NgForOf,
    FormsModule
  ],
  templateUrl: './announcement-create-modal.component.html',
  styleUrl: './announcement-create-modal.component.css'
})
export class AnnouncementCreateModalComponent implements OnInit {

  journyService: JournyService = inject(JournyService);
  announcementService: AnnouncementService = inject(AnnouncementService);

  @Output() close = new EventEmitter();
  animate = false;

  journies: Journy[] = [];

  ngOnInit() {
    setTimeout(() => {
      this.animate = true;
    }, 10)

    this.journyService.getAllJourniesByDriverId().subscribe({
      next: (res: Journy[]) => {
        this.journies = res;
      },
      error: (e) => {
        console.log(e)
      }
    })
  }

  onCloseClick () {
    this.animate = false;
    setTimeout(() => {
      this.close.emit()
    }, 300);

  }

  announcementObj: announcementForm = {
    name: "",
    max_dimentions: null,
    goods_type: "",
    capacity: null,
    journy_id: null
  }
  onCreateAnnouncementSubmit (form: FormsModule) {
    this.announcementService.createAnnouncement(this.announcementObj).subscribe({
      next: (res: Announcement) => {
        console.log(res)
      },
      error: e => {
        console.log(e.error);
      }
    })
  }

}
