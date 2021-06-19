import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/model/company';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {

  all: Company[] = [];

  constructor(private companyService: CompanyService) {
    this.companyService.getAll().subscribe(
      (company: Company[]) => {
        this.all = company;
      },
      (error) => console.log(error)
    );
   }

  ngOnInit(): void {
  }

  loggedIn(): boolean {
    // return this.authService.loggedIn();
    return true;
  }
  isAdmin(): boolean {
    // return this.authService.isAdmin();
    return true;
  }

}
