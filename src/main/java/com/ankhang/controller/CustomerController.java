package com.ankhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ankhang.entities.Customer;
import com.ankhang.model.ResponseModel;
import com.ankhang.service.CustomerService;

@Transactional
@Controller
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  
  @PostMapping(value = "/addcus", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public ResponseModel addCustomer(@RequestBody Customer customer) {
	  boolean ketqua = customerService.saveCustomer_Regist(customer);
	  System.out.println("Ket qua addCustomer Controller:" + ketqua);
	  ResponseModel demoModel = new ResponseModel();
	  if (ketqua==true) {
		  demoModel.setMessage("ADD CUSTOMER SUCCESS");
		  demoModel.setCode("000");
	}else {
		  demoModel.setMessage("ADD CUSTOMER FAIL");
		  demoModel.setCode("001");
	}
	  return demoModel;
  }
}
