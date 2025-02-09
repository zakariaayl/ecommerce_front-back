import { Injectable } from '@angular/core';
import { Product } from '../Models/product';
import { CartItem } from '../Models/CartItem';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CartService {
  price:Subject<number>=new Subject<number>()
  quantity:Subject<number>=new Subject<number>()
  cartList:CartItem[]=[]
 
  addToCart(p:Product){
   let cartitem=new CartItem(p)
   
   if(this.cartList.length>0){
    let existItem=this.cartList.find((c)=>c.id==cartitem.id)
    
    if (existItem) {
      existItem.quantityWanted += 1;
    } else {
      cartitem.quantityWanted = 1;
      this.cartList.push(cartitem);
    }
    }else{
      cartitem.quantityWanted = 1;
      this.cartList.push(cartitem);
    }
   
    
   this.uploadNewdata()
   this.price.subscribe(value=>console.log(`total price ${value}`))
   }
  //  console.log(`total  quantity ${this.quantity}`)
   
  uploadNewdata(){
    let totalprice:number=0
    let totalQuantity:number=0
    for(let c of this.cartList){
      totalprice+=c.price*c.quantityWanted
      totalQuantity+=c.quantityWanted
    }
    this.price.next(totalprice)
    this.quantity.next(totalQuantity)
  }
  
}
