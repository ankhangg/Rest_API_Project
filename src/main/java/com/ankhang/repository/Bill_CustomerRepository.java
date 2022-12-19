package com.ankhang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ankhang.entities.Bill_Customer;

@Repository
public interface Bill_CustomerRepository extends CrudRepository<Bill_Customer, Long> {

}
