import {Component, inject, OnInit} from '@angular/core';
import {loginForm} from '../../../models/types/loginForm';
import {FormsModule} from '@angular/forms';
import {AuthService} from '../../../services/auth/auth.service';
import {Token} from '../../../models/interfaces/token';
import {NgClass, NgIf} from '@angular/common';
import {Router} from '@angular/router';
import {routes} from '../../../app.routes';


@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
    NgClass,
    NgIf
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  token: string | null | undefined = localStorage.getItem("token") ? localStorage.getItem("token") : null;
  router: Router = inject(Router)

  authService: AuthService = inject(AuthService);

  fieldErrors: Record<string, string|string[]> = {};

  loginObj: loginForm = {
    email: "",
    password: "",
    type: ""
  }
  onLoginSubmit (form: FormsModule) {
    this.authService.authenticateUser(this.loginObj).subscribe({
      next: ( res: Token ) => {
        localStorage.setItem("token", res.token);
        this.fieldErrors = {}

        this.loginObj = {
          email: "",
          password: "",
          type: ""
        }
        this.router.navigate(["/app"])
      },
      error: ( e ) => {
        this.fieldErrors = e.error
        console.log(this.fieldErrors)
      }
    })
  }

  ngOnInit() {
    if ( this.token ) {
      this.router.navigate(["/app"]);
    }
  }

}
