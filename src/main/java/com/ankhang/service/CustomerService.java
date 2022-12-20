package com.ankhang.service;

import com.ankhang.entities.Customer;

public interface CustomerService {
	boolean saveCustomer_Regist(Customer customer);
	Customer findCustomer(int madd);
}
