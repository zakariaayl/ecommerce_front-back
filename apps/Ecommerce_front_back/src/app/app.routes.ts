import { Route } from '@angular/router';
import { HomeComponent } from './layout/home/home.component';
import { SeeProductComponent } from './layout/see-product/see-product.component';
export const appRoutes: Route[]=[
    {path :':str',component:HomeComponent},
    { path: 'product/:id', component: SeeProductComponent },
  {path :'',component:HomeComponent},


];

