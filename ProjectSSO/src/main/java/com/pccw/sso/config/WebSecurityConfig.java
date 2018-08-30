package com.pccw.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;
  
  private UserDetailsService getUserDetailsService() {
	  return userDetailsService; 
  }
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	
	  http.authorizeRequests().antMatchers("/authorize**","/token**","/","/index**","/newEmployee**").hasAnyRole("ADMIN", "USER")
	    .and()
	    .authorizeRequests().antMatchers("/login**","/sign-up**","/addUser**").permitAll()
	    .and()
	    .formLogin().loginPage("/login")
	    .loginProcessingUrl("/loginAction").permitAll()
	    .and()
	    .exceptionHandling().accessDeniedPage("/403")
	    .and()
	    .logout().logoutSuccessUrl("/login").permitAll()
	    .and().logout().deleteCookies("JSESSIONID")
	    .and().rememberMe()
	          .rememberMeParameter("remember-me")
	          .key("uniqueAndSecret").tokenValiditySeconds(86400)
	          
	    .and()
	    .csrf().disable();
  }
}