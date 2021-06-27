import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {DatePipe} from '@angular/common';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { UnitComponent } from './unit/unit.component';
import { HomeComponent } from './home/home.component';

import {AuthenticationService} from './services/authentication/authentication.service';
import {JwtUtilsService} from './services/authentication/jwt-utils.service';
import {TokenInterceptorService} from './services/authentication/token-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    UnitComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
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
