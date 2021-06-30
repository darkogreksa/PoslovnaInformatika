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

@NgModule({
  declarations: [
    AppComponent,
    UnitComponent,
    HomeComponent,
    LocationComponent,
    LocationAddComponent,
    LocationEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthenticationService,
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
