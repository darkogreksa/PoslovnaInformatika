import { Component, OnInit } from '@angular/core';
import { InvoiceService } from '../services/invoice.service';

@Component({
  selector: 'app-invoice-list',
  templateUrl: './invoice-list.component.html',
  styleUrls: ['./invoice-list.component.css']
})
export class InvoiceListComponent implements OnInit {
  invoices;

  constructor(private invoiceService: InvoiceService) { }

  ngOnInit(): void {

    this.invoiceService.getAll().subscribe(res => {
      this.invoices = res;
      console.log(this.invoices);
    });

  }

}
