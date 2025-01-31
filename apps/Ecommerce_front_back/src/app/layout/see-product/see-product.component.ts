import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { FaConfig,FaIconComponent, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { fontAwesomeIcons } from '../../font-awesome-icons';
import { Product } from '../../Models/product';
import { SeeProductServiceService } from '../../seeProductService/see-product-service.service';

@Component({
  selector: 'app-see-product',
  imports: [CommonModule,FaIconComponent],
  standalone:true,
  templateUrl: './see-product.component.html',
  styleUrl: './see-product.component.scss',
})
export class SeeProductComponent {
  private faConfig=inject(FaConfig)
  private faIconLibrary =inject(FaIconLibrary)
   private initFontAwesome() {
      this.faConfig.defaultPrefix = 'far';
      this.faIconLibrary.addIcons(...fontAwesomeIcons);
    }
    id:number=0
    product!: Product;
  constructor(private route: ActivatedRoute,private seeServe:SeeProductServiceService) {
  }
  ngOnInit(){
    this.initFontAwesome()
    this.route.params.subscribe((params) => {
      this.id = +params['id']; 
      this.seeServe.getProduct(this.id).subscribe((data)=>this.product=data)
  }
    );
  }
}
