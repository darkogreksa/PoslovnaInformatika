import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Warehouse } from 'src/app/model/warehouse';
import { CompanyService } from 'src/app/services/company.service';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-warehouse-add',
  templateUrl: './warehouse-add.component.html',
  styleUrls: ['./warehouse-add.component.css']
})
export class WarehouseAddComponent implements OnInit {

  addWarehouseForm: FormGroup;
  warehouse: Warehouse;
  companies: any[];
  company: any;

  constructor(
    private warehouseService: WarehouseService,
    private companyService: CompanyService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.companyService.getAll().subscribe(c => {
      this.companies = c;
    })
    this.createForm();
  }

  createForm() {
    this.addWarehouseForm = this.formBuilder.group({
      inputName: ['', Validators.required],
      inputCompany: new FormControl()
    });
  }

  onSubmit() {
    const name: string = this.addWarehouseForm.controls.name.value;
    const company: any = this.addWarehouseForm.controls.name.value;

    this.warehouse = new Warehouse(0, name, company);

    this.warehouseService.add(this.warehouse).subscribe(warehouse => this.warehouse);
    this.router.navigateByUrl("/warehouse");
  }

}
