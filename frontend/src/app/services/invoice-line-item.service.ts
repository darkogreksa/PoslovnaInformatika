import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InvoiceLineItemService {
  private baseUrl = "http://localhost:8080/api/invoice-line-items"
  constructor(private http: HttpClient) { }

  addInvoiceLineItem(invoiceLineItem): any {
    return this.http.post(this.baseUrl + "/create", invoiceLineItem);
  }

}
