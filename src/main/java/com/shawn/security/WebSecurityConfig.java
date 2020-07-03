package com.shawn.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.anyRequest()
				.permitAll()
				.and()
				.logout()
				.permitAll();
//		http
//				.authorizeRequests()
//				.antMatchers("/")
//
//				.permitAll()
//				.anyRequest().authenticated()                      //其它请求都需要校验才能访问
//				.and()
//				.formLogin()
//				.loginPage("/login")                             //定义登录的页面"/login"，允许访问
//				.permitAll()
//				.and()
//				.logout()                                           //默认的"/logout", 允许访问
//				.permitAll();
	}
}
