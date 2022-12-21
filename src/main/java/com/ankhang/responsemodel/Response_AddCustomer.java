package com.ankhang.responsemodel;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response_AddCustomer {
	
	@SerializedName("message")	
    private String messageRP;
	
	@SerializedName("code")	
    private String codeRP;
	
	@SerializedName("nameCus")	
	private String nameCus;
	
	@SerializedName("ageCus")	
	private String ageCus;
}
