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
//		Customer customer = new Customer();
//		customer.setAgeCus(customer_Model.getAgeCus());
//		customer.setMaDinhDanhCus(customer.getMaDinhDanhCus());
//		customer.setNameCus(customer.getNameCus());
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

	@Override
	public Customer findCustomer(int madd) {
		try {
			Customer customer = customerRepository.findByMaDinhDanhCus(madd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
