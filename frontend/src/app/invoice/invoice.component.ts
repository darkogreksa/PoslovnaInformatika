import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BusinessPartnerService } from '../services/business-partner.service';
import { InvoiceLineItemService } from '../services/invoice-line-item.service';
import { InvoiceService } from '../services/invoice.service';
import { ProductCardService } from '../services/product-card.service';
import { ProductService } from '../services/product.service';
import { WarehouseService } from '../services/warehouse.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  newEntry;

  invoice = {
    id: null,
    documentType: null,
    dateOfFormation: new Date(),
    status: null,
    businessPartner: { name: null },
    businessYear: { year: "2021", closed: null, preduzece: null },
    warehouse: { name: null }
  };

  warehouses;
  businessPartner;
  productList;
  productsM;
  prod;

  // robaIzabrana
  selectedProduct = {
    id: null,
    product: { name: null },
    amount: null,
    price: null,
    value: null
  };

  tempProductList = [];

  amount;
  price;
  errorMsg;
  errorModal;

  // stavka
  lineItem = {
    price: null,
    quantity: null,
    value: null,
    invoiceDTO: null,
    product: null
  };

  status;
  primka = true;

  @ViewChild("selectVrsta") selectVrsta = {
    nativeElement: { value: null }
  };

  @ViewChild("selectWarehouse") selectWarehouse = {
    nativeElement: { value: null }
  };

  @ViewChild("selectBusinessPartner") selectBusinessPartner = {
    nativeElement: { value: null }
  };

  @ViewChild("selectRoba") selectRoba = {
    nativeElement: { value: null }
  };

  constructor(
    private route: ActivatedRoute,
    private invoiceService: InvoiceService,
    private businessPartnerService: BusinessPartnerService,
    private warehouseService: WarehouseService,
    private invoiceLineItemService: InvoiceLineItemService,
    private productCardService: ProductCardService,
    private router: Router,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.newEntry = true;

    this.warehouseService.getAll().subscribe(res => {
      this.warehouses = res;
      console.log(this.warehouses);
    });
    this.businessPartnerService.getAll().subscribe(res => {
      this.businessPartner = res;
      console.log(this.businessPartner);
    });
    this.productService.getAll().subscribe(res => {
        this.tempProductList = res;
        console.log(this.tempProductList);
        console.log('MARKO RESPONSE:' + res);
        console.log(res);
    });

  }

  saveInvoice() {
    this.invoice.warehouse = this.warehouses.filter(
      w => w.name === this.selectWarehouse.nativeElement.value
    )[0];
    this.invoice.businessPartner = this.businessPartner.filter(
      b => b.name === this.selectBusinessPartner.nativeElement.value
    )[0];
    this.invoice.documentType = this.selectVrsta.nativeElement.value;
    this.invoice.status = "Formiranje";
    console.log(this.invoice);
    this.invoiceService.addInvoice(this.invoice).subscribe(res => {
      console.log(res);
      console.log("Adding invoce line item");
      this.invoice.id = res.id;
      this.lineItem.value = this.lineItem.quantity * this.lineItem.price;
      this.lineItem.invoiceDTO = this.invoice;
      this.lineItem.product = this.tempProductList.filter(
        b => b.name === this.selectRoba.nativeElement.value
      )[0];
      console.log(this.lineItem);
      this.invoiceLineItemService.addInvoiceLineItem(this.lineItem).subscribe(resp => {
        console.log(resp);
      });
    });
    this.router.navigate(['/invoice-list']);
  }

}
