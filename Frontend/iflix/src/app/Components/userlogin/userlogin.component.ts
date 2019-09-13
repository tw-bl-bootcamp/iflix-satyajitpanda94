import { Component, OnInit } from '@angular/core';
import { LoginInfo } from 'src/app/Model/login-info';
import { FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { HttpRequestService } from 'src/app/Services/http-request.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.scss']
})
export class UserloginComponent {
  hide: boolean = true;
  submited: boolean = false;
  userLoginModel: LoginInfo = new LoginInfo("", "");
  email = new FormControl("", [Validators.required, Validators.email]);
  password = new FormControl("", [Validators.required, Validators.minLength(6)]);

  constructor(private snackBar: MatSnackBar,
    private httpService: HttpRequestService,
    private router: Router,
    private authService: AuthService) { }

  getErrorMessageForEmail() {
    return this.email.hasError('required') ? 'You must enter a value' :
      this.email.hasError('email') ? 'Not a valid email' :
        '';
  }
  getErrorMessageForPassword() {
    return this.password.hasError('required') ? 'You must enter a value' :
      this.password.hasError('minlength') ? 'You must enter 6 digit password' :
        '';
  }
  enableLoginButton(): boolean {
    if ((this.email.invalid || this.password.invalid)) {
      return true;
    }
    else if (this.submited) {
      return true;
    }
    else {
      return false;
    }
  }

  onLogin() {
    this.userLoginModel = new LoginInfo(this.email.value, this.password.value);
    this.httpService.loginUser(this.userLoginModel)
      .subscribe(
        (response: any) => {
          if (response.status == 200) {
            this.authService.setIsLogged(true);
            this.router.navigate(['/movies']);
            this.snackBar.open(
              "Login Successfully",
              "", {
              duration: 2500
            }
            )
          }

          else {
            this.router.navigate(['']);
            this.snackBar.open(
              "Registration Failed",
              "",
              { duration: 2500 }
            );
          }
          this.submited = true;
        }
      )
  }
}
