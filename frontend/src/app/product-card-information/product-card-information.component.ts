import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ProductCard } from 'src/app/model/product-card';
import { ProductCardService } from 'src/app/services/product-card.service';

@Component({
  selector: 'app-product-card-information',
  templateUrl: './product-card-information.component.html',
  styleUrls: ['./product-card-information.component.css']
})
export class ProductCardInformationComponent implements OnInit {

  productCards: ProductCard[] = [];
  sub: Subscription;

  constructor(private productCardService: ProductCardService, private route: ActivatedRoute, private router: Router) { 
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params["id"];
      if(id){
        this.productCardService.getAllByWarehouse(id).subscribe(
          (productCard: ProductCard[]) => {
            this.productCards = productCard;
            console.log(this.productCards);
          },
          (error) => console.log(error)
        );
      }
    });
  }

}
