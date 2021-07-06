import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { Unit } from 'src/app/model/unit';
import { ProductService } from 'src/app/services/product.service';
import { UnitService } from 'src/app/services/unit.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  groupsOfProduct: any[];
  units: any[];
  addProductForm: FormGroup;
  product: Product;
  groupOfProduct: any;
  unit: any;

  constructor(
    private productService: ProductService,
    private unitService: UnitService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.unitService.getAll().subscribe(u => {
      this.units = u;
    });

    this.addProductForm = new FormGroup({
      inputName: new FormControl('', Validators.required),
      inputGroup: new FormControl(),
      inputUnit: new FormControl(),
    });
  }

  onSubmit() {
    const name: string = this.addProductForm.controls.inputName.value;
    const groupId: any = this.addProductForm.controls.inputGroup.value;
    const unitId: any = this.addProductForm.controls.inputUnit.value;

    this.unit = this.units.filter(x => x.id == unitId)[0];

    this.product = new Product(
      0,
      name,
      1,
      this.unit as Unit
    );

    this.productService.add(this.product).subscribe( () => {
      this.router.navigateByUrl('/product');
    });
  }
}
