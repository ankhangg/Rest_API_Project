package com.ankhang.controller;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ankhang.entities.Account;
import com.ankhang.entities.Customer;
import com.ankhang.model.ResponseModel;
import com.ankhang.requestmodel.Request_AddAcountWithInfo;
import com.ankhang.requestmodel.Request_AddCusAPI;
import com.ankhang.requestmodel.Request_AddCusMain;
import com.ankhang.service.AccountService;
import com.ankhang.service.CustomerService;
import com.ankhang.service.ListFindCusService;

@Transactional
@Controller
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  
  @Autowired
  private ListFindCusService listFindCusService;
  
  @Autowired
  private AccountService accountService;
  
  private ResourceBundle bundle = ResourceBundle.getBundle("ak_properties/message_api");
  
  @PostMapping(value = "/addcus", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public ResponseModel addCustomer(@RequestBody Customer customer) {
	  boolean ketqua = customerService.saveCustomer_Regist(customer);
	  ResponseModel demoModel = new ResponseModel();
	  if (ketqua==true) {
		  demoModel.setMessage(bundle.getString("addcus.message.success"));
		  demoModel.setCode(bundle.getString("code.success"));
	}else {
		  demoModel.setMessage(bundle.getString("addcus.message.fail"));
		  demoModel.setCode(bundle.getString("code.fail"));
	}
	  return demoModel;
  }
  
  @PostMapping(value = "/findcus", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public ResponseModel findCustomer(@RequestBody Request_AddCusAPI cusreq) {
	  Customer customer = new Customer();
	  try {
		 customer = customerService.findCustomerbyMadd(cusreq.getMaDinhDanhCus());
	} catch (Exception e) {
		e.printStackTrace();
	}
	  ResponseModel demoModel = new ResponseModel();
	  if (customer!=null) {
		  demoModel.setMessage(bundle.getString("findcus.message.success"));
		  demoModel.setCode(bundle.getString("code.success"));
		  demoModel.setAgeCus(customer.getAgeCus());
		  demoModel.setNameCus(customer.getNameCus());
		  System.out.println("FIND CUSTOMER SUCCESS:" + customer.getNameCus());
	} else {
		  demoModel.setMessage(bundle.getString("findcus.message.fail"));
		  demoModel.setCode(bundle.getString("code.fail"));
		  System.out.println("FIND CUSTOMER FAIL");
	}
	  try {
		  listFindCusService.saveListFindCus(demoModel.getCode(), demoModel.getMessage(), cusreq.getMaDinhDanhCus());
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Fail saveListFindCus");
	}
	  return demoModel;
  }
  
  @PostMapping(value = "/addcusinfo", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public ResponseModel addAccountWithInfo(@RequestBody Request_AddAcountWithInfo request) {
	  ResponseModel demoModel = new ResponseModel();
	  boolean result = false;
	  try {
		  result = accountService.saveAccountWithInfo(request);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  if (result==false) {
		  demoModel.setMessage(bundle.getString("addcustinfo.message.fail"));
		  demoModel.setCode(bundle.getString("code.fail"));
	} else {
		  demoModel.setMessage(bundle.getString("addcustinfo.message.success"));
		  demoModel.setCode(bundle.getString("code.success"));
	}
	  return demoModel;
  }
}
