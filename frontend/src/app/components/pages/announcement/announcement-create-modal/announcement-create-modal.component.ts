import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-announcement-create-modal',
  imports: [
    NgClass
  ],
  templateUrl: './announcement-create-modal.component.html',
  styleUrl: './announcement-create-modal.component.css'
})
export class AnnouncementCreateModalComponent implements OnInit {

  @Output() close = new EventEmitter();

  animate = false;

  ngOnInit() {
    setTimeout(() => {
      this.animate = true;
    }, 10)
  }

  onCloseClick () {
    this.animate = false;
    setTimeout(() => {
      this.close.emit()
    }, 300);

  }

}
