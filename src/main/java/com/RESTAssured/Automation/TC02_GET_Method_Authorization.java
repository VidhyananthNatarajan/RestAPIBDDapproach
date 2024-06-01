package com.RESTAssured.Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_GET_Method_Authorization {
	
// id =5774046
		@Test
	public void GET_Submit_Auth() {
		
		//Define the Endpoint
		
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		//Specify the Request
		
		RequestSpecification httprequest = RestAssured.given();
		
		String token="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
		
		httprequest.header("Authorization","Bearer "+token);
		
		//Submit the request
		
		Response response = httprequest.request(Method.GET,"/5775068");
		
		String resp_body =response.getBody().asString();
		
		System.out.println("The response body is:"+resp_body);
		
		//Data Validation
		
		String name =response.jsonPath().getString("name");
		Assert.assertEquals(name,"Testuser12");
		
		if (name.equalsIgnoreCase("testUser12")) {
			System.out.println("Value for the field:name matches successfully");
		} else {
			Assert.fail("Mismatch in the values");
		}
		
		String ctype = response.getContentType();
		System.out.println("The content type is:" +ctype);
		Assert.assertEquals(ctype,"application/json; charset=utf-8");
		
		long time = response.getTime();
		System.out.println("The response time is:" +time);
	}
	
}	
