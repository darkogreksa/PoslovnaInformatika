import { Component, OnInit } from '@angular/core';
import { Company } from '../model/company';
import { Warehouse } from '../model/warehouse';
import { CompanyService } from '../services/company.service';
import { WarehouseService } from '../services/warehouse.service';

@Component({
  selector: 'app-employee-landing-page',
  templateUrl: './employee-landing-page.component.html',
  styleUrls: ['./employee-landing-page.component.css']
})
export class EmployeeLandingPageComponent implements OnInit {

  companyWarehouses: Warehouse[] = [];
  username: String;
  company: Company;

  constructor(private warehouseService: WarehouseService, private companyService: CompanyService) { 
    this.username = this.getLoggedInUsername();
    var companyId = this.getCompanyId();

    this.warehouseService.getAllByCompany(companyId).subscribe(
      (warehouse: Warehouse[]) => {
        this.companyWarehouses = warehouse;
        console.log(this.companyWarehouses);
      },
      (error) => console.log(error)
    );

    this.companyService.getOne(companyId).subscribe(
      (company: Company) => {
        this.company = company;
        console.log(this.company);
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

  getCompanyId(): any {
    return localStorage.getItem('companyId') || null;
  }

  getLoggedInUsername(): any {
    return localStorage.getItem('sub') || null;
  }

}
