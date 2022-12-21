package com.ankhang.controller;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ankhang.entities.Bill_Customer;
import com.ankhang.entities.Customer;
import com.ankhang.model.ResponseModel;
import com.ankhang.requestmodel.Request_AddCusAPI;
import com.ankhang.requestmodel.Request_Bill;
import com.ankhang.responsemodel.Response_FindBill;
import com.ankhang.responsemodel.Response_FindBillOfCus;
import com.ankhang.service.BillCustomerService;
import com.ankhang.service.CustomerService;

@Transactional
@Controller
public class BuillCustomerController {
	
	@Autowired
	private BillCustomerService billCustomerService;
	
	@Autowired
	private CustomerService customerService;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("ak_properties/message_api");
	
	@PostMapping(value = "/addbill", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseModel addBill(@RequestBody Request_Bill request_AddBill) {
		boolean ketqua = billCustomerService.saveBill(request_AddBill);
		 ResponseModel demoModel = new ResponseModel();
		  if (ketqua==true) {
			  demoModel.setMessage(bundle.getString("addbill.message.success"));
			  demoModel.setCode(bundle.getString("code.success"));
		}else {
			  demoModel.setMessage(bundle.getString("addbill.message.fail"));
			  demoModel.setCode(bundle.getString("code.fail"));
		}
		  return demoModel;
	  }
	
	  @PostMapping(value = "/findbill", produces = {MediaType.APPLICATION_JSON_VALUE})
	  @ResponseBody
	public Response_FindBill findBill(@RequestBody Request_Bill requestBill) {
		Bill_Customer bill = new Bill_Customer();
		try {
			bill = billCustomerService.findBillByRefnum(requestBill.getRefbill());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Response_FindBill response = new Response_FindBill();
		if (bill!=null) {
			response.setCode(bundle.getString("code.success"));
			response.setCusmadd(bill.getCustomer().getMaDinhDanhCus());
			response.setCusname(bill.getCustomer().getNameCus());
			response.setMessage(bundle.getString("findbill.message.success"));
			response.setRefbill(bill.getRefBill());
			response.setTongtien(String.valueOf(bill.getTongTienBill()));
		}else {
			response.setCode(bundle.getString("code.fail"));
			response.setMessage(bundle.getString("findbill.message.fail"));
		}
		return response;
	}
	  
	  @PostMapping(value = "/findbillofcus", produces = {MediaType.APPLICATION_JSON_VALUE})
	  @ResponseBody
	  public Response_FindBillOfCus findByBillOfCus(@RequestBody Request_AddCusAPI cusreq) {
		  Customer customer = new Customer();
		  Response_FindBillOfCus respone = new Response_FindBillOfCus();
		  try {
			  customer = customerService.findCustomerbyMadd(cusreq.getMaDinhDanhCus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		  if (customer!=null) {
			  respone.setCode(bundle.getString("code.success"));
			  respone.setMaddcus(customer.getMaDinhDanhCus());
			  respone.setNamecus(customer.getNameCus());
			  respone.setListBill_Customers(customer.getListBill_Customers());
			  if (customer.getListBill_Customers() != null) {
				  respone.setMessage(bundle.getString("findbillcus.message.success"));
			}else {
				respone.setMessage(bundle.getString("findbillcus.message.successnull"));
			}
		} else {
			respone.setCode(bundle.getString("code.fail"));
			respone.setMessage(bundle.getString("findbillcus.message.fail"));
		}
		  return respone;
	  }

}
