package com.ankhang.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ankhang.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
  
	@Query("Select c from Customer c where c.maDinhDanhCus = ?1")
	Customer findCusbyMadd(String maDD);
}
