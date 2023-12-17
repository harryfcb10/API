package com.restAPI.apiTest;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class Test {
	ResponseSpecification responseSpec;
	String postAPI="https://reqres.in/api/register/api/users?page=2";
    String requestBody = "{\r\n"
    		+ "    \"page\": 2,\r\n"
    		+ "    \"per_page\": 6,\r\n"
    		+ "    \"total\": 12,\r\n"
    		+ "    \"total_pages\": 2,\r\n"
    		+ "    \"data\": [\r\n"
    		+ "        {\r\n"
    		+ "            \"id\": 7,\r\n"
    		+ "            \"email\": \"michael.lawson@reqres.in\",\r\n"
    		+ "            \"first_name\": \"Michael\",\r\n"
    		+ "            \"last_name\": \"Lawson\",\r\n"
    		+ "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n"
    		+ "        },\r\n"
    		+ "        {\r\n"
    		+ "            \"id\": 8,\r\n"
    		+ "            \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
    		+ "            \"first_name\": \"Lindsay\",\r\n"
    		+ "            \"last_name\": \"Ferguson\",\r\n"
    		+ "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n"
    		+ "        },\r\n"
    		+ "        {\r\n"
    		+ "            \"id\": 9,\r\n"
    		+ "            \"email\": \"tobias.funke@reqres.in\",\r\n"
    		+ "            \"first_name\": \"Tobias\",\r\n"
    		+ "            \"last_name\": \"Funke\",\r\n"
    		+ "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n"
    		+ "        },\r\n"
    		+ "        {\r\n"
    		+ "            \"id\": 10,\r\n"
    		+ "            \"email\": \"byron.fields@reqres.in\",\r\n"
    		+ "            \"first_name\": \"Byron\",\r\n"
    		+ "            \"last_name\": \"Fields\",\r\n"
    		+ "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n"
    		+ "        },\r\n"
    		+ "        {\r\n"
    		+ "            \"id\": 11,\r\n"
    		+ "            \"email\": \"george.edwards@reqres.in\",\r\n"
    		+ "            \"first_name\": \"George\",\r\n"
    		+ "            \"last_name\": \"Edwards\",\r\n"
    		+ "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n"
    		+ "        },\r\n"
    		+ "        {\r\n"
    		+ "            \"id\": 12,\r\n"
    		+ "            \"email\": \"rachel.howell@reqres.in\",\r\n"
    		+ "            \"first_name\": \"Rachel\",\r\n"
    		+ "            \"last_name\": \"Howell\",\r\n"
    		+ "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n"
    		+ "        }\r\n"
    		+ "    ],\r\n"
    		+ "    \"support\": {\r\n"
    		+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
    		+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
    		+ "    }\r\n"
    		+ "}";
		public void testStatusCode() {
		given().get("https://jsonplaceholder.typicode.com/posts/3").
		then().
		statusCode(200).log().all();
	}
	public void testr() throws ParseException, IOException {
		given().get("https://google.com").then().statusCode(200).log().all();
		Response response1=RestAssured.get("http://reqres.in/api/unknown/2");
		System.out.println(response1.getStatusCode());
		String responseBody1=response1.getBody().asString();
	System.out.println(responseBody1);
	String pretty=response1.asPrettyString();
	System.out.println(pretty);
		 Response response = RestAssured.given()
	                .baseUri(postAPI)
	                .body(requestBody)
	                .contentType(ContentType.JSON)
	                .post();
		// Print the response status code
	        System.out.println("Status Code: " + response.getStatusCode());

	        // Print the response body
	        String responseBody = response.getBody().asString();
	        System.out.println("Response Body: " + responseBody);


	}
	
	public void test1() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.basePath = "/api/unknown/2";
		
		
	Response resp1=	RestAssured.given().post();
	int respCode=resp1.getStatusCode();
	System.out.println(respCode);
	}
	
	@org.testng.annotations.Test
	public void test2() {
		
	RestAssured.given().formParam("page", 2)
		.get("https://reqres.in/api/users").getStatusCode();
	Response response;
	response=get("https://reqres.in/api/users");
	int sc=response.getStatusCode();
	System.out.println(sc);
	
int scc=RestAssured.given()
.auth().basic(requestBody, postAPI)
.baseUri("https://reqres.in/api")
.header("name", "Harry")
.basePath("/users?page=2")
.get()
.getStatusCode();
System.out.println(scc);
	}

	
	
	public void givvenTest() {
	String urll=
			given()
				.get("http://reqres.in/api/unknown/2").
			
			then()
			.extract()
				.path("support.url");
				System.out.println("URL IS:  "+urll);
		 
	//given().get("http://reqres.in/api/unknown/2").then().assertThat().body("support.url", equalTo("https://reqres.in/#support-heading"));
	 
		
	}

	public void givvenTest1() {
		given().
		 get("http://thomas-bayer.com/sqlrest/CUSTOMER/10/").then().assertThat().body("support.url", equalTo("https://reqres.in/#support-heading"));
	} 
	public void xpath() {
		given().get("https://reqres.in/api/users?delay=3").then().assertThat().body(containsString("George")).and().body(containsString("Bluth")).and().body("support.url", equalTo("https://reqres.in/#support-heading"));
		// get("/something").then().assertThat().body(containsString("OK")).and().body(containsString("something else"));
		 

		}
	//assertThat(responseBody, hasXPath("/path/to/element/text()", equalTo("expectedValue")));
public void extractdata() {
	String href=given().get("http://jsonplaceholder.typicode.com/photos/1").then().extract().path("url");
	System.out.println(href);
}

	public void jsonvalidate() {
	RestAssured.given()
    .when()
    .get("http://json-schema.org/draft-07/schema")
	.then() .assertThat() 
	 .body(matchesJsonSchemaInClasspath("jsonSchema.json"));
;

	 

	}
	
	public void gruvi() {
	RestAssured.given()
	.pathParam("page1", "posts")
	.pathParam("number", "3").
	 get("https://jsonplaceholder.typicode.com/{page1}/{number}").then().assertThat().body("title*.length().sum()",equalTo(59));

}
	
	public void testdata() {
		String data=
				given()
					.get("https://gorest.co.in/public/v2/users").
				
				then()
				.extract().asString();
		JsonPath jsonPath = new JsonPath(data);
		List <String> list =jsonPath.get("name");		
		System.out.println(list.size());
		//System.out.println(list);
		for (String s : list) {
            System.out.println(s);
		//for(list:a)
		}
	
	}
	
	
	 
	public void getheader() {//Get cookies and headers from response Response
		Response  respons =RestAssured.get("https://gorest.co.in/public/v2/users"); String
	  connection=respons.getHeader("connection");
	  System.out.println("Headers are printed below");
	  
	  System.out.println(connection);
	  
	  Headers headers = respons.getHeaders();
      for (io.restassured.http.Header h : headers) {
          System.out.println(h.getName() + ": " + h.getValue());
      }

      Map<String, String> cookies = respons.getCookies();
      System.out.println("Cookies are printed below");
      for (Map.Entry<String, String> entry : cookies.entrySet()) {
          System.out.println(entry.getKey() + ": " + entry.getValue());
      }
	 
	//https://reqres.in/api/users/2
	
		
	







}}
