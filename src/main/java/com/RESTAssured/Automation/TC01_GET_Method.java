package com.RESTAssured.Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GET_Method {
	
@Test
public void GET_Submit() {
	
	//Define the Endpoint
	
	RestAssured.baseURI="https://reqres.in/api/users";
	
	//Specify the Request
	
	RequestSpecification httprequest = RestAssured.given();
	
	//Submit the request
	
	Response response = httprequest.request(Method.GET,"/1");
	
	//Get the response body
	
	String responsebody = response.getBody().asString();
	
	System.out.println("The Response body is:" +responsebody);
	
	//Get the status code
	
	int status_code = response.getStatusCode();
	System.out.println("The Status code is:"+status_code);
	Assert.assertEquals(status_code, 200);
	
	//Get the status line
	
	String stline = response.getStatusLine();
	System.out.println("The Status line is:"+stline);
	Assert.assertEquals(stline,"HTTP/1.1 200 OK");
	
	//Data Validation
	
	String firstname = response.jsonPath().getString("data.first_name");
	System.out.println("The first name is:" +firstname);
	Assert.assertEquals(firstname, "George");
	
	String lastname = response.jsonPath().getString("data.last_name");
	System.out.println("The last name is:" +lastname);
	Assert.assertEquals(lastname, "Bluth");
	
	String email = response.jsonPath().getString("data.email");
	System.out.println("The email Id is:" +email);
	
	if (email.contains("test")) {
		System.out.println("First name of email has been verified successfully");
		
	} else {
		System.out.println("First name not verified successfully");
		Assert.fail("First name not verified");
	}
	
	
	
}

}
