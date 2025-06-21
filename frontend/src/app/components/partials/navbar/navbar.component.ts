import {Component, inject} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  router: Router = inject(Router);

  onLogoutClick () {
    localStorage.removeItem("token");
    this.router.navigate(["/"]);
  }

}
