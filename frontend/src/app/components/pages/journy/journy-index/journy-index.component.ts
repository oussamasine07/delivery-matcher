import {Component, inject, Input, OnInit} from '@angular/core';
import {Journy} from '../../../../models/interfaces/journy';
import {JournyService} from '../../../../services/journy/journy.service';
import {NgFor, NgIf} from '@angular/common';
import {JournyCreateComponent} from '../journy-create/journy-create.component';
import {JournyUpdateComponent} from '../journy-update/journy-update.component';
import {JournyDeleteComponent} from '../journy-delete/journy-delete.component';

@Component({
  selector: 'app-journy-index',
  imports: [
    NgFor,
    JournyCreateComponent,
    NgIf,
    JournyUpdateComponent,
    JournyDeleteComponent
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

  @Input() deleteJourny: Journy | null = null;
  showDeleteModal = false;
  openDeleteModal (journy: Journy) {
    this.deleteJourny = journy;
    this.showDeleteModal = true
  }
  closeDeleteModal () {
    this.showDeleteModal = false;
  }
  updateJourniesOnDelete (journy: Journy) {
    this.journies = this.journies.filter(j => j.id != journy.id )
    this.closeDeleteModal()
  }


}












