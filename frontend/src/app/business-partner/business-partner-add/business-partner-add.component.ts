import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BusinessPartner } from 'src/app/model/business-partner';
import { BusinessPartnerService } from 'src/app/services/business-partner.service';

@Component({
  selector: 'app-business-partner-add',
  templateUrl: './business-partner-add.component.html',
  styleUrls: ['./business-partner-add.component.css']
})
export class BusinessPartnerAddComponent implements OnInit {

  parnter: BusinessPartner;
  addPartnerForm:  FormGroup;

  constructor(private partnerService: BusinessPartnerService, private fb: FormBuilder, private router: Router) {}

   ngOnInit() {
    this.addPartnerForm = new FormGroup({
      inputName: new FormControl(),
      inputPib: new FormControl(),
      inputAddress: new FormControl(),
    });
    this.createForm();
  }
 
  createForm() {
    this.addPartnerForm = this.fb.group({
      inputName: ['', Validators.required],
      inputPib: ['', Validators.required],
      inputAddress: ['', Validators.required]
    });
  }

  onSubmit(){
    const name: string = this.addPartnerForm.controls.inputName.value;
    const pib: any = this.addPartnerForm.controls.inputPib.value;
    const address: any = this.addPartnerForm.controls.inputAddress.value;

    this.parnter = new BusinessPartner(0, name, pib, address);

    this.partnerService.add(this.parnter).subscribe(partner => this.parnter);
    this.router.navigateByUrl("/business-partner");
  }
}
