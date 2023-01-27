package com.ankhang.service;

import com.ankhang.entities.Account;
import com.ankhang.requestmodel.Request_AddAcountWithInfo;

public interface AccountService {
	Account findAccountByUsername(String userName);
	boolean saveAccountWithInfo(Request_AddAcountWithInfo account);
}
