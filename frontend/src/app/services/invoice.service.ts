import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {
  private baseUrl = "http://localhost:8080/api/invoices";
  constructor(private http: HttpClient) { }

  getInvoice(id): any {
    return this.http.get(this.baseUrl + "/invoice/" + id);
  }

  getInvoiceLineItems(id): any {
    return this.http.get(this.baseUrl + "/invoice/" + id + "/lineitems");
  }


}
