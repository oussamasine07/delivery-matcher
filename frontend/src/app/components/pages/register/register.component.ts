import {Component, inject} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgClass, NgIf} from "@angular/common";
import {registerForm} from '../../../models/types/registerForm';
import {AuthService} from '../../../services/auth/auth.service';
import {Router} from '@angular/router';
import {Driver} from '../../../models/interfaces/driver';
import {Sender} from '../../../models/interfaces/sender';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    NgIf,
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  token: string | null | undefined = localStorage.getItem("token") ? localStorage.getItem("token") : null;

  router: Router = inject(Router)

  authService: AuthService = inject(AuthService);

  fieldErrors: Record<string, string|string[]> = {};

  registerObj: registerForm = {
    first_name: "",
    last_name: "",
    email: "",
    password: "",
    confirmPassword: "",
    type: ""
  }

  onRegisterSubmit (form: FormsModule) {
    this.authService.registerUser(this.registerObj).subscribe({
      next: (res: Driver | Sender) => {
        console.log(res)
        this.registerObj = {
          first_name: "",
          last_name: "",
          email: "",
          password: "",
          confirmPassword: "",
          type: ""
        }

        this.router.navigate(["/"]);
      },
      error: ( e ) => {
        this.fieldErrors = e.error
      }
    })
  }

  ngOnInit() {
    if ( this.token ) {
      this.router.navigate(["/app"]);
    }
  }
}
