import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LocationComponent } from './location/location.component';
import { UnitAddComponent } from './unit/unit-add/unit-add.component';
import { UnitEditComponent } from './unit/unit-edit/unit-edit.component';
import { UnitComponent } from './unit/unit.component';

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
    path: "unit/edit/:id",
    component: UnitEditComponent
  }
  {
    path: "locations",
    component: LocationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
