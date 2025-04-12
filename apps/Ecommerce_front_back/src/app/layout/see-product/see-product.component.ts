import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { FaConfig,FaIconComponent, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { fontAwesomeIcons } from '../../font-awesome-icons';
import { Product } from '../../Models/product';
import { SeeProductServiceService } from '../../Services/seeProductService/see-product-service.service';
import { Order } from '../../Models/Orders';
import { PostService } from '../../Services/post_service/post.service';
import { GettokenService, tok } from '../../Services/gettokencsrfService/gettoken.service';
import { Token } from '@angular/compiler';

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
  constructor(private route: ActivatedRoute,private seeServe:SeeProductServiceService,private postserv:PostService,private toekn:GettokenService) {
  }
   tok!:tok;
  ngOnInit(){
    this.initFontAwesome()
    this.route.params.subscribe((params) => {
      this.id = +params['id'];
      this.seeServe.getProduct(this.id).subscribe((data)=>this.product=data)
      this.toekn.gettoken().subscribe((data)=>this.tok=data)

  }
    );
  }

  order:Order=new Order(this.id,"ongoing","",0,50,1)
  minus(){
    if(this.order.quantity!=0)
    this.order.quantity-=1
  }
  plus(){
    if(this.product.quantity>this.order.quantity)
    this.order.quantity+=1
  }
  orderr(order:Order,price:number){
    this.order.productid=this.id
    this.order.price=price
    console.log(price)
    console.log(this.tok.token)
    this.postserv.post(this.order,this.tok).subscribe({
      next: (response) => console.log('Success:', response),
      error: (error) => console.error('Error:', error)
    });
  }
}
