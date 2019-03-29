package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BaseSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	
	@Autowired
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/**
		 * 表单登录
		 */
		http.formLogin()
		.successHandler(myAuthenticationSuccessHandler)
		.failureHandler(myAuthenticationFailureHandler)
		.and().authorizeRequests().anyRequest().authenticated();
		
		/**
		 * http登录  这个是默认的
		 */
		//http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
	}
}
