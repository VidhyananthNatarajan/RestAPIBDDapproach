package com.RESTAssured.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnPUTRequest {
	
@Test
public void learnputmethod() {
	
	    //Define the Endpoint
	
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		//Specify the Request
		
		RequestSpecification httprequest = RestAssured.given();
		
        String token="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
		
		httprequest.header("Content-Type","application/json");
		httprequest.header("Authorization","Bearer "+token);
		
        JSONObject inputpath = new JSONObject();
		
		inputpath.put("name","Testuser20");
		inputpath.put("email","Testuser20@gmail.com");
		inputpath.put("gender","male");
		inputpath.put("status","active");
		
		httprequest.body(inputpath.toString());
		
		Response resp = httprequest.request(Method.PUT,"/5775068");
		
		String response_body = resp.getBody().asString();
		System.out.println("The response body is:" +response_body);
		
		int stcode =resp.getStatusCode();
		System.out.println("The status code is:" +stcode);
		Assert.assertEquals(stcode, 200);
		
		String st_line = resp.getStatusLine();
		System.out.println("The status line is:" +st_line);
		Assert.assertEquals(st_line,"HTTP/1.1 200 OK");
		
		//Data Validation
		String gender_value = resp.jsonPath().getString("gender");
		System.out.println("The updated gender value is:" +gender_value);
		Assert.assertEquals(gender_value,"male");
		
		String status_value = resp.jsonPath().getString("status");
		System.out.println("The updated gender value is:" +status_value);
		Assert.assertEquals(status_value,"active");
		
		String email_value = resp.jsonPath().getString("email");
		System.out.println("The updated gender value is:" +email_value);
		Assert.assertEquals(email_value,"Testuser20@gmail.com");
		
		String name_value = resp.jsonPath().getString("name");
		System.out.println("The updated gender value is:" +name_value);
		Assert.assertEquals(name_value,"Testuser20");
	
}

}
