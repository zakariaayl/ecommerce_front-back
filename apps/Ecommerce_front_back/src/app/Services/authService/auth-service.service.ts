import { Injectable } from '@angular/core';
import { createAuth0Client, Auth0Client, Auth0ClientOptions, User } from '@auth0/auth0-spa-js';
@Injectable({ providedIn: 'root' })
export class AuthService {
  private auth0Client!: Auth0Client;
  user: User | undefined = undefined;
  isAuthenticatedFromgmail = false;
  isAuthenticated = false;
  private clientReady: Promise<void>;

  constructor() {
    this.clientReady = this.initAuth();
  }

  private async initAuth(): Promise<void> {
    const config: Auth0ClientOptions = {
      domain: 'dev-3bb1c52e4yo3ytbr.eu.auth0.com',
      clientId: 'JlPut9cszENycAESeGCwYIB4eTRavXwu',
      authorizationParams: {
        redirect_uri: 'http://localhost:4200/login/callback'
      }
    };

    this.auth0Client = await createAuth0Client(config);
    this.isAuthenticated = await this.auth0Client.isAuthenticated();
    if (this.isAuthenticated) {
      this.user = await this.auth0Client.getUser();
    }
  }

  async login() {
    await this.clientReady;
    return this.auth0Client.loginWithRedirect();
  }

  async logout() {
    await this.clientReady; 
    return this.auth0Client.logout({
      logoutParams: {
        returnTo: window.location.origin
      }
    });
  }

  async handleRedirectCallback() {
    await this.clientReady;
    await this.auth0Client.handleRedirectCallback();
    this.user = await this.auth0Client.getUser();
    this.isAuthenticated = true;
  }

  getUserInfo() {
    return this.user;
  
  }
}
