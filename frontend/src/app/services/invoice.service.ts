import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  private baseUrl = "http://localhost:8080/api/invoices";
  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    const url = this.baseUrl;
    console.log(url);
    return this.http.get(url);
}

  getInvoice(id): any {
    return this.http.get(this.baseUrl + "/invoice/" + id);
  }

  getInvoiceLineItems(id): any {
    return this.http.get(this.baseUrl + "/invoice/" + id + "/lineitems");
  }

  addInvoice(invoice): any {
    return this.http.post(this.baseUrl + "/add", invoice);
  }

  proknjizi(invoice): any {
    return this.http.post(this.baseUrl + "/proknjizi", invoice);
  }

}
