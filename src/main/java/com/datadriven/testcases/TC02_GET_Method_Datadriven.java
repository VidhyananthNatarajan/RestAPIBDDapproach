package com.datadriven.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_GET_Method_Datadriven {
	

		@Test (dataProvider ="fetchdata")
	public void GET_Submit_Auth(String id, String name) {
		
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
		
		//Get the status code
		
		int status_code = response.getStatusCode();
		System.out.println("The Status code is:"+status_code);
		Assert.assertEquals(status_code, 200);
		
		//Get the status line
		
		String stline = response.getStatusLine();
		System.out.println("The Status line is:"+stline);
		Assert.assertEquals(stline,"HTTP/1.1 200 OK");
		
		//Data Validation
		
		String actual_name = response.jsonPath().getString("name");
		Assert.assertEquals(actual_name,name );
		
	
	} 
		
		@DataProvider (name ="fetchdata")
		public Object [][] getdata() throws IOException {
			
			return DataLibrary.dataread();
		}	
	
}	
