import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Announcement} from '../../../../models/interfaces/announcement';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-apply-modal',
  imports: [
    NgClass
  ],
  templateUrl: './apply-modal.component.html',
  styleUrl: './apply-modal.component.css'
})
export class ApplyModalComponent implements OnInit {
  animate = false

  ngOnInit() {
    setTimeout(() => {
      this.animate = true;
    }, 10);
  }

  @Output() close = new EventEmitter();
  @Input() currentAnnouncement: Announcement | null = null;
  onCloseClick () {
    this.animate = false;
    setTimeout(() => {
      this.close.emit()
    }, 300);
  }

}
