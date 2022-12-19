package com.ankhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ankhang.model.Customer_Model;
import com.ankhang.service.CustomerService;

@Transactional
@Controller
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  
  @PostMapping(value = "/addcus", produces = {MediaType.APPLICATION_JSON_VALUE})
  public boolean addCustomer(@RequestBody Customer_Model customer_Model) {
	  boolean ketqua = customerService.saveCustomer_Regist(customer_Model);
	  System.out.println("Ket qua addCustomer Controller:" + ketqua);
	  return ketqua;
  }
}
