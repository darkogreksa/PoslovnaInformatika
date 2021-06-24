import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BusinessYear } from 'src/app/model/business-year';
import { BusinessYearService } from 'src/app/services/business-year.service';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-business-year-edit',
  templateUrl: './business-year-edit.component.html',
  styleUrls: ['./business-year-edit.component.css']
})
export class BusinessYearEditComponent implements OnInit {

  by: BusinessYear;
  editBusinessYearForm: FormGroup;
  formBuilder: FormBuilder;
  sub: Subscription;
  companies: any[];
  company: any;

  constructor(private byService: BusinessYearService, private route: ActivatedRoute, private router: Router, private companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getAll().subscribe(c => {
      this.companies = c;
    });

    this.editBusinessYearForm = new FormGroup({
      inputYear: new FormControl(),
      inputClosed: new FormControl(),
      inputCompany: new FormControl()
    });

    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if(id){
        this.byService.getOne(id).subscribe((by: BusinessYear) =>{
          if(by){
            this.by = by;
          }else{
            alert("Ne postoji trazena poslovna godina")
          }
        });
      }
    });
  }

  edit(by: BusinessYear, id: any){
    const year: string = this.editBusinessYearForm.controls.inputYear.value;
    const closed: boolean = this.editBusinessYearForm.controls.inputClosed.value;
    const companyId: any = this.editBusinessYearForm.controls.inputCompany.value;

    this.company = this.companies.filter(x => x.id == companyId)[0];
    this.by.year = year;
    this.by.company = this.company;
    this.by.closed = closed;
    this.byService.edit(by, id).subscribe(by => {
      this.by;
      this.router.navigateByUrl("/business-year");
    });

  }

}
