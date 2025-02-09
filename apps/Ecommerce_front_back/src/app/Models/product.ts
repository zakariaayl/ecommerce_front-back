export class Product{

  constructor(
      public id:number,
        public name:string,
        public status:string,
        public quantity:number,
        public imgUrl:string,
        public description:string,
        public price:number,
        public category:string
  ) {}
}
