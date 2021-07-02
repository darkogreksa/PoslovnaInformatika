import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Warehouse } from '../model/warehouse';

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {

  private baseURL = "http://localhost:8080/api/warehouse";
  constructor(
      private http: HttpClient
  ){}

  getAll(): Observable<Warehouse[]>{
      const url = this.baseURL;
      console.log(url);
      return this.http.get<Warehouse[]>(url).pipe();
  }

  getOne(id){
      return this.http.get<Warehouse>(this.baseURL + '/' + id);
  }

  add(w: Warehouse){
      console.log(w);
      return this.http.post<Warehouse>(this.baseURL + '/create', w);
  }

  edit(w: Warehouse, id){
      const url = `${this.baseURL}/update/`+id;
      return this.http.put(url, w);
  }

  delete(id: number){
      return this.http.delete(this.baseURL + '/' + id);
  }
}
