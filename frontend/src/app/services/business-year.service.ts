import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BusinessYear } from '../model/business-year';

@Injectable({
  providedIn: 'root'
})
export class BusinessYearService {

  private baseURL = "http://localhost:8080/api/business-year";

  constructor(private http: HttpClient) { }

  getAll(): Observable<BusinessYear[]>{
      const url = this.baseURL;
      return this.http.get<BusinessYear[]>(url).pipe();
  }

  getOne(id: number){
      return this.http.get<BusinessYear>(this.baseURL + '/' + id);
  }

  add(byear: BusinessYear){
      return this.http.post<BusinessYear>(this.baseURL + '/create', byear);
  }

  edit(byear: BusinessYear, id: number){
      return this.http.put(this.baseURL + '/update/' + id, byear);
  }

  delete(id: number){
      return this.http.delete(this.baseURL + '/delete/' +id);
  }
}
