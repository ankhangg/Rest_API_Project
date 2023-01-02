package com.ankhang.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

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
@Table(name = "customer",uniqueConstraints = {@UniqueConstraint(columnNames = {"maddcus"})})
//@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
	 

	private static final long serialVersionUID = 4145550324155412879L;

@Id
 @Column(name =  "idcus")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCus;
  
 @Column(name = "namecus", length = 40, nullable = false)
  private String nameCus;
 
 @Column(name = "maddcus", length = 5, nullable = false)
  private String maDinhDanhCus;
 
 @Column(name = "agecus", nullable = true)
  private int ageCus;
 
 @JsonIgnore
 @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
 @JoinColumn(name = "cus_id")
  private List<Bill_Customer> listBillCustomers;
}
