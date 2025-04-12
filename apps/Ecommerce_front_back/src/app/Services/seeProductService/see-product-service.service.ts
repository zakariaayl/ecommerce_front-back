import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../../Models/product';

@Injectable({
  providedIn: 'root'
})
export class SeeProductServiceService {
 baseUrl='http://localhost:8080/product/getProduct/';
  constructor(private httpClient:HttpClient) { }
  getProduct(id:number){
   return  this.httpClient.get<Product>(this.baseUrl+id,{withCredentials:true})
  }
}
