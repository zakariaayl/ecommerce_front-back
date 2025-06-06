import { Route } from '@angular/router';
import { HomeComponent } from './layout/home/home.component';
import { SeeProductComponent } from './layout/see-product/see-product.component';
import { SearchProductComponent } from './layout/searchComp/searchProduct.component';
import { CallbackComponent } from './CallBackComponent/callback.component';
import { LoginComponentComponent } from './login-component/login-component.component';
export const appRoutes: Route[]=[
    {path :':str',component:HomeComponent},
    { path: 'product/:id', component: SeeProductComponent },
  {path :'',component:HomeComponent},
  {path :'search/:str',component:SearchProductComponent},
  { path: 'login/callback', component: CallbackComponent },
  { path: 'login', component: LoginComponentComponent}
];

