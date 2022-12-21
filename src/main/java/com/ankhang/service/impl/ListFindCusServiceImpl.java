package com.ankhang.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ankhang.entities.List_RestAPI_FindCus;
import com.ankhang.repository.ListFindCusRepository;
import com.ankhang.service.ListFindCusService;
@Component
@Service
public class ListFindCusServiceImpl implements ListFindCusService {
  
	@Autowired
	private ListFindCusRepository lRepository;
	
	@Override
	public boolean saveListFindCus(String respCode, String respMess, String maDD) {
		
		List_RestAPI_FindCus listCus = new List_RestAPI_FindCus();
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String dateFormat = localDateTime.format(formatter);
		
		listCus.setRefAPI(dateFormat);
		listCus.setDateTimeAPI(new Date());
		listCus.setCodeAPI(respCode);
		listCus.setMessageAPI(respMess);
		listCus.setMaddAPI(maDD);
		try {
			lRepository.save(listCus);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
