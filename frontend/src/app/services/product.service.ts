import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { PaginatedResult } from '../model/pagination';
import { Product, ProductAdapter } from '../model/product';
import { ProductPage } from '../model/product-page';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/api/product';

  constructor(
    private http: HttpClient,
    private adapter: ProductAdapter
  ) {}

  getAll(page?: number, itemsPerPage?: number): Observable<Product[]> {
    const paginatedResult: PaginatedResult<Product[]> = new PaginatedResult<Product[]>();
    let queryString = '?';

    if (page != null && itemsPerPage != null) {
      queryString += 'page=' + page + '&size=' + itemsPerPage;
    }
    return this.http.get<Product[]>(this.baseUrl + '/' + queryString).pipe(
      map((data: any[]) => data.map(item => this.adapter.adapt(item)))
    );
  }

  getAllPaged(page: number, itemsPerPage: number): Observable<ProductPage> {
    let queryString = '?';

    if (page != null && itemsPerPage != null) {
      queryString += 'page=' + page + '&size=' + itemsPerPage;
    }
    return this.http.get<ProductPage>(this.baseUrl + '/' + queryString).pipe();
  }

  getOne(id: number) {
    return this.http.get(this.baseUrl + '/' + id);
  }

  add(product: Product) {
    return this.http.post<Product>(this.baseUrl + '/', product);
  }

  edit(product: Product) {
    return this.http.put<Product>(this.baseUrl + '/', product);
  }

  delete(id: number) {
    return this.http.delete(this.baseUrl + '/' + id).pipe();
  }
}
