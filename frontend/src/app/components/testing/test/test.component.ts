import {Component, inject, OnInit} from '@angular/core';
import {Announcement} from '../../../models/interfaces/announcement';
import {AnnouncementService} from '../../../services/announcement/announcement.service';

@Component({
  selector: 'app-test',
  imports: [],
  templateUrl: './test.component.html',
  styleUrl: './test.component.css'
})
export class TestComponent implements OnInit{
  annoucementService: AnnouncementService = inject(AnnouncementService);

  announcments: Announcement[] = [];

  ngOnInit() {
    this.annoucementService.getAllAnnouncements().subscribe({
      next: (res: Announcement[]) => {
        this.announcments = res;
      },
      error: e => {}
    })
  }
}
