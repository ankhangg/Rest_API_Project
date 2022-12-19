package com.ankhang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import com.ankhang.service.impl.UserDetailsServiceImpl;

@Configuration
public class BasicAuthWebSecurityConfiguration {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private SecurityConfigBean securityConfigBean;
	
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	private AuthenticationManagerBuilder auth;
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    	return (web) -> web.ignoring().requestMatchers("/home","/");
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(securityConfigBean.passwordEncoder());
	}
	
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
       
        // Các trang không cần đăng nhập
    	http.csrf().disable();
    	
    	
		// Các yêu cầu phải login với vai trò ROLE_EMPLOYEE hoặc ROLE_MANAGER.
		// Nếu chưa login, nó sẽ redirect tới trang /admin/login.
    	http.authorizeRequests().requestMatchers("/addcus").access("hasRole('ROLE_ADMIN')");
    	
    	http.authorizeHttpRequests().anyRequest().authenticated();
    	http.httpBasic().authenticationEntryPoint(authEntryPoint);
        return http.build();
    }
}
