import {Component, EventEmitter, inject, Input, OnInit, Output} from '@angular/core';
import {Announcement} from '../../../../models/interfaces/announcement';
import {NgClass, NgIf} from '@angular/common';
import {applicationForm} from '../../../../models/types/applicationForm';
import {FormsModule} from '@angular/forms';
import {ApplicationService} from '../../../../services/application/application.service';
import {Application} from '../../../../models/interfaces/application';

@Component({
  selector: 'app-apply-modal',
  imports: [
    NgClass,
    FormsModule,
    NgIf
  ],
  templateUrl: './apply-modal.component.html',
  styleUrl: './apply-modal.component.css'
})
export class ApplyModalComponent implements OnInit {

  applicationService: ApplicationService = inject( ApplicationService );

  animate = false
  ngOnInit() {
    setTimeout(() => {
      this.animate = true;
    }, 10);

    this.applicationObj.announcement_id = this.currentAnnouncement?.id;
  }

  @Output() close = new EventEmitter();
  @Input() currentAnnouncement: Announcement | null = null;
  onCloseClick () {
    this.animate = false;
    setTimeout(() => {
      this.close.emit()
    }, 300);
  }



  fieldErrors: Record<string, string|string[]> = {};
  applicationObj: applicationForm = {
    application_date: "",
    width: null,
    hight: null,
    weight: null,
    type: "",
    announcement_id: null
  }
  onApplyForAnnouncementSubmit (form: FormsModule) {
    this.applicationService.applyForAnnouncement(this.applicationObj).subscribe({
      next: (res: Application) => {
        this.onCloseClick();
      },
      error: e => {
        console.log(e.error)
      }
    })
  }

}
