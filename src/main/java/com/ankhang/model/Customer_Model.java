package com.ankhang.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer_Model {
  private String nameCus;
  private String maDinhDanhCus;
  private int ageCus;
}
