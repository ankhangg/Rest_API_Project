package com.ankhang.postrequest;



import java.util.Base64;
import java.util.ResourceBundle;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import com.ankhang.requestmodel.Request_AddCusMain;
import com.ankhang.responsemodel.Response_AddCustomer;
import com.google.gson.Gson;

public class Post_Customer {
	private ResourceBundle bundle = ResourceBundle.getBundle("ak_properties/link_api");
	
  private String postRequestWithAuthen(String api, String reqBody, String sign) {
	  String responseBody= "";
	  String url = bundle.getString("url_api");
	  System.out.println("URL POST: " +url + api);
	  PostMethod post = new PostMethod(url + api);
		/* Generate account to base 64 header Start */
//	  String username = "";
//	  String password = "";
//	  String valueToEncode = username + ":" + password;
//	    return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	  /* Generate account to base 64 header End */
	  post.addRequestHeader(new Header("Content-Type", "application/json"));
	  post.addRequestHeader(new Header("Authorization", "Basic " + sign));
	  RequestEntity entity = new ByteArrayRequestEntity(reqBody.getBytes());
	  post.setRequestEntity(entity);
	  
	  HttpClient httpClient = new HttpClient();
	  try {
		int result = httpClient.executeMethod(post);
		System.out.println(">>>Result Excute Method<<<" +result);
		if (result != HttpStatus.SC_OK) {
			System.out.println("PostRequestWithAuthen FAIL:" +post.getStatusLine());
		}else {
			responseBody = post.getResponseBodyAsString();
			System.out.println("responseBody: " + responseBody);
			return responseBody;
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("PostRequestWithAuthen FAIL Exception");
	}
	   finally {
		post.releaseConnection();
	}
	  return null;
  }
  
  public Response_AddCustomer getResponseAddCus(String nameCus, String maddCus, int ageCus) {
	  String api = bundle.getString("url_api.addcus");
	  Response_AddCustomer response_model = new Response_AddCustomer();
	  Request_AddCusMain request = new Request_AddCusMain();
	  request.setNameCus(nameCus);
	  request.setAgeCus(ageCus);
	  request.setMaddCus(maddCus);
	  Gson gson = new Gson();
	  String requestBody = gson.toJson(request);
	  System.out.println("AddCustomer requestBody: " +requestBody);
	  
	  String sign = bundle.getString("basic_authen.admin"); //admin - admin
	  
	  String response = postRequestWithAuthen(api,requestBody,sign);
	  System.out.println("AddCustomer responseBody: " +requestBody);
	  
	  if (response != null) {
		  response_model = gson.fromJson(response, Response_AddCustomer.class);
	}
	  return response_model;
  }
  
  public Response_AddCustomer getResponseFindCus(String maddCus) {
	  String api = bundle.getString("url_api.findcus");
	  Response_AddCustomer response_model = new Response_AddCustomer();
	  Request_AddCusMain request = new Request_AddCusMain();
	  request.setMaddCus(maddCus);
	  Gson gson = new Gson();
	  String requestBody = gson.toJson(request);
	  System.out.println("FindCustomer requestBody: " +requestBody);
	  
	  String sign = bundle.getString("basic_authen.user"); //admin - admin 
	  
	  String response = postRequestWithAuthen(api,requestBody,sign);
	  System.out.println("FindCustomer responseBody: " +response);
	  
	  if (response != null) {
		  response_model = gson.fromJson(response, Response_AddCustomer.class);
	}
	  return response_model;
  }
  
  
  public static void main(String[] args) {
		/* ADD CUSTOM API START */
//	  Post_Customer post_Customer = new Post_Customer();
//	  Response_AddCustomer rp = post_Customer.getResponseAddCus("Bin Bin", "00010", 23);
//	  System.out.println("Code:" + rp.getCodeRP());
//	  System.out.println("Message:" + rp.getMessageRP());
	  /* ADD CUSTOM API END */
	  
	  /* FIND CUSTOM API START */
	  Post_Customer post_Customer = new Post_Customer();
	  Response_AddCustomer rp = post_Customer.getResponseFindCus("fsadfasdfasd");
	  System.out.println("Code:" + rp.getCodeRP());
	  System.out.println("Message:" + rp.getMessageRP());
	  System.out.println("Name Cus:" + rp.getNameCus());
	  System.out.println("Age Cus:" + rp.getAgeCus());
	  /* FIND CUSTOM API END */
}
  
}
