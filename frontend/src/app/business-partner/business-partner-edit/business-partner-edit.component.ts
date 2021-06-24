import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BusinessPartner } from 'src/app/model/business-partner';
import { BusinessPartnerService } from 'src/app/services/business-partner.service';

@Component({
  selector: 'app-business-partner-edit',
  templateUrl: './business-partner-edit.component.html',
  styleUrls: ['./business-partner-edit.component.css']
})
export class BusinessPartnerEditComponent implements OnInit {

  businessPartner: BusinessPartner;
  editPartnerForm: FormGroup;
  formBuilder: FormBuilder;
  sub: Subscription;

  constructor(private businessPartnerService: BusinessPartnerService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  edit(businessPartner: BusinessPartner, id: number){
    console.log(id);
    const name: string = this.editPartnerForm.controls.inputName.value;
    const pib: any = this.editPartnerForm.controls.inputPib.value;
    const address: any = this.editPartnerForm.controls.inputAddress.value;

    this.businessPartner.name = name;
    this.businessPartner.pib = pib;
    this.businessPartner.address = address;

    console.log(businessPartner);

    this.businessPartnerService.edit(businessPartner, id).subscribe(businessPartner => this.businessPartner);
    window.location.replace("businessPartner");
  }

}
