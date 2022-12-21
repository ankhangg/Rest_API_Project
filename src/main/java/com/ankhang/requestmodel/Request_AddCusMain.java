package com.ankhang.requestmodel;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request_AddCusMain {
 @SerializedName("nameCus")
  private String nameCus;
 
 @SerializedName("maDinhDanhCus")
  private String maddCus;
 
 @SerializedName("ageCus")
  private int ageCus;
}
