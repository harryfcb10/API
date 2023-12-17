package com.restAPI.apiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

@Test
public class BookerApi {
	ResponseSpecification responseSpec;
	String baseURI="https://restful-booker.herokuapp.com";
	String basePath="/auth";
    String requestBody = "{\"username\":\"admin\"}";
String request="{ \"username\":\"admin\",\"password\":\"password123\"}";
	public void postAPI() {
		
	Response resp=RestAssured.given()
		.baseUri(baseURI)
		.basePath(basePath)
		.contentType(ContentType.JSON)
		.body(request)
		.when()
		.post();
		resp.then()
		.statusCode(200)
		;
		int statusCode=resp.getStatusCode();
		String responseLine=resp.getStatusLine();
		System.out.println("Status Code is: "+statusCode);
		System.out.println(responseLine);
	}
	
	

}
