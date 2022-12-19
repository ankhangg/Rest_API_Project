package com.ankhang.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Long accId; 
	
    @Id
	@Column(name = "username", nullable = false,unique=true)
	private String userName;
	
	@Column(name = "password", length = 100, nullable = false)
	private String passWord;

	
	@Column(name = "userrole",nullable = false)
	private String userRole;
	
	private boolean active;
	
	 

}
