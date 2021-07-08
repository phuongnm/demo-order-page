package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
	          .and()
	          .withUser("cskh").password(passwordEncoder().encode("cskh")).roles("ADMIN");
	    }
	    
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    } 	
	    
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
			/*
			 * http.authorizeRequests() .antMatchers("/login") .permitAll()
			 * .antMatchers("/**") .hasAnyRole("ADMIN", "USER") .and() .formLogin()
			 * .loginPage("/login") .defaultSuccessUrl("/home")
			 * .failureUrl("/login?error=true") .permitAll() .and() .logout()
			 * .logoutSuccessUrl("/login?logout=true") .invalidateHttpSession(true)
			 * .permitAll() .and() .csrf() .disable();
			 
			 *
			 */
	    	
	    	
	    	
	    	http
	        .authorizeRequests()
	            .anyRequest().authenticated() 
	            .antMatchers("/cskh/**").hasRole("ADMIN")
	            .and()
	        .formLogin()                      
	            .and()
	        .httpBasic()
	        .and()
	        .logout().deleteCookies("remove").invalidateHttpSession(false)
            .logoutSuccessUrl("/")
	        
	        ;  
	    }
}
