package com.ankhang.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ankhang.entities.Bill_Customer;
import com.ankhang.entities.Customer;
import com.ankhang.entities.List_RestAPI_FindCus;
import com.ankhang.repository.Bill_CustomerRepository;
import com.ankhang.requestmodel.Request_Bill;
import com.ankhang.service.BillCustomerService;
import com.ankhang.service.CustomerService;
@Component
@Service()
public class BillCustomerServiceImpl implements BillCustomerService {

	@Autowired
	private Bill_CustomerRepository bRepository;
	
	@Autowired
	private CustomerService customerService;
	
	
	@Override
	public boolean saveBill(Request_Bill request_AddBill) {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy/HHmmss");
		String dateFormat = localDateTime.format(formatter);
		
	   Bill_Customer bill = new Bill_Customer();
       bill.setRefBill(dateFormat);
       bill.setCreatedDateBill(new Date());
       bill.setTongTienBill(request_AddBill.getTongtien());
       
       Customer customer = customerService.findCustomerbyMadd(request_AddBill.getMadd());
       bill.setCustomer(customer);
       
       try {
    	   bRepository.save(bill);
    	   return true;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public Bill_Customer findBillByRefnum(String refNum) {
		Bill_Customer bill = new Bill_Customer();
		try {
			bill = bRepository.findBillByRefnum(refNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bill;
	}

	@Override
	public List<Bill_Customer> findBillOfCus(String madd) {
		List<Bill_Customer> listbill = null;
		Customer customer = customerService.findCustomerbyMadd(madd);
		if (customer!=null) {
		 listbill = customer.getListBillCustomers();
		}
		return listbill;
	}

}
