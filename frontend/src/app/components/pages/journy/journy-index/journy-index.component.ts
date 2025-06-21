import {Component, inject, Input, OnInit} from '@angular/core';
import {Journy} from '../../../../models/interfaces/journy';
import {JournyService} from '../../../../services/journy/journy.service';
import {NgFor, NgIf} from '@angular/common';
import {JournyCreateComponent} from '../journy-create/journy-create.component';
import {JournyUpdateComponent} from '../journy-update/journy-update.component';

@Component({
  selector: 'app-journy-index',
  imports: [
    NgFor,
    JournyCreateComponent,
    NgIf,
    JournyUpdateComponent
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

  @Input() updateJourny: Journy | null = null;
  showUpdateModal = false;
  openUpdateModal ( journy : Journy) {
    this.updateJourny = journy;
    this.showUpdateModal = true;
  }
  closeUpdateModal () {
    this.showUpdateModal = false;
  }
  updateJournyOnEdit (j: Journy) {
    this.journies = this.journies.map(journy => j.id == journy.id ? j : journy)
  }


}












