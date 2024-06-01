package com.RESTAssured.Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_POST_Method_Authorization {
	
	@Test
	public void POST_Submit_Auth() {
		
		//Define the Endpoint
		
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		//Specify the Request
		
		RequestSpecification httprequest = RestAssured.given();
		
		String token="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
		
		httprequest.header("Content-Type","application/json");
		httprequest.header("Authorization","Bearer "+token);
		
		JSONObject inputpath = new JSONObject();
		
		inputpath.put("name","Testuser14");
		inputpath.put("email","Testuser14@gmail.com");
		inputpath.put("gender","male");
		inputpath.put("status","Active");
		
		httprequest.body(inputpath.toString());
		
		Response response = httprequest.request(Method.POST);
		
		String resp_body = response.getBody().asString();
		System.out.println("The response body is:" +resp_body);
		
		String id = response.jsonPath().getString("id");
		System.out.println("The id is:" +id);
		
		int stcode = response.getStatusCode();
		System.out.println("The Status code is:" +stcode);
		
		if ((stcode ==201)) {
			System.out.println("Status code matches successfully");
		} else {
			System.out.println("Mismatch in status code.");
		}
		
		
		
		}
}
