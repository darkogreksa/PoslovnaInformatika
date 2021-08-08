import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { AuthenticationService } from '../services/authentication/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public user: any;
  public wrongUsernameOrPass: boolean;

  constructor(private authenticationService: AuthenticationService, private router: Router) { 
    this.user = {};
    this.wrongUsernameOrPass = false;

    const isLoggedIn = this.authenticationService.isLoggedIn();
    if (isLoggedIn) {
      // TODO - check role here
      this.router.navigate(['/employee-landing']);
    }
  }

  ngOnInit(): void {
  }

  login(): void {
    this.authenticationService.login(this.user.username, this.user.password).subscribe(
      (loggedIn: boolean) => {
        if (loggedIn) {
          // const userRole = this.authenticationService.getTokenInfo().role;
          // if (userRole.includes('ADMINISTRATOR')) {
          //   this.router.navigate(['/secretAdminPage']);
          // }
          this.router.navigate(['/employee-landing']);
        }
      }
      ,
      (err: Error) => {
        if (err.toString() === 'Ilegal login') {
          this.wrongUsernameOrPass = true;
          console.log(err);
        } else {
          throwError(err);
        }
      });
  }

}
