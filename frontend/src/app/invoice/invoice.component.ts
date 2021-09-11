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
    invoice: null,
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
    if (this.route.snapshot.url[1].path == "add") {
      this.newEntry = true;

      this.warehouseService.getAll().subscribe(res => {
        this.warehouses = res;
        console.log(this.warehouses);
        for (let index = 0; index < this.warehouses.length; index++) {
          const element = this.warehouses[index];
          console.log(element.name);
        }
      });
      this.businessPartnerService.getAll().subscribe(res => {
        this.businessPartner = res;
        console.log(this.businessPartner);
        console.log(this.businessPartner.name);
      });

      this.invoiceService.getInvoiceLineItems(this.route.snapshot.url[1].path)
      .subscribe(res => {
        this.tempProductList = res.map(r => {
          r.naziv = r.roba.naziv;
          r.cena = r.cena;
          return r;
        });
      });


    } else {

    }




  }

}
