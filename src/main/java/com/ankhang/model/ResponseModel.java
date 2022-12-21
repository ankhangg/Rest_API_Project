package com.ankhang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
   private String code;
   private String message;
   private int ageCus;
   private String nameCus;
}
