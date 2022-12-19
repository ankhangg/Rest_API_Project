package com.ankhang.service;

import com.ankhang.entities.Account;

public interface AccountService {
	Account findAccountByUsername(String userName);
}
