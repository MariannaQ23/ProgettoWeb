import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import { LoginComponent } from './componenti/login/login.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    AppComponent, 
    LoginComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    RouterModule
  ],

  bootstrap: [AppComponent]
})
export class AppModule {
}