import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UnitComponent } from './unit/unit.component';
import { LocationComponent } from './location/location.component';
import { UnitAddComponent } from './unit/unit-add/unit-add.component';
import { UnitEditComponent } from './unit/unit-edit/unit-edit.component';
import { LocationAddComponent } from './location/location-add/location-add.component';
import { LocationEditComponent } from './location/location-edit/location-edit.component';
import { CompanyListComponent } from './company/company-list/company-list.component';
import { CompanyAddComponent } from './company/company-add/company-add.component';
import { BusinessYearComponent } from './business-year/business-year-list/business-year/business-year.component';

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
    BusinessYearComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
