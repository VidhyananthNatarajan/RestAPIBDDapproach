package com.requestchain;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_GET_Method_Authorization extends TC03_POST_Method_Authorization {
	

		@Test
	public void GET_Submit_Auth(String id) {
		
		//Define the Endpoint
		
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		//Specify the Request
		
		RequestSpecification httprequest = RestAssured.given();
		
		String token="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
		
		httprequest.header("Authorization","Bearer "+token);
		
		//Submit the request
		
		Response response = httprequest.request(Method.GET,"/" +id);
		
		String resp_body =response.getBody().asString();
		
		System.out.println("The response body is:"+resp_body);
		
		
	}
	
}	
