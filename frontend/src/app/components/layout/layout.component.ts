import { Component } from '@angular/core';
import {SidebarComponent} from '../partials/sidebar/sidebar.component';
import {NavbarComponent} from '../partials/navbar/navbar.component';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-layout',
  imports: [
    SidebarComponent,
    NavbarComponent,
    RouterOutlet
  ],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent {

}
