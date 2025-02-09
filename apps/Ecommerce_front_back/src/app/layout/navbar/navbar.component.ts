import {Component, inject,Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterLink} from "@angular/router";
import {FaConfig, FaIconComponent, FaIconLibrary} from "@fortawesome/angular-fontawesome";
import {fontAwesomeIcons} from "../../font-awesome-icons";
import {faUser} from "@fortawesome/free-solid-svg-icons";
import { Product } from '../../Models/product';
import { CartService } from '../../CartService/cart.service';

@Component({
  selector: 'app-navbar',
  standalone:true,
  imports: [CommonModule, RouterLink, FaIconComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent{
  @Input() products:Product[]=[]
  private faIconLibrary=inject(FaIconLibrary);
  private faConfig=inject(FaConfig);
  constructor(private route:Router,private cartserv:CartService ) {

  }
  price: number=0;
  quantity: number=0;
  ngOnInit(): void {
    this.initFontAwesome();
    this.cartserv.price.subscribe(pr=>this.price=pr)
    this.cartserv.quantity.subscribe(q=>this.quantity=q)
  }
  private initFontAwesome(){
    this.faConfig.defaultPrefix='far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }

  protected readonly faUser = faUser;
  navigate(str:String){
    this.route.navigate(['/',str]);
    console.log("navigate")
  }
  visibleProduct=this.products.filter((cat)=>cat.name=="wow")

  all() {
    this.route.navigate(['/'])
  }

  tec() {
    this.route.navigate(['/tec'])
    console.log("tec")
  }
  art(){
    this.route.navigate(['/art'])
    console.log("art")
  }
  categories: string[] = [
    "tec",
    "Electronics",
    "Clothing",
    "Home & Kitchen",
    "Health & Beauty",
    "Toys & Games",
    "Books & Stationery",
    "Sports & Outdoors",
    "Automotive",
    "Groceries",
    "Furniture",
    "Jewelry & Watches",
    "Pet Supplies",
    "Baby Products",
    "Office Supplies",
    "Music & Instruments",
    "art"
  ];

  nav(name:string) {
    this.route.navigate(['/'+name])
  }
}
