package com.gamer.clientapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

/*	@Autowired
	DataSource dataSource;*/

/*	@Autowired
	PasswordEncoder passwordEncoder;*/

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
		.and().withUser("koustuv").password("{noop}password").roles("USER");
		

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		    .authorizeRequests()
		    .antMatchers("/contest/create","/fgx")
		    .hasAnyRole("USER", "ADMIN")
		    .and()
		    .formLogin()
		    .permitAll()
		    .loginPage("/login")
		    .defaultSuccessUrl("/")
		    .failureUrl("/login?error=true")
		    .and() 
		    .logout() 
		    .logoutSuccessUrl("/login?logout=true")
		    .invalidateHttpSession(true).permitAll().and().exceptionHandling()
		    .accessDeniedPage("/403")
		    .and() .csrf() .disable();
		 

	}
	
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */

}
