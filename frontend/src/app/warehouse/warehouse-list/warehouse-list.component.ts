import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Warehouse } from 'src/app/model/warehouse';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.css']
})
export class WarehouseListComponent implements OnInit {

  all: Warehouse[] = [];
  searchWarehousesForm: FormGroup;

  constructor(private warehouseService: WarehouseService) {
    this.warehouseService.getAll().subscribe(
      (warehouse: Warehouse[]) => {
        this.all = warehouse;
        console.log(warehouse);
      },
      (error) => console.log(error)
    ); 
  }

  delete(id: number){
   this.warehouseService.delete(id).subscribe(() => {
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
    this.searchWarehousesForm = new FormGroup({
      searchQuery: new FormControl()
    });
  }

  loggedIn(): boolean {
    // return this.authService.loggedIn();
    return true;
  }
  isAdmin(): boolean {
    // return this.authService.isAdmin();
    return true;
  }

  search(name){
   this.warehouseService.getAllByName(name).subscribe(
      (p: Warehouse[]) =>{
         this.all = p;
         console.log(p);
      },
        (error) => console.log(error)
      );
    console.log(name);
  }

}
