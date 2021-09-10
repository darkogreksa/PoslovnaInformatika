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
  triggered: boolean;
  id: number;


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

  refreshCard(id: number) {
    this.productCardService.getId(id).subscribe((k: any) => {
      if (k) {
        console.log(k);
        this.productCard = k;
      }
    });
  }

  nivelacija(){
    this.productCardService.nivelacija(this.productCard.id).subscribe(res => {
      if (res == true) {
        this.refreshCard(this.id);
        // this.ngOnInit();
      }
      this.triggered = true;
      console.log(res);
    });
  }

}
