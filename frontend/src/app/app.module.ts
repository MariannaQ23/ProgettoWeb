import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import { LoginComponent } from './componenti/login/login.component';
import { RouterModule } from '@angular/router';
import { RegComponent } from './componenti/reg/reg.component';
import { PrenotaComponent } from './componenti/prenota/prenota.component';
import {TokenInterceptor} from './tokenInterceptor';


@NgModule({
  declarations: [
    AppComponent, 
    LoginComponent,
    RegComponent,
    PrenotaComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    RouterModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})

export class AppModule {
}