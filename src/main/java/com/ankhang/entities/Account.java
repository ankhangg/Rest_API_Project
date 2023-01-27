package com.ankhang.entities;

import java.io.Serializable;

import  jakarta.persistence.OneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name =  "Account")
public class Account implements Serializable {

	private static final long serialVersionUID = 5252633264491073706L;
	public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
	
    @Column(name = "accid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accId; 
	
    @Id
	@Column(name = "username", nullable = false,unique=true)
	private String userName;
	
	@Column(name = "password", length = 100, nullable = false)
	private String passWord;

	
	@Column(name = "userrole",nullable = false)
	private String userRole;
	
	private boolean active;
	
	@OneToOne(mappedBy = "account")
	private Account_Info account_Info;
	
	
	
	 

}
