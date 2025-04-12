import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import OktaAuth from '@okta/okta-auth-js';
import { OKTA_AUTH } from '@okta/okta-angular';
import OktaSignIn from '@okta/okta-signin-widget';

@Component({
  selector: 'app-login-component',
  imports: [CommonModule],
  templateUrl: './login-component.component.html',
  styleUrl: './login-component.component.scss',
})
export class LoginComponentComponent {
  oktasignin:any;

  constructor(@Inject(OKTA_AUTH) private oktaauth:OktaAuth){
    
  }
}
