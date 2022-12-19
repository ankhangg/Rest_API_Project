package com.ankhang.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "bill_cus",uniqueConstraints = {@UniqueConstraint(columnNames = {"refbill"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill_Customer {
	 @Id
	 @Column(name =  "idbill")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idBillCus;
	 
	 @Column(name = "refbill")
	 private String refBill;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date createdDateBill;
	 
	 @Column(name = "tongtien",nullable = false) 
	 private int tongTienBill;
	 
	 @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinColumn(name = "cus_id")
	 private Customer customer;
}
