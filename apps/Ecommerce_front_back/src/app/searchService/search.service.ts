import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../Models/product';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  basUrl='http://localhost:8080/product/search/'
  constructor( private httpclient:HttpClient) { }
  getProduct(str:string){
    return  this.httpclient.get<Product[]>(this.basUrl+str)
  }
}
