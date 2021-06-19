import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Company } from 'src/app/model/company';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-company-add',
  templateUrl: './company-add.component.html',
  styleUrls: ['./company-add.component.css']
})
export class CompanyAddComponent implements OnInit {

  company: Company;
  addCompanyForm: FormGroup;

  constructor(private companyService: CompanyService) { }

  ngOnInit(): void {
  }
 
  onSubmit(){
    const name: string = this.addCompanyForm.controls.inputName.value;
    const pib: any = this.addCompanyForm.controls.inputPib.value;
    const address: any = this.addCompanyForm.controls.inputAddress.value;

    this.company = new Company(name, pib, address);

    this.companyService.add(this.company).subscribe(company => this.company);
    window.location.replace("company");
  }

}
