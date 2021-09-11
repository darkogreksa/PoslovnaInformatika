import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Analytics } from '../model/analytics';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {
  private baseUrl = "http://localhost:8080/api/warehouse-card-analytics";
  constructor(private http: HttpClient) {}

  getAllByCard(id): Observable<Analytics[]> {
    const url = this.baseUrl + '/product-card/' + id;
    console.log(url);
    return this.http.get<Analytics[]>(url).pipe();
  }
}
