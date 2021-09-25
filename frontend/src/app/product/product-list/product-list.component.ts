import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Product } from 'src/app/model/product';
import { ProductPage } from 'src/app/model/product-page';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  allProducts: Product[] = [];
  searchProductForm: FormGroup;
  totalLength: any;
  page: number = 1;

  constructor(private productService: ProductService) {
    this.productService.getAll().subscribe(
      (products: Product[]) => {
        this.allProducts = products;
      },
      (error) => console.log(error)
    ); }

  ngOnInit() {
    this.totalLength = this.allProducts.length;
    this.searchProductForm = new FormGroup({
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

  delete(id: number) {
    this.productService.delete(id).subscribe(() => {
      for (let i = 0; i < this.allProducts.length; i++) {
        if (this.allProducts[i].id === id) {
          this.allProducts.splice(i, 1);
        }
      }
    }, error => {
     
    });
  }

  search(name){
   this.productService.getAllByName(name).subscribe(
      (p: Product[]) =>{
         this.allProducts = p;
         console.log(p);
      },
        (error) => console.log(error)
      );
    console.log(name);
  }
}
