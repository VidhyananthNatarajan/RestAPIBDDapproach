package com.datadriven.testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnPUTRequest_Datadriven {
	
@Test (dataProvider ="fetchdata")
public void learnputmethod_datadriven(String name,String email, String gender, String status ,String id) {
	
	    //Define the Endpoint
	
		RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		//Specify the Request
		
		RequestSpecification httprequest = RestAssured.given();
		
        String token="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
		
		httprequest.header("Content-Type","application/json");
		httprequest.header("Authorization","Bearer "+token);
		
        JSONObject inputpath = new JSONObject();
		
		inputpath.put("name",name);
		inputpath.put("email",email);
		inputpath.put("gender",gender);
		inputpath.put("status",status);
		
		httprequest.body(inputpath.toString());
		
		Response resp = httprequest.request(Method.PUT,"/"+id);
		
		String response_body = resp.getBody().asString();
		System.out.println("The response body is:" +response_body);
		
		int stcode =resp.getStatusCode();
		System.out.println("The status code is:" +stcode);
		Assert.assertEquals(stcode, 200);
		
		String st_line = resp.getStatusLine();
		System.out.println("The status line is:" +st_line);
		Assert.assertEquals(st_line,"HTTP/1.1 200 OK");
	
	
}

@DataProvider (name ="fetchdata")
public Object [][] getdata() throws IOException {
	
	return DataLibrary.dataread();
}

}
