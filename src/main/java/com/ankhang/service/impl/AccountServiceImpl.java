package com.ankhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ankhang.entities.Account;
import com.ankhang.repository.AccountRepository;
import com.ankhang.service.AccountService;
@Component
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account findAccountByUsername(String userName) {
		Account account = accountRepository.findAccountByUsername(userName);
		return account;
	}

}
