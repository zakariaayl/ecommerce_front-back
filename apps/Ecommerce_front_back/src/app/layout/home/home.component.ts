import { Component, Input, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product } from '../../Models/product';
import { Quantity } from '../../Models/Qantite';
import { fontAwesomeIcons } from "../../font-awesome-icons";
import { FaConfig, FaIconComponent, FaIconLibrary } from "@fortawesome/angular-fontawesome";
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from '../../productService/service.service';

@Component({
  selector: 'app-home',
  imports: [CommonModule, FaIconComponent],
  standalone: true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {

  quantities: Map<number, Quantity> = new Map();

  @Input() products: Product[] = [];
  private faConfig = inject(FaConfig);
  private faIconLibrary = inject(FaIconLibrary);

  constructor(private route: Router, private service: ServiceService, private router: ActivatedRoute) {}

  homeproducts: Product[] = [];
  visibleproducts: Product[] = [];
  category!: string;

  ngOnInit() {
    // Initialize FontAwesome
    this.initFontAwesome();

    this.service.getProductList().subscribe((data) => {
      this.homeproducts = data;
      this.updateVisibleProducts();
    });

    this.router.params.subscribe((params) => {
      this.category = params['str'];
      this.updateVisibleProducts();
    });
  }

  private initFontAwesome() {
    this.faConfig.defaultPrefix = 'far';
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }

  // Method to update visible products based on category
  private updateVisibleProducts() {
    if (this.category) {
      this.visibleproducts = this.homeproducts.filter((data) => data.category === this.category);
    } else {
      this.visibleproducts = this.homeproducts;
    }
    console.log("Visible Products:", this.visibleproducts);
  }

  minus(id: number) {
    const quantity = this.quantities.get(id);
    if (quantity && quantity.q > 0) {
      quantity.q -= 1;
    }
  }

  plus(id: number) {
    const quantity = this.quantities.get(id);
    if (quantity) {
      quantity.q += 1;
    }
  }

  getQuantity(id: number): number {
    return this.quantities.get(id)?.q || 0;
  }

  navigate(id: number) {
    this.route.navigate(['/product', id]);
    console.log("navigate");
  }

  search() {

  }
}
