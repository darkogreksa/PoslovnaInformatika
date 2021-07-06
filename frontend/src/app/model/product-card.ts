import { DecimalPipe } from "@angular/common";
import { Injectable } from "@angular/core";
import { Product } from "./product";
import { Warehouse } from "./warehouse";

@Injectable()
export class ProductCard {
    constructor(    
        public id : number,
        public price: DoubleRange,
        public initialStateQuantity: DecimalPipe,
        public initialStateValue: DecimalPipe,
        public inboundTrafficQuantity: string,
        public inboundTrafficValue: string,
        public outgoingTrafficQuantity: number,
        public outgoingTrafficValue: DecimalPipe,
        public totalAmount: number,
        public totalValue: DoubleRange,
        public product: Product,
        public warehouse: Warehouse
    ) {}
}
