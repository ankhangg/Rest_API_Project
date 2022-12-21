package com.ankhang.responsemodel;

import com.ankhang.model.ResponseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response_FindBill {
	   private String code;
	   private String message;
	   private String refbill;
	   private String tongtien;
	   private String cusmadd;
	   private String cusname;
}
