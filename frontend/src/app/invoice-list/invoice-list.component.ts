import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InvoiceService } from '../services/invoice.service';

@Component({
  selector: 'app-invoice-list',
  templateUrl: './invoice-list.component.html',
  styleUrls: ['./invoice-list.component.css']
})
export class InvoiceListComponent implements OnInit {
  invoices;
  selectedInvoice;

  constructor(private invoiceService: InvoiceService, private router: Router) { }

  ngOnInit(): void {

    this.invoiceService.getAll().subscribe(res => {
      this.invoices = res;
      console.log(this.invoices);
    });

  }

  proknjizi(invoice) {
    this.invoiceService.proknjizi(invoice).subscribe(resp => {
      console.log(resp);
      this.router.navigate(['/employee-landing']);
    });
  }

}
