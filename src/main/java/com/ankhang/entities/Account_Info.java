package com.ankhang.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "account")
@Table(name =  "AccountInfo")
public class Account_Info {
	@Id
	@Column(name = "accinfoid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accinfoId;
	
	@Column(name = "phonenumber", nullable = true, length = 10)
	private String phoneNumber;
	
	 @OneToOne(cascade = CascadeType.ALL,
	    		optional = true)
	  @JoinColumn(name = "username", referencedColumnName = "userName")
	private Account account;
}
