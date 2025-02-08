import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { SearchService } from '../../searchService/search.service';
import { Product } from '../../Models/product';
import { FaConfig, FaIconComponent, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { fontAwesomeIcons } from '../../font-awesome-icons';

@Component({
  selector: 'app-search-product',
  imports: [CommonModule,FaIconComponent],
  templateUrl: './searchProduct.component.html',
  styleUrl: './searchProduct.component.scss',
})
export class SearchProductComponent {
  constructor( private router: ActivatedRoute,private serach:SearchService,private route:Router){}
  str!:string;
  faconfig=inject(FaConfig);
  Iconlibrary=inject(FaIconLibrary)
  private initFontAwesome(){
      this.faconfig.defaultPrefix='far';
      this.Iconlibrary.addIcons(...fontAwesomeIcons);
  }
  product!:Product;
  ngOnInit(){
    this.initFontAwesome()
    this.router.params.subscribe((params)=>{this.str=params['str'];
      this.serach.getProduct(this.str).subscribe((data)=> {
      this.product=data;
      console.log(this.product.id)
      })})
    }
    navigate(id: number) {
      this.route.navigate(['/product', id]);
      console.log("navigate");
    }
    search(str:string) {
      console.log(str)
      this.route.navigate(['/search',str])
  
    }
}
