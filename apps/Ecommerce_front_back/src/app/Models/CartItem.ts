import { Product } from "./product"

export class CartItem{
   id:number
   name:string
   status:string
   imgUrl:string
   quantity:number
   description:string
   price:number
  category:string
  quantityWanted:number
  constructor(product :Product) {
     this.id=product.id
    this.name=product.name
    this.status=product.status
    this.imgUrl=product.imgUrl
    this.description=product.description
    this.price=product.price
    this.category=product.category
    this.quantityWanted=0
    this.quantity=product.quantity
  }
}
