package com.ankhang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {


public static void main(String[] args) {
	
	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
	
	String password = "admin";
	String BCryptpassword = bc.encode(password);
	System.out.println(BCryptpassword);
}
}
