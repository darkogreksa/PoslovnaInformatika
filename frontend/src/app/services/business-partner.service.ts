import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BusinessPartner } from '../model/business-partner';

@Injectable({
  providedIn: 'root'
})
export class BusinessPartnerService {

  private baseUrl = "http://localhost:8080/api/business-partner";

  constructor(private http: HttpClient) { }
  
  getAll(): Observable<BusinessPartner[]>{
    const url = `${this.baseUrl}/all`;
    console.log(url);
    return this.http.get<BusinessPartner[]>(url).pipe();
  }

  getId(id: number){
    return this.http.get<BusinessPartner>(this.baseUrl + "/" + id);
  }

  add(businessPartner: BusinessPartner){
    console.log(businessPartner);
    console.log(this.baseUrl + "/add/" + JSON.stringify(businessPartner));
    return this.http.post<BusinessPartner>(this.baseUrl + '/add/', businessPartner);
    
  }

  edit(businessPartner: BusinessPartner, id: number){
    const url = `${this.baseUrl}/update/`+id;
    
    return this.http.put(url, businessPartner);
  }

  getAllByName(name: string): Observable<BusinessPartner[]>{
    const url = `${this.baseUrl}/name/`+name;
    console.log(url);
    return this.http.get<BusinessPartner[]>(url).pipe();
  }

  delete(id: number){
    return this.http.delete(this.baseUrl + "/delete/" + id);
  }
}
