import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
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

  partner: BusinessPartner;
  editBP:  FormGroup;
  formBuilder : FormBuilder;
  sub: Subscription;

  constructor(private partnerService: BusinessPartnerService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.editBP = new FormGroup({
      inputName: new FormControl(),
      inputPib: new FormControl(),
      inputAddress: new FormControl(),
    });
    
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.partnerService.getId(id).subscribe((p: BusinessPartner) => {
          if (p) {
            console.log(p);
            this.partner = p;
          } else {
              alert("Nepostojeci partner");
          }
        });
      }
    });
  }

  edit(partner: BusinessPartner, id){
    console.log(id);
    const name: string = this.editBP.controls.inputName.value;
    const pib: any = this.editBP.controls.inputPib.value;
    const address: any = this.editBP.controls.inputAddress.value;

    this.partner.name = name;
    this.partner.pib = pib;
    this.partner.address = address;

    console.log(partner);

    this.partnerService.edit(partner, id).subscribe(partner => this.partner);
    window.location.replace("business-partner");
  }
}
