import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InvoiceLineItemService {
  private baseUrl = "http://localhost:8080/api/invoices";
  constructor(private http: HttpClient) { }
}
