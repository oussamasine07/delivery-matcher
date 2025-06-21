import {Component, EventEmitter, inject, Input, OnInit, Output} from '@angular/core';
import {JournyService} from '../../../../services/journy/journy.service';
import {Journy} from '../../../../models/interfaces/journy';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-journy-delete',
  imports: [
    NgClass
  ],
  templateUrl: './journy-delete.component.html',
  styleUrl: './journy-delete.component.css'
})
export class JournyDeleteComponent implements OnInit {

  journyService: JournyService = inject(JournyService)

  @Input() currentJourny: Journy | null = null;
  @Output() confiremDelete = new EventEmitter();
  @Output() cancelDelete = new EventEmitter();
  animate = false;

  ngOnInit() {
    setTimeout(() => {
      this.animate = true
    }, 10);
  }

  onConfirmDeleteClick () {
    this.journyService.deleteJourny(this.currentJourny?.id).subscribe({
      next: (res) => {
        this.confiremDelete.emit( res )
      },
      error: e => {
        console.log(e.error);
      }
    })
  }

  onCancelDeleteClick () {
    this.cancelDelete.emit();
  }

}
