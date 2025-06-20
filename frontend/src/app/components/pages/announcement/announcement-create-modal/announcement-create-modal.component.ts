import {Component, EventEmitter, inject, OnInit, Output} from '@angular/core';
import {NgClass, NgForOf} from '@angular/common';
import {Journy} from '../../../../models/interfaces/journy';
import {JournyService} from '../../../../services/journy/journy.service';

@Component({
  selector: 'app-announcement-create-modal',
  imports: [
    NgClass,
    NgForOf
  ],
  templateUrl: './announcement-create-modal.component.html',
  styleUrl: './announcement-create-modal.component.css'
})
export class AnnouncementCreateModalComponent implements OnInit {

  journyService: JournyService = inject(JournyService);

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

}
