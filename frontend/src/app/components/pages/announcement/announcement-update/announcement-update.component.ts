import {Component, EventEmitter, inject, Input, OnInit, Output} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgClass, NgForOf, NgIf} from '@angular/common';
import {Journy} from '../../../../models/interfaces/journy';
import {JournyService} from '../../../../services/journy/journy.service';
import {AnnouncementService} from '../../../../services/announcement/announcement.service';
import {Announcement} from '../../../../models/interfaces/announcement';
import {announcementForm} from '../../../../models/types/annoucementForm';

@Component({
  selector: 'app-announcement-update',
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './announcement-update.component.html',
  styleUrl: './announcement-update.component.css'
})
export class AnnouncementUpdateComponent implements OnInit {

  journyService: JournyService = inject(JournyService);
  annoucementService: AnnouncementService = inject(AnnouncementService);

  @Input() currentAnnoucement: Announcement | null = null;

  @Output() close = new EventEmitter();
  animate = false

  onCloseClick () {
    this.animate = false;
    setTimeout(() => {
      this.close.emit()
    }, 300);
  }

  journies: Journy[] = [];
  fieldErrors: Record<string, string|string[]> = {};


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

    this.announcementObj = {
      name: this.currentAnnoucement?.name || "",
      max_dimentions: this.currentAnnoucement?.maxDimentions || null,
      goods_type: this.currentAnnoucement?.goodsType || "",
      capacity: this.currentAnnoucement?.capacity || null,
      journy_id: null
    }
  }

  @Output() emitUpdatedAnnouncement = new EventEmitter();
  announcementObj: announcementForm = {
    name: "",
    max_dimentions: null,
    goods_type: "",
    capacity: null,
    journy_id: null
  }
  onUpdateAnnouncementSubmit(form: FormsModule) {
    console.log(this.announcementObj);
    this.annoucementService.updateAnnouncement(this.announcementObj, this.currentAnnoucement?.id).subscribe({
      next: (ann: Announcement) => {
        this.emitUpdatedAnnouncement.emit(ann);
        this.announcementObj = {
          name: "",
          max_dimentions: null,
          goods_type: "",
          capacity: null,
          journy_id: null
        }
        this.onCloseClick();
      },
      error: (e) => {
        console.log(e.error)
      }
    })
  }
}










