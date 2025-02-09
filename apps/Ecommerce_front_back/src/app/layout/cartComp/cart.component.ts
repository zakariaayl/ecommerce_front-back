import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartService } from '../../CartService/cart.service';

@Component({
  selector: 'app-cart',
  imports: [CommonModule],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss',
})
export class CartComponent {
  constructor(private cartservice:CartService){

  }
  
}
