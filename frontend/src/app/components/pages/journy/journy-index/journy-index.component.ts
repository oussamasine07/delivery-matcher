import {Component, inject, OnInit} from '@angular/core';
import {Journy} from '../../../../models/interfaces/journy';
import {JournyService} from '../../../../services/journy/journy.service';
import {NgFor} from '@angular/common';

@Component({
  selector: 'app-journy-index',
  imports: [
    NgFor
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

}
