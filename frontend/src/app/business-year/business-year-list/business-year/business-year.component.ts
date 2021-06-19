import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { throwIfEmpty } from 'rxjs/operators';
import { BusinessYear } from 'src/app/model/business-year';
import { BusinessYearService } from 'src/app/services/business-year.service';

@Component({
  selector: 'app-business-year',
  templateUrl: './business-year.component.html',
  styleUrls: ['./business-year.component.css']
})
export class BusinessYearComponent implements OnInit {

  all: BusinessYear[] = [];

  constructor(private byService: BusinessYearService, private router: Router) {
    this.byService.getAll().subscribe(
      (by: BusinessYear[]) => {
        this.all = by;
      },
      (error) => console.log(error)
    );
   }

  ngOnInit() {
  }

  delete(by: BusinessYear){
    if(confirm("Da li ste sigurni da zelite da obrisete "+by.year)){
      this.byService.delete(by.id).subscribe(() => {
        // this.router.navigateByUrl("/business-year");
        // this.router.onSameUrlNavigation;
        window.location.reload();
      });
      // window.location.reload();
    }
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
