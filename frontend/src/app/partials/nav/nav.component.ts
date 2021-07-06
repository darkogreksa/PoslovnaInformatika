import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  model: any = {};
  isUserLogged = false;
  name;
  constructor(private router: Router) {}

  ngOnInit() {
    if (localStorage.getItem("userInfo")) {
      this.name = JSON.parse(localStorage.getItem("userInfo"));
      this.name = this.name.username;
      this.isUserLogged = true;
    }
  }

  logout() {
    localStorage.removeItem("userInfo");
    localStorage.removeItem("token");
    this.isUserLogged = false;
    this.router.navigateByUrl("/login");
  }
}
