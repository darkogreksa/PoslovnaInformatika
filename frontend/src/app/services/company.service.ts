import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from '../model/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private baseUrl = "http://localhost:8080/api/company";
  constructor(
    private http: HttpClient
  ) 
  { }
  
  getAll(): Observable<Company[]>{
    const url = `${this.baseUrl}/all`;
    console.log(url);
    return this.http.get<Company[]>(url).pipe();
  }

  add(company: Company){
    const url = `${this.baseUrl}/add`;
    console.log(url);
    return this.http.post<Company[]>(url, company).pipe();
  }
}
