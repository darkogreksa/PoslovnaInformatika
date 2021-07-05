import { Injectable } from "@angular/core";
import { Adapter } from "../helpers/adapter";

export class Product {

    constructor(
        public id: number,
        public name: string,
        public grouoOfProductId: any,
        public unitDTO: any
    ) { }
}

@Injectable({
    providedIn: 'root'
})
export class ProductAdapter implements Adapter<Product> {
    adapt(item: any): Product {
        return new Product(
            item.id,
            item.name,
            item.grouoOfProductId,
            item.unitDTO
        );
    }
}
