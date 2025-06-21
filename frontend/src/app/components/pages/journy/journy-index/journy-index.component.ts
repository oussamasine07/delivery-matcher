import {Component, inject, OnInit} from '@angular/core';
import {Journy} from '../../../../models/interfaces/journy';
import {JournyService} from '../../../../services/journy/journy.service';
import {NgFor, NgIf} from '@angular/common';
import {JournyCreateComponent} from '../journy-create/journy-create.component';

@Component({
  selector: 'app-journy-index',
  imports: [
    NgFor,
    JournyCreateComponent,
    NgIf
  ],
  templateUrl: './journy-index.component.html',
  styleUrl: './journy-index.component.css'
})
export class JournyIndexComponent implements OnInit {

  journyService: JournyService = inject(JournyService);
  journies: Journy[] = [];

  ngOnInit() {
    this.journyService.getAllJourniesByDriverId().subscribe({
      next: (jrs: Journy[]) => {
        this.journies = jrs;
      },
      error: e => {
        console.log(e);
      }
    })
  }

  showModal = false;
  openCreateModal () {
    this.showModal = true;
  }
  closeCreateModal () {
    this.showModal = false
  }

  addNewJourny (journy: Journy) {
    this.journies.push( journy );
  }

}
