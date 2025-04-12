import { isRedirectUri } from "@okta/okta-auth-js";

export default{
    oidc:{
       clientId:'zTzkxBFsbbvXLPXlCLhtLGpY25kI9IB7',
       issuer:'https://dev-3bb1c52e4yo3ytbr.eu.auth0.com/oauth2/default',
       RedirectUri:'http://localhost:4200/login/callback',
       scopes:['profile','openid','email']
    }
}
