import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusinessPartnerAddComponent } from './business-partner/business-partner-add/business-partner-add.component';
import { BusinessPartnerEditComponent } from './business-partner/business-partner-edit/business-partner-edit.component';
import { BusinessPartnerListComponent } from './business-partner/business-partner-list/business-partner-list.component';
import { CompanyAddComponent } from './company/company-add/company-add.component';
import { CompanyListComponent } from './company/company-list/company-list.component';
import { HomeComponent } from './home/home.component';
import { LocationAddComponent } from './location/location-add/location-add.component';
import { LocationEditComponent } from './location/location-edit/location-edit.component';
import { LocationComponent } from './location/location-list/location-list.component';
import { ProductAddComponent } from './product/product-add/product-add.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { UnitAddComponent } from './unit/unit-add/unit-add.component';
import { UnitEditComponent } from './unit/unit-edit/unit-edit.component';
import { UnitComponent } from './unit/unit.component';
import { WarehouseListComponent } from './warehouse/warehouse-list/warehouse-list.component';
import { ProductCardListComponent } from './product-card/product-card-list/product-card-list.component';
import { ProductCardInformationComponent } from './product-card-information/product-card-information.component';
import { ProductCardDetailComponent } from './product-card/product-card-detail/product-card-detail.component';
import { EmployeeLandingPageComponent } from './employee-landing-page/employee-landing-page.component';

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
  },
  {
    path: "company",
    component: CompanyListComponent
  },
  {
    path: "company/add",
    component: CompanyAddComponent
  },
  {
    path: "warehouse",
    component: WarehouseListComponent
  },
  {
    path: "product",
    component: ProductListComponent
  },
  {
    path: "product/add",
    component: ProductAddComponent
  },
  {
    path: "product-card",
    component: ProductCardListComponent
  },
  {
    path: "warehouse/product-card/:id",
    component: ProductCardInformationComponent,
  },
  {
    path: "product-card/id/:id",
    component: ProductCardDetailComponent,
  },
  {
    path: "employee-landing",
    component: EmployeeLandingPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
