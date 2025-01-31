import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import {FaIconComponent, FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {NavbarComponent} from "./layout/navbar/navbar.component";
import {Route, RouterModule, RouterOutlet, Routes} from "@angular/router";
import {HomeComponent} from "./layout/home/home.component";
import {HttpClientModule} from "@angular/common/http";
import {ServiceService} from "./productService/service.service";
import { SeeProductServiceService } from './seeProductService/see-product-service.service';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    FaIconComponent,
    FontAwesomeModule,
    NavbarComponent,
    RouterOutlet,
    HttpClientModule,
    HomeComponent,
    FormsModule
    // Import CommonModule for *ngFor and other common directives
  ],
  providers: [ServiceService,HttpClientModule,SeeProductServiceService],
  bootstrap: [AppComponent], // Bootstrap AppComponent
})
export class AppModule {}
 