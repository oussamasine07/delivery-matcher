import {Component, inject} from '@angular/core';
import {loginForm} from '../../../models/types/loginForm';
import {FormsModule} from '@angular/forms';
import {AuthService} from '../../../services/auth/auth.service';
import {Token} from '../../../models/interfaces/token';
import {NgClass, NgIf} from '@angular/common';


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
export class LoginComponent {

  authService: AuthService = inject(AuthService);

  fieldErrors: Record<string, string|string[]> = {};

  loginObj: loginForm = {
    email: "",
    password: "",
    type: ""
  }
  onLoginSubmit (form: FormsModule) {
    console.log(this.loginObj)
    this.authService.authenticateUser(this.loginObj).subscribe({
      next: ( res: Token ) => {
        localStorage.setItem("token", res.token);
        this.fieldErrors = {}

        this.loginObj = {
          email: "",
          password: "",
          type: ""
        }
      },
      error: ( e ) => {
        this.fieldErrors = e.error
        console.log(this.fieldErrors)
      }
    })
  }

}
