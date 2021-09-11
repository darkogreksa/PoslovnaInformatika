import { ProductCard } from "./product-card";

export interface Analytics {
    id: number;
    ordinalNumber: number;
    trafficType: string;
    trafficDirection: string;
    quantity: number;
    price: number;
    value: number;
    product_card: ProductCard;
}
