import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UnitAddComponent } from './unit/unit-add/unit-add.component';
import { UnitEditComponent } from './unit/unit-edit/unit-edit.component';
import { LocationAddComponent } from './location/location-add/location-add.component';
import { LocationEditComponent } from './location/location-edit/location-edit.component';
import { CompanyListComponent } from './company/company-list/company-list.component';
import { CompanyAddComponent } from './company/company-add/company-add.component';
import { BusinessYearComponent } from './business-year/business-year-list/business-year/business-year.component';
import { UnitComponent } from './unit/unit-list/unit.component';
import { LocationComponent } from './location/location-list/location.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {PaginationModule} from 'ngx-bootstrap/pagination';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import { LocationService } from './services/location.service';
import { NavComponent } from './partials/nav/nav.component';
import { FooterComponent } from './partials/footer/footer.component';
import { HomeComponent } from './home/home.component';
import { BusinessYearAddComponent } from './business-year/business-year-add/business-year-add.component';
import { BusinessYearEditComponent } from './business-year/business-year-edit/business-year-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    UnitComponent,
    LocationComponent,
    UnitAddComponent,
    UnitEditComponent,
    LocationAddComponent,
    LocationEditComponent,
    CompanyListComponent,
    CompanyAddComponent,
    BusinessYearComponent,
    HomeComponent,
    NavComponent,
    FooterComponent,
    BusinessYearAddComponent,
    BusinessYearEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BsDropdownModule.forRoot(),
    PaginationModule.forRoot(),
    BsDatepickerModule.forRoot()
  ],
  providers: [LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
