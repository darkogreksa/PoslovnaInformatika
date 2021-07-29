import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductCard } from 'src/app/model/product-card';
import { ProductCardService } from 'src/app/services/product-card.service';
import { ProductService } from 'src/app/services/product.service';
import { WarehouseService } from 'src/app/services/warehouse.service';

@Component({
  selector: 'app-product-card-add',
  templateUrl: './product-card-add.component.html',
  styleUrls: ['./product-card-add.component.css']
})
export class ProductCardAddComponent implements OnInit {

  card: ProductCard;
  addProductCardForm: FormGroup;
  products;
  warehouses;
  productId;

  productCard = {
    price: 0,
    initialStateQuantity: 0,
    initialStateValue: 0,
    inboundTrafficQuantity: 0,
    inboundTrafficValue: 0,
    outgoingTrafficQuantity: 0,
    outgoingTrafficValue: 0,
    totalAmount: 0,
    totalValue: 0,
    businessYear: new Object({}),
    product: new Object({}),
    warehouse: new Object({})
  }

  constructor(private cardService: ProductCardService, private fb: FormBuilder,
    private productService: ProductService, private warehouseService: WarehouseService,
    private router: Router) { }

  ngOnInit(): void {
    this.productService.getAll().subscribe(res => {this.products = res, this.productId = this.products[0].id });
    this.warehouseService.getAll().subscribe(res => this.warehouses = res);
    this.addProductCardForm = this.fb.group({
    });
    this.addProductCardForm = new FormGroup({
      inputPrice: new FormControl(),
      inputStateQuantity : new FormControl(),
      inputOutgoingTrafficQuantity : new FormControl(),
      inputOutgoingTrafficValue: new FormControl()
    });
    this.createForm();
  }
  
  createForm() {
    this.addProductCardForm = this.fb.group({
      inputPrice: ['', Validators.min(1)],
      inputStateQuantity: ['', Validators.min(1)]
    });
  }
  
  onChangeProduct(value: any){
    console.log(value);
    this.productCard.product = value;
  }

  onChangeWarehouse(value: any){
    console.log('warehouse ' + value);
    this.productCard.warehouse = value;
  }

  onSubmit() {
    const price: any = this.addProductCardForm.controls.inputPrice.value;
    const initialStateQuantity: any = this.addProductCardForm.controls.inputStateQuantity.value;
    let year = this.productCard.businessYear;
    let product = this.productCard.product;
    let warehouse = this.productCard.warehouse;

    this.productCard.price = price;
    this.productCard.initialStateQuantity = initialStateQuantity;
    this.productCard.initialStateValue = price * initialStateQuantity;
    this.productCard.product = {"id": product};
    this.productCard.warehouse = {"id": warehouse};
    this.productCard.businessYear = {"id": 5};
    this.productCard.totalAmount = initialStateQuantity;
    this.productCard.totalValue = this.productCard.initialStateValue;

    console.log(this.productCard);

    this.cardService.add(this.productCard).subscribe(card => {
      this.router.navigateByUrl("/product-card")
    })
  }

}
