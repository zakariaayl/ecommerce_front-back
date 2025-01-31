import { Component, Input, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product } from '../../Models/product';
import { Quantity } from '../../Models/Qantite';
import { fontAwesomeIcons } from "../../font-awesome-icons";
import { FaConfig, FaIconComponent, FaIconLibrary } from "@fortawesome/angular-fontawesome";
import { ActivatedRoute, Router} from '@angular/router';
import { ServiceService } from '../../productService/service.service';

@Component({
  selector: 'app-home',
  imports: [CommonModule, FaIconComponent],
  standalone: true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {

  quantities: Map<number, Quantity> = new Map();

  @Input() products: Product[] = [];
  private faConfig = inject(FaConfig);
  private faIconLibrary = inject(FaIconLibrary);

  constructor( private route: Router,private service : ServiceService) {

  }
  homeproducts:Product[]=[]

  ngOnInit() {
   this.service.getProductList().subscribe((data)=>this.homeproducts=data);

    }

  private initFontAwesome() {

    this.faConfig.defaultPrefix = 'far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }

  ld: boolean = true;
  pd: boolean = true;


  minus(id: number) {
    console.log(this.quantities);
    const quantity = this.quantities.get(id);
    if (quantity && quantity.q > 0) {
      quantity.q -= 1;
    }
  }

  plus(id: number) {
    const quantity = this.quantities.get(id);
    if (quantity) {
      quantity.q += 1;
    }
  }
  category!:String;
  getQuantity(id: number): number {
    return this.quantities.get(id)?.q || 0;
  }
  ngOnChanges() {
    this.quantities.clear(); // Reset map before re-adding
    this.products.forEach(product => {
      this.quantities.set(product.id, new Quantity(product.id, 0));
    });
  }
  navigate(id:number){
    this.route.navigate(['/product',id]);
    console.log("navigate")
    // console.log(this.category)
  }
  search(){

  }
}
