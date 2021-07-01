import { Component, OnInit } from '@angular/core';
import { BusinessPartner } from 'src/app/model/business-partner';
import { BusinessPartnerService } from 'src/app/services/business-partner.service';

@Component({
  selector: 'app-business-partner-list',
  templateUrl: './business-partner-list.component.html',
  styleUrls: ['./business-partner-list.component.css']
})
export class BusinessPartnerListComponent implements OnInit {

  all: BusinessPartner[] = [];
  name: string;

  ngOnInit() {
  }

  constructor(
    private partnerService: BusinessPartnerService,
  ) {
    this.partnerService.getAll().subscribe(
      (partner: BusinessPartner[]) => {
        this.all = partner;
      },
      (error) => console.log(error)
    );
  }

  delete(id: number) {
    this.partnerService.delete(id).subscribe(() => {
      for (let i = 0; i < this.all.length; i++) {
        if (this.all[i].id === id) {
          this.all.splice(i, 1);
        }
      }
    }, error => {
        console.log(error);
    });
  }

  search(name){
   this.partnerService.getAllByName(name).subscribe(
      (p: BusinessPartner[]) =>{
         this.all = p;
         console.log(p);
      },
        (error) => console.log(error)
      );
    console.log(name);
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

