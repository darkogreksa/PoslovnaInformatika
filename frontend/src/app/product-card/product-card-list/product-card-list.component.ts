import { Component, OnInit } from '@angular/core';
import { Warehouse } from 'src/app/model/warehouse';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-product-card-list',
  templateUrl: './product-card-list.component.html',
  styleUrls: ['./product-card-list.component.css']
})
export class ProductCardListComponent implements OnInit {

  companyWarehouses: Warehouse[] = [];

  constructor(private warehouseService: WarehouseService) {
    var companyId = this.getCompanyId();
    this.warehouseService.getAllByCompany(companyId).subscribe(
      (warehouse: Warehouse[]) => {
        this.companyWarehouses = warehouse;
        console.log(this.companyWarehouses);
      },
      (error) => console.log(error)
    );
    console.log('companyWarehouses:');
    
  }

  ngOnInit(): void {
  }

  getCompanyId(): any {
    return localStorage.getItem('companyId') || null;
  }

}
