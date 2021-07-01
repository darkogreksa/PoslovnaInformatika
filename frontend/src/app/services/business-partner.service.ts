import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BusinessPartner } from '../model/business-partner';

@Injectable({
  providedIn: 'root'
})
export class BusinessPartnerService {

  private baseUrl = "http://localhost:8080/api/business-partner";
  constructor(
    private http: HttpClient
  ) { }
  
  getAll(): Observable<BusinessPartner[]>{
    const url = `${this.baseUrl}/`;
    console.log(url);
    return this.http.get<BusinessPartner[]>(url).pipe();
  }

  getId(id){
    return this.http.get<BusinessPartner>(this.baseUrl + "/" + id);
  }

  add(partner: BusinessPartner){
    console.log(partner);
    console.log(this.baseUrl + "/add/" + JSON.stringify(partner));
    return this.http.post<BusinessPartner>(this.baseUrl + '/add/', partner);
    
  }

  edit(partner: BusinessPartner, id){
    const url = `${this.baseUrl}/update/`+id;
    
    return this.http.put(url, partner);
  }

  delete(id){
    return this.http.delete(this.baseUrl + "/delete/" + id);
  }

  getAllByName(name: string): Observable<BusinessPartner[]>{
    const url = `${this.baseUrl}/name/`+name;
    console.log(url);
    return this.http.get<BusinessPartner[]>(url).pipe();
  }
}
