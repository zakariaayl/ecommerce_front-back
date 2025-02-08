import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../Models/product';
import { Observable } from 'rxjs';
import { Order } from '../Models/Orders';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  postUrl="http://localhost:8080/order/postOrder"
  constructor(private Httpclient:HttpClient) { }
  post(order:Order):Observable<any>{
    return this.Httpclient.post(this.postUrl,order)
  }
}
