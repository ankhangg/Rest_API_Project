package com.ankhang.requestmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request_Bill {
	
  private int tongtien;
  private String madd;
  private String refbill;
}
