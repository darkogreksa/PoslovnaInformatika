import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LocationAddComponent } from './location/location-add/location-add.component';
import { LocationEditComponent } from './location/location-edit/location-edit.component';
import { LocationComponent } from './location/location-list/location.component';
import { UnitAddComponent } from './unit/unit-add/unit-add.component';
import { UnitEditComponent } from './unit/unit-edit/unit-edit.component';
import { UnitComponent } from './unit/unit-list/unit.component';
import { BusinessYearComponent } from './business-year/business-year-list/business-year/business-year.component';
import { BusinessYearAddComponent } from './business-year/business-year-add/business-year-add.component';
import { BusinessYearEditComponent } from './business-year/business-year-edit/business-year-edit.component';
import { BusinessPartnerListComponent } from './business-partner/business-partner-list/business-partner-list.component';
import { BusinessPartnerAddComponent } from './business-partner/business-partner-add/business-partner-add.component';
import { BusinessPartnerEditComponent } from './business-partner/business-partner-edit/business-partner-edit.component';

const routes: Routes = [
  {
    path: "units",
    component: UnitComponent
  },
  {
    path: "units/add",
    component: UnitAddComponent
  },
  {
    path: "units/edit/:id",
    component: UnitEditComponent
  },
  {
    path: "locations",
    component: LocationComponent
  },
  {
    path: "locations/add",
    component: LocationAddComponent
  },
  {
    path: "locations/edit/:id",
    component: LocationEditComponent
  },
  {
    path: "business-year",
    component: BusinessYearComponent
  },
  {
    path: "business-year/add",
    component: BusinessYearAddComponent
  },
  {
    path: "business-year/edit/:id",
    component: BusinessYearEditComponent
  },
  {
    path: "business-partner",
    component: BusinessPartnerListComponent
  },
  {
    path: "business-partner/add",
    component: BusinessPartnerAddComponent
  },
  {
    path: "business-partner/edit:id",
    component: BusinessPartnerEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
