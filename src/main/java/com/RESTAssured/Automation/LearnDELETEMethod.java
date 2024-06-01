package com.RESTAssured.Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnDELETEMethod {
	
@Test
public void deleterequest() {
	
	//Define the Endpoint
	
	RestAssured.baseURI="https://gorest.co.in/public/v2/users";
			
	//Specify the Request
			
	RequestSpecification httprequest = RestAssured.given();
			
	String token="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
			
	httprequest.header("Content-Type","application/json");
	httprequest.header("Authorization","Bearer "+token);
	
	Response resp = httprequest.request(Method.DELETE,"/5775068");
	
	String resp_body = resp.getBody().asString();
	System.out.println("The response body is :" +resp_body);
	
	System.out.println("The Status code is:" +resp.getStatusCode());
	int st_code = resp.getStatusCode();
	Assert.assertEquals(st_code, 204);
	
	
	
	System.out.println("The status line is:" +resp.getStatusLine());
	
	Assert.assertEquals(resp.getStatusLine(),"HTTP/1.1 204 No Content");
	
}

}
