package com.ankhang.service;

import java.util.List;

import com.ankhang.entities.Bill_Customer;
import com.ankhang.requestmodel.Request_Bill;

public interface BillCustomerService {
   boolean saveBill(Request_Bill request_AddBill);
   Bill_Customer findBillByRefnum(String refNum);
   List<Bill_Customer> findBillOfCus(String madd);
}
