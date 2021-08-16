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
import { LoggedOutGuard } from 'src/guards/logged-out-guard';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, canActivate: [LoggedOutGuard]  },
  { path: "unit", component: UnitComponent, canActivate: [LoggedOutGuard]  },
  { path: "unit/edit/:id", component: UnitEditComponent, canActivate: [LoggedOutGuard] },
  { path: "unit/add", component: UnitAddComponent, canActivate: [LoggedOutGuard] },
  { path: "location", component: LocationComponent, canActivate: [LoggedOutGuard] },
  {
    path: "location/add",
    component: LocationAddComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "location/edit/:id",
    component: LocationEditComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "business-partner",
    component: BusinessPartnerListComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "business-partner/add",
    component: BusinessPartnerAddComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "business-partner/edit/:id",
    component: BusinessPartnerEditComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "company",
    component: CompanyListComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "company/add",
    component: CompanyAddComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "warehouse",
    component: WarehouseListComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "product",
    component: ProductListComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "product/add",
    component: ProductAddComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "product-card",
    component: ProductCardListComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "warehouse/product-card/:id",
    component: ProductCardInformationComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "product-card/id/:id",
    component: ProductCardDetailComponent,
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "employee-landing",
    component: EmployeeLandingPageComponent,
    canActivate: [LoggedOutGuard] 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
