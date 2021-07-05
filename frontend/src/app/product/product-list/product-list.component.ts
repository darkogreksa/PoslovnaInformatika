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
  productPage: ProductPage;
  searchProductForm: FormGroup;
  currentPage: number;
  itemsPerPage: number;

  constructor(private productService: ProductService) {
    this.productService.getAll().subscribe(
      (products: Product[]) => {
        this.allProducts = products;
      },
      (error) => console.log(error)
    ); }

  ngOnInit() {
    this.searchProductForm = new FormGroup({
      searchQuery: new FormControl()
    });
    // this.getProductPage(0, 10);
  }

  // getProductPage(page: number, size:number) {
  //   this.productService.getAllPaged(page, size)
  //     .subscribe(page => {
  //       this.productPage = page;
  //       this.allProducts = page.content;
  //     });
  // }

  // pageChanged(event: any): void {
  //   this.currentPage = event.page;
  //   this.itemsPerPage = event.itemsPerPage;
  //   this.getProductPage(this.currentPage - 1, this.itemsPerPage); //api broji stranice od nule, stoga mora -1
  // }

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
}
