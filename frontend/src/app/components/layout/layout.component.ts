import {Component, inject, OnInit} from '@angular/core';
import {SidebarComponent} from '../partials/sidebar/sidebar.component';
import {NavbarComponent} from '../partials/navbar/navbar.component';
import {Router, RouterOutlet} from '@angular/router';
import {routes} from '../../app.routes';

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
export class LayoutComponent implements OnInit {

  router: Router = inject(Router)

  token: string | null | undefined = localStorage.getItem("token") ? localStorage.getItem("token") : null;

  ngOnInit() {

    console.log(this.token)

    if ( !this.token ) {
      this.router.navigate(["/"])
    }
  }

}
