import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductCard } from '../model/product-card';

@Injectable({
  providedIn: 'root'
})
export class ProductCardService {
  private baseUrl = "http://localhost:8080/api/product-card";
  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(this.baseUrl + "/all");
  }

  getAllByWarehouse(id): Observable<ProductCard[]>{
    const url = this.baseUrl + '/' + id + '/warehouse';
    console.log(url);
    return this.http.get<ProductCard[]>(url).pipe();
  }

  getId(id) {
    return this.http.get<ProductCard>(this.baseUrl + "/" + id);
  }

  add(productCard: any) {
    console.log(productCard);
    return this.http.post(this.baseUrl + "/add", productCard);
  }

  edit(productCard: ProductCard, id) {
    const url = `${this.baseUrl}/update/` + id;

    return this.http.put(url, productCard);
  }

  delete(id) {
    return this.http.delete(this.baseUrl + "/delete/" + id);
  }

  nivelacija(id) {
    return this.http.post(this.baseUrl + "/" + id + "/nivelacija", {});
  }
}
