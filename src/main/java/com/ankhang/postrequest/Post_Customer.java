package com.ankhang.postrequest;



import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import com.ankhang.requestmodel.Request_AddCus;
import com.ankhang.responsemodel.Response_AddCustomer;
import com.google.gson.Gson;

public class Post_Customer {
  private String postRequestWithAuthen(String api, String reqBody, String sign) {
	  String responseBody= "";
	  String url = "http://localhost:8080/";
	  System.out.println("URL POST: " +url + api);
	  PostMethod post = new PostMethod(url + api);
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
	  String api = "addcus";
	  Response_AddCustomer response_model = new Response_AddCustomer();
	  Request_AddCus request = new Request_AddCus();
	  request.setNameCus(nameCus);
	  request.setAgeCus(ageCus);
	  request.setMaddCus(maddCus);
	  Gson gson = new Gson();
	  String requestBody = gson.toJson(request);
	  System.out.println("Response_AddCustomer requestBody: " +requestBody);
	  
	  String sign = "YWRtaW46YWRtaW4="; //admin - admin
	  
	  String response = postRequestWithAuthen(api,requestBody,sign);
	  System.out.println("Response_AddCustomer responseBody: " +requestBody);
	  
	  if (response != null) {
		  response_model = gson.fromJson(response, Response_AddCustomer.class);
	}
	  return response_model;
  }
  
  
  public static void main(String[] args) {
	  Post_Customer post_Customer = new Post_Customer();
	  Response_AddCustomer rp = post_Customer.getResponseAddCus("Bin Bin", "00010", 23);
	  System.out.println("Code:" + rp.getCodeRP());
	  System.out.println("Message:" + rp.getMessageRP());
}
  
}
