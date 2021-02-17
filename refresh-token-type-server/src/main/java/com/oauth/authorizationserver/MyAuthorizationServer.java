package com.oauth.authorizationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@EnableAuthorizationServer
@Configuration
public class MyAuthorizationServer extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory()
		 .withClient("satishapp")
		 .secret("satish123")
		 .redirectUris("http://localhost:5000/callback")
		 .authorizedGrantTypes("authorization_code", "password", "refresh_token")
		 .accessTokenValiditySeconds(180)
		 .scopes("read_profile", "read_contacts"); 
	}
}
