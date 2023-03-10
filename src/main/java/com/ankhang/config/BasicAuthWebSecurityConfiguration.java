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
       
        // C??c trang kh??ng c???n ????ng nh???p
    	http.csrf().disable();
    	
    	//Cac trang ko can login
    	http.authorizeRequests().requestMatchers("/home","/","/addcusinfo").permitAll();
    	
		// C??c y??u c???u ph???i login v???i vai tr?? ROLE_EMPLOYEE ho???c ROLE_MANAGER.
		// N???u ch??a login, n?? s??? redirect t???i trang /admin/login.
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
