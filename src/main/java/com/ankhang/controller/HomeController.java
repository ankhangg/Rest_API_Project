package com.ankhang.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankhang.model.ResponseModel;

@Transactional
@RestController
public class HomeController {
	
	@GetMapping(value = {"/home","/"},produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseModel home() {
		ResponseModel demoModel = new ResponseModel();
		demoModel.setMessage("WELCOME TO HOME");
		return demoModel;
	}
	
	@GetMapping(value = "/homeadmin",produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseModel home2() {
		ResponseModel demoModel = new ResponseModel();
		demoModel.setMessage("THIS PAGE FOR ADMIN AUTHEN URL");
		return demoModel;
	}
	
	@GetMapping(value = "/homeuser",produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseModel home4() {
		ResponseModel demoModel = new ResponseModel();
		demoModel.setMessage("THIS PAGE FOR USER AUTHEN URL");
		return demoModel;
	}
	
	@GetMapping(value = "/403",produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseModel home3() {
		ResponseModel demoModel = new ResponseModel();
		demoModel.setMessage("Sorry you can access this page for Role");
		return demoModel;
	}

}
