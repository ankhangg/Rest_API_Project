package com.ankhang.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "listapi_findcus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class List_RestAPI_FindCus {
	 @Id
	 @Column(name =  "idcus")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idAPI;
	 
	 @Column(name = "reffindcus",nullable = false)
	 private String refAPI;
	 
	 @Column(name = "datetimefindcus",nullable = false)
	 private Date  dateTimeAPI;
	 
	 @Column(name = "maddfindcus",nullable = false)
	 private String maddAPI;
	 
	 @Column(name = "codefindcus",nullable = false)
	 private String codeAPI;
	 
	 @Column(name = "messagefindcus",nullable = false)
	 private String messageAPI;

}
