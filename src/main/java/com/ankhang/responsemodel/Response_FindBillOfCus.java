package com.ankhang.responsemodel;

import java.util.List;

import com.ankhang.entities.Bill_Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response_FindBillOfCus {
   private String code;
   private String message;
   private String maddcus;
   private String namecus;
   private List<Bill_Customer> listBill_Customers;
 
} 
