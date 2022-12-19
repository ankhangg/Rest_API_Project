package com.ankhang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ankhang.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}