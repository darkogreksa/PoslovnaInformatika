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

  constructor(private businessPartnerService: BusinessPartnerService) {
    this.businessPartnerService.getAll().subscribe(
      (businessPartner: BusinessPartner[]) => {
        this.all = businessPartner;
      },
      (error) => console.log(error)
    ); }

  ngOnInit() {
  }

  delete(id: number) {
    this.businessPartnerService.delete(id).subscribe(() => {
      for (let i = 0; i < this.all.length; i++) {
        if (this.all[i].id === id) {
          //splice dodaje element u listu
          this.all.splice(i, 1);
        }
      }
    }, error => {
        console.log(error);
    });
  }

  search(name: any){
   this.businessPartnerService.getAllByName(name).subscribe(
      (bp: BusinessPartner[]) =>{
         this.all = bp;
         console.log(bp);
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
