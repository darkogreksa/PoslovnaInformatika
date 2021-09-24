import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Warehouse } from 'src/app/model/warehouse';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-warehouse-edit',
  templateUrl: './warehouse-edit.component.html',
  styleUrls: ['./warehouse-edit.component.css']
})
export class WarehouseEditComponent implements OnInit {

  editWarehouseForm: FormGroup;
  warehouse: Warehouse;
  sub: Subscription;

  constructor(
    private warehouseService: WarehouseService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.editWarehouseForm = new FormGroup({
      inputName: new FormControl()
    });
    this.sub = this.route.params.subscribe(params =>{
      const id = params['id'];
      if(id){
        this.warehouseService.getOne(id).subscribe((w: Warehouse) =>{
          if(w){
            this.warehouse = w;
          }else{
            alert("Ne postoji traženi magacin!")
          }
        });
      }
    });
  }

  edit(w: Warehouse, id: number) {
    const name: string = this.editWarehouseForm.controls.inputName.value;

    this.warehouse.name = name;
    this.warehouseService.edit(w, id).subscribe(warehouse => {
      this.warehouse;
      this.router.navigateByUrl("/warehouse");
    });
  }

}
