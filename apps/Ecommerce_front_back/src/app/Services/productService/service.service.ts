import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../Models/product';

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  private baseUrl = 'http://localhost:8080/product/getProducts';

  constructor(private httpClient: HttpClient) {
    console.log('ServiceService instantiated');
  }

  getProductList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseUrl,{withCredentials:true});
  }
}
