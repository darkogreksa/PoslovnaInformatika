import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BusinessYear } from 'src/app/model/business-year';
import { Company } from 'src/app/model/company';
import { BusinessYearService } from 'src/app/services/business-year.service';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-business-year-add',
  templateUrl: './business-year-add.component.html',
  styleUrls: ['./business-year-add.component.css']
})
export class BusinessYearAddComponent implements OnInit {

  by: BusinessYear;
  addBusinessYearForm: FormGroup;
  companies: any[];
  company: any;

  constructor(private byService: BusinessYearService, private router: Router, private companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getAll().subscribe(res => {
      this.companies = res;
    });

    this.addBusinessYearForm = new FormGroup({
      inputYear: new FormControl(),
      inputClosed: new FormControl(),
      inputCompany: new FormControl()
    });
  }

  onChangeCompany(value: any){
    console.log(value);
  }

  onSubmit(){
    const year: string = this.addBusinessYearForm.controls.inputYear.value;
    const companyId: any = this.addBusinessYearForm.controls.inputCompany.value;
    const closed: boolean = this.addBusinessYearForm.controls.inputClosed.value;

    this.company = this.companies.filter(x => x.id == companyId)[0];
    this.by = new BusinessYear(0, year, this.company as Company, closed);
    console.log(this.by);

    this.byService.add(this.by).subscribe(by => {
      this.by;
      this.router.navigateByUrl("/business-year");
    });
  }

}
