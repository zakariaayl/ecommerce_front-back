import { Component, Input, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product } from '../../Models/product';
import { Quantity } from '../../Models/Qantite';
import { fontAwesomeIcons } from "../../font-awesome-icons";
import { FaConfig, FaIconComponent, FaIconLibrary } from "@fortawesome/angular-fontawesome";
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from '../../productService/service.service';
import { SearchService } from '../../searchService/search.service';
import { CartService } from '../../CartService/cart.service';
import { PostService } from '../../post_service/post.service';

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

  constructor(private route: Router, private service: ServiceService, private router: ActivatedRoute,private serach:SearchService,private cartservice:CartService,private postserv:PostService) {}

  homeproducts: Product[] = [];
  visibleproducts: Product[] = [];
  category!: string;
  str!:string;
  ngOnInit() {
    this.initFontAwesome();
    this.service.getProductList().subscribe((data) => {
      this.homeproducts = data;
      this.updateVisibleProducts();
    });
    this.router.params.subscribe((params) => {
      this.category = params['str'];
      this.updateVisibleProducts();
    });
    
  }

  private initFontAwesome() {
    this.faConfig.defaultPrefix = 'far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }
  private updateVisibleProducts() {
    if (this.category) {
      this.visibleproducts = this.homeproducts.filter((data) => data.category === this.category);
    } else {
      this.visibleproducts = this.homeproducts;
    }
    console.log("Visible Products:", this.visibleproducts);
  }

  minus(id: number) {
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
  getQuantity(id: number): number {
    return this.quantities.get(id)?.q || 0;
  }
  navigate(id: number) {
    this.route.navigate(['/product', id]);
    console.log("navigate");
  }
  searchable!:Product;
  search(str:string) {
    console.log(str)
    this.route.navigate(['/search',str])

  }
  addtocart(p:Product){
    console.log(`product added ${p.id} that has a price of ${p.price}`)
    this.cartservice.addToCart(p)
    
  }
}
