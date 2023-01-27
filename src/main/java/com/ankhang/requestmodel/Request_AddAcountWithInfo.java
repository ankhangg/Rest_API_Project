package com.ankhang.requestmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request_AddAcountWithInfo {
    private String userName;
    private String passWord;
    private String userRole;
    private String active;
    private String phoneNumber;
}
