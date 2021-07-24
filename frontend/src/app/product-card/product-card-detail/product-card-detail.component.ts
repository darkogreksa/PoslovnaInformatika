import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ProductCard } from 'src/app/model/product-card';
import { ProductCardService } from 'src/app/services/product-card.service';

@Component({
  selector: 'app-product-card-detail',
  templateUrl: './product-card-detail.component.html',
  styleUrls: ['./product-card-detail.component.css']
})
export class ProductCardDetailComponent implements OnInit {

  sub: Subscription;
  productCard: ProductCard;

  constructor(private productCardService: ProductCardService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params["id"];
      if(id){
        this.productCardService.getId(id).subscribe(res => {
            this.productCard = res;
            console.log(this.productCard);
          },
          (error) => console.log(error)
        );
      }
    });
  }

}
