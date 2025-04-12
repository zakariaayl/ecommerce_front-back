import {Component, inject, OnInit} from '@angular/core';
import {RouterLink, RouterModule, RouterOutlet} from "@angular/router";
import {FaConfig, FaIconLibrary, FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {fontAwesomeIcons} from "./font-awesome-icons";
import {NavbarComponent} from "./layout/navbar/navbar.component";
import {faUser} from "@fortawesome/free-solid-svg-icons";
import {HomeComponent} from "./layout/home/home.component";
import {ServiceService} from "./Services/productService/service.service";
import {Product} from "./Models/product";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import { SearchProductComponent } from './layout/searchComp/searchProduct.component';
import { FooterComponent } from './layout/footerComp/footer.component';

@Component({
  imports: [RouterModule,FontAwesomeModule,NavbarComponent,RouterOutlet,FormsModule
    ,CommonModule,FooterComponent,FooterComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent    implements OnInit{
  title = 'Ecommerce_front_back';
  private faIconLibrary=inject(FaIconLibrary);
  private faConfig=inject(FaConfig);
  products : Product[]=[];
  constructor( private prudservice :ServiceService ) { }
  ngOnInit(): void {
    this.initFontAwesome();
    this.listProducts();
  }
  private initFontAwesome(){
    this.faConfig.defaultPrefix='far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }

  protected readonly faUser = faUser;

  private listProducts() {
    this.prudservice.getProductList().subscribe(
      (data) => {
        this.products = data;
      },
      (error) => {
        console.error('Error fetching products:', error);
      }
    );
  }
  search(){
    console.log("search")
  }
}
