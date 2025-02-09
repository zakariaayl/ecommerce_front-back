export class  Order{
    constructor(public id:number,
        public status:string,
        public date:string,
        public quantity:number,
        public price:number,
                public productid:number
        ){
        this.quantity= quantity
        this.id=id
        this.date=date
        this.status=status
        this.price=price
      this.productid=productid
        }
}
