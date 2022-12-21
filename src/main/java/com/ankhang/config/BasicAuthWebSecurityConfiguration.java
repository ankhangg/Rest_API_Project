package com.ankhang.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import com.ankhang.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class BasicAuthWebSecurityConfiguration {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	
	@Autowired
	private AuthenticationManagerBuilder auth;
	
	@Autowired
	private SecurityConfigBean securityConfigBean;
	
		
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(securityConfigBean.passwordEncoder());
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
       
        // Các trang không cần đăng nhập
    	http.csrf().disable();
    	
    	//Cac trang ko can login
    	http.authorizeRequests().requestMatchers("/home","/").permitAll();
    	
		// Các yêu cầu phải login với vai trò ROLE_EMPLOYEE hoặc ROLE_MANAGER.
		// Nếu chưa login, nó sẽ redirect tới trang /admin/login.
    	http.authorizeRequests().requestMatchers("/addcus","/homeadmin").access("hasRole('ROLE_ADMIN')");
    	
    	http.authorizeRequests().requestMatchers("/homeuser","/addbill","/findbill","/findbillofcus").access("hasRole('ROLE_USER')");
    	
    	http.authorizeRequests().requestMatchers("/findcus").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')");
    	
    	// Login ko dung Role
    	http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    	
    	// Basic Authen
    	http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    	
    	http.logout().logoutUrl("/logout").logoutSuccessUrl("/home");

        return http.build();
    }
    

}
