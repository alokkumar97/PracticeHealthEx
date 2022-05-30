package com.Spring.HcE.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	  @Bean 
	  public BCryptPasswordEncoder passencoder()
	  { 
		  return new BCryptPasswordEncoder();  
	  }
	 
	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailServiceImpl();
	}
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
	@Bean
    public DaoAuthenticationProvider authenticateProvider() {
    	DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
    	authProvider.setUserDetailsService(userDetailService());
    	authProvider.setPasswordEncoder(passencoder());
		return authProvider;
    	
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/spec/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.usernameParameter("username").passwordParameter("password")
		.permitAll();
	}

}
