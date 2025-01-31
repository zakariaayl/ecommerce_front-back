import {Component, inject,Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterLink} from "@angular/router";
import {FaConfig, FaIconComponent, FaIconLibrary} from "@fortawesome/angular-fontawesome";
import {fontAwesomeIcons} from "../../font-awesome-icons";
import {faUser} from "@fortawesome/free-solid-svg-icons";
import { Product } from '../../Models/product';

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
  constructor(private route:Router ) {
  }
  ngOnInit(): void {
    this.initFontAwesome();
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
}
