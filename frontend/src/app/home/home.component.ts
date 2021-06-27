import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public user: any;
  public wrongUsernameOrPass: boolean;

  constructor() { 
    this.user = {};
    this.wrongUsernameOrPass = false;
  }

  ngOnInit(): void {
  }

}
