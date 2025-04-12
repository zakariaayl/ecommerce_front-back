import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../../Models/product';
import { Observable } from 'rxjs';
import { Order } from '../../Models/Orders';
import { GettokenService, tok } from '../gettokencsrfService/gettoken.service';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  postUrl="http://localhost:8080/order/postOrder";
  // headers = new HttpHeaders({
  //   'X-CSRF-TOKEN':
  // });
  constructor(private Httpclient:HttpClient,private gettoken:GettokenService) { }
  post(order:Order,token:tok):Observable<any>{
    console.log(token.token)
    let hed=new HttpHeaders({
      'X-CSRF-TOKEN':token.token
    })
    console.log(hed)
    return this.Httpclient.post(this.postUrl,order, {
     headers:hed,

      withCredentials: true

    })
  }

}
