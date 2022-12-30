package com.ankhang.service;

import com.ankhang.entities.Customer;

public interface CustomerService {
	boolean saveCustomer_Regist(Customer customer);
	Customer findCustomerbyMadd(String madd);
	Customer findCustomerbyMaddwithlistbill(String madd);
}
