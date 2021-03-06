import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {DatePipe} from '@angular/common';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { UnitComponent } from './unit/unit.component';
import { HomeComponent } from './home/home.component';

import {AuthenticationService} from './services/authentication/authentication.service';
import {JwtUtilsService} from './services/authentication/jwt-utils.service';
import {TokenInterceptorService} from './services/authentication/token-interceptor.service';
import { LocationComponent } from './location/location-list/location-list.component';
import { LocationAddComponent } from './location/location-add/location-add.component';
import { LocationEditComponent } from './location/location-edit/location-edit.component';
import { UnitAddComponent } from './unit/unit-add/unit-add.component';
import { UnitEditComponent } from './unit/unit-edit/unit-edit.component';
import { BusinessPartnerListComponent } from './business-partner/business-partner-list/business-partner-list.component';
import { BusinessPartnerAddComponent } from './business-partner/business-partner-add/business-partner-add.component';
import { BusinessPartnerEditComponent } from './business-partner/business-partner-edit/business-partner-edit.component';
import { LocationService } from './services/location.service';
import { CompanyListComponent } from './company/company-list/company-list.component';
import { CompanyAddComponent } from './company/company-add/company-add.component';
import { WarehouseListComponent } from './warehouse/warehouse-list/warehouse-list.component';
import { WarehouseAddComponent } from './warehouse/warehouse-add/warehouse-add.component';
import { WarehouseEditComponent } from './warehouse/warehouse-edit/warehouse-edit.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductAddComponent } from './product/product-add/product-add.component';
import { ProductEditComponent } from './product/product-edit/product-edit.component';
import { NavComponent } from './partials/nav/nav.component';
import { FooterComponent } from './partials/footer/footer.component';
import { ProductCardListComponent } from './product-card/product-card-list/product-card-list.component';
import { ProductCardAddComponent } from './product-card/product-card-add/product-card-add.component';
import { ProductCardEditComponent } from './product-card/product-card-edit/product-card-edit.component';
import { ProductCardInformationComponent } from './product-card-information/product-card-information.component';
import { ProductCardDetailComponent } from './product-card/product-card-detail/product-card-detail.component';
import { EmployeeLandingPageComponent } from './employee-landing-page/employee-landing-page.component';
import { CardAnalyticsComponent } from './card-analytics/card-analytics.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { InvoiceListComponent } from './invoice-list/invoice-list.component';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    UnitComponent,
    HomeComponent,
    LocationComponent,
    LocationAddComponent,
    LocationEditComponent,
    UnitAddComponent,
    UnitEditComponent,
    BusinessPartnerListComponent,
    BusinessPartnerAddComponent,
    BusinessPartnerEditComponent,
    CompanyListComponent,
    CompanyAddComponent,
    WarehouseListComponent,
    WarehouseAddComponent,
    WarehouseEditComponent,
    ProductListComponent,
    ProductAddComponent,
    ProductEditComponent,
    NavComponent,
    FooterComponent,
    ProductCardListComponent,
    ProductCardAddComponent,
    ProductCardEditComponent,
    ProductCardInformationComponent,
    ProductCardDetailComponent,
    EmployeeLandingPageComponent,
    CardAnalyticsComponent,
    InvoiceComponent,
    InvoiceListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule, 
    NgxPaginationModule
  ],
  providers: [
    AuthenticationService,
    LocationService,
    DatePipe,
    JwtUtilsService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
