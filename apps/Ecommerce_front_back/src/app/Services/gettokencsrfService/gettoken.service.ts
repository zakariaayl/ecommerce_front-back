import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GettokenService {
  baseUrl="http://localhost:8080/order/csrf-token"
  constructor(private httpcli:HttpClient) { }
  public gettoken(){
    return  this.httpcli.get<tok>(this.baseUrl,{withCredentials:true})
  }

}
export class tok{
  parameterName:string
  token:string
  headerName:string
  constructor(parameterName:string,
    token:string,
headerName:string){
  this.headerName=headerName
  this.parameterName=parameterName
  this.token=token
}

}
