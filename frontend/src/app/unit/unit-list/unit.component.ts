import { Component, OnInit } from '@angular/core';
import { Unit } from '../../model/unit';
import { UnitService } from '../../services/unit.service';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.css']
})
export class UnitComponent implements OnInit {

  all: Unit[] = [];

  constructor(private unitService: UnitService) {
    this.unitService.getAll().subscribe(
      (unit: Unit[]) => {
        this.all = unit;
        console.log(this.all);
      },
      (error) => console.log(error)
    );
   }

   delete(id: number){
    this.unitService.delete(id).subscribe(() => {
      for(let i=0; i<this.all.length; i++){
        if(this.all[i].id === id){
          this.all.splice(i, 1);
        }
      }
    }, error => {
      console.log(error);
    });
  }

  ngOnInit(): void {
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
