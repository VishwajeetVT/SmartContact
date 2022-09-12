//package com.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.smartContact")
//
//public class MyConfig extends WebSecurityConfigurerAdapter{
//
//    @Bean
//     UserDetailsService getUserDetailService() {
//        return new UserDetailServiceImp();
//    }
//
//    @Bean(name = "test")
//    BCryptPasswordEncoder passwordEncoder() {
//    	 
//    	return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider doaAuthenticationProvider = new DaoAuthenticationProvider();
//        doaAuthenticationProvider.setUserDetailsService(this.getUserDetailService());
//        doaAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return doaAuthenticationProvider;
//    }
//	
//	// Configure method
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/user/**").hasRole("USER")
//		.antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
//	}
//	
//	
//	
//	
//}
