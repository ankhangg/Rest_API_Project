package com.ankhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ankhang.entities.Customer;
import com.ankhang.model.Customer_Model;
import com.ankhang.repository.CustomerRepository;
import com.ankhang.service.CustomerService;
@Component
@Service
public class CustomerService_Impl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean saveCustomer_Regist(Customer_Model customer_Model) {		
		Customer customer = new Customer();
		customer.setAgeCus(customer_Model.getAgeCus());
		customer.setMaDinhDanhCus(customer.getMaDinhDanhCus());
		customer.setNameCus(customer.getNameCus());
		try {
			customerRepository.save(customer);
			System.out.println("saveCustomer_Regist Success");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("saveCustomer_Regist Fail");
		}
		return false;
	}

}
