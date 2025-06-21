import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';
import {NgFor} from '@angular/common';

@Component({
  selector: 'app-sidebar',
  imports: [
    RouterLink,
    NgFor
  ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {
  sidebarItems = [
    {
      name: "Dashboard",
      icon: "fas fa-tachometer-alt mr-3",
      url: "/app"
    },
    {
      name: "Announcements",
      icon: "fas fa-bullhorn mr-3",
      url: "/app/announcement"
    },
    {
      name: "Journies",
      icon: "fas fa-route mr-3",
      url: "/app/journy"
    }
  ]
}
