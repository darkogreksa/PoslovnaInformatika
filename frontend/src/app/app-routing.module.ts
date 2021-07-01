import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusinessPartnerAddComponent } from './business-partner/business-partner-add/business-partner-add.component';
import { BusinessPartnerEditComponent } from './business-partner/business-partner-edit/business-partner-edit.component';
import { BusinessPartnerListComponent } from './business-partner/business-partner-list/business-partner-list.component';
import { HomeComponent } from './home/home.component';
import { LocationAddComponent } from './location/location-add/location-add.component';
import { LocationEditComponent } from './location/location-edit/location-edit.component';
import { LocationComponent } from './location/location-list/location-list.component';
import { UnitAddComponent } from './unit/unit-add/unit-add.component';
import { UnitEditComponent } from './unit/unit-edit/unit-edit.component';
import { UnitComponent } from './unit/unit.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: "unit", component: UnitComponent },
  { path: "unit/edit/:id", component: UnitEditComponent},
  { path: "unit/add", component: UnitAddComponent},
  { path: "location", component: LocationComponent},
  {
    path: "location/add",
    component: LocationAddComponent
  },
  {
    path: "location/edit/:id",
    component: LocationEditComponent
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
    path: "business-partner/edit/:id",
    component: BusinessPartnerEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
