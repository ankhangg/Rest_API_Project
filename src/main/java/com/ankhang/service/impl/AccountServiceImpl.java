package com.ankhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ankhang.config.SecurityConfigBean;
import com.ankhang.entities.Account;
import com.ankhang.entities.Account_Info;
import com.ankhang.repository.AccountInfoRepository;
import com.ankhang.repository.AccountRepository;
import com.ankhang.requestmodel.Request_AddAcountWithInfo;
import com.ankhang.service.AccountService;
@Component
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private SecurityConfigBean securityConfigBean;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountInfoRepository accountInfoRepository;

	@Override
	public Account findAccountByUsername(String userName) {
		Account account = accountRepository.findAccountByUsername(userName);
		return account;
	}

	@Override
	public boolean saveAccountWithInfo(Request_AddAcountWithInfo account) {
		Account_Info account_Info = new Account_Info();
		Account accountinput = new Account();
		accountinput.setUserName(account.getUserName());
		String BCryptpassword = securityConfigBean.passwordEncoder().encode(account.getPassWord());
		accountinput.setPassWord(BCryptpassword);
	    if (account.getActive().equals("0")) {
	    	accountinput.setActive(true);
		}
	    accountinput.setUserRole(account.getUserRole());
	    
	    account_Info.setPhoneNumber(account.getPhoneNumber());
	    
	    account_Info.setAccount(accountinput);
	    try {
			this.accountInfoRepository.save(account_Info);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return false;
	}

}
