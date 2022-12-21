package com.ankhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ankhang.entities.Customer;

import com.ankhang.repository.CustomerRepository;
import com.ankhang.service.CustomerService;
@Component
@Service
public class CustomerService_Impl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean saveCustomer_Regist(Customer customer) {		
		try {
			customerRepository.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer findCustomerbyMadd(String madd) {
		Customer customer = new Customer();
		try {
			 customer = customerRepository.findCusbyMadd(madd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
