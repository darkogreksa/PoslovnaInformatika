import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BusinessPartner } from 'src/app/model/business-partner';
import { BusinessPartnerService } from 'src/app/services/business-partner.service';

@Component({
  selector: 'app-business-partner-add',
  templateUrl: './business-partner-add.component.html',
  styleUrls: ['./business-partner-add.component.css']
})
export class BusinessPartnerAddComponent implements OnInit {

  businessPartner: BusinessPartner;
  addBPartnerForm: FormGroup;

  constructor(private bpService: BusinessPartnerService, private fb: FormBuilder) { }

  ngOnInit() {
    this.addBPartnerForm = new FormGroup({
      inputName: new FormControl(),
      inputPib: new FormControl(),
      inputAddress: new FormControl(),
    });
    this.createForm();
  }
 
  createForm() {
    this.addBPartnerForm = this.fb.group({
      inputName: ['', Validators.required],
      inputPib: ['', Validators.required],
      inputAddress: ['', Validators.required]
    });
  }

  onSubmit(){
    const name: string = this.addBPartnerForm.controls.inputName.value;
    const pib: any = this.addBPartnerForm.controls.inputPib.value;
    const address: any = this.addBPartnerForm.controls.inputAddress.value;

    this.businessPartner = new BusinessPartner(0, name, pib, address);

    this.bpService.add(this.businessPartner).subscribe(businessPartner => this.businessPartner);
  }

}
