package week3.day1;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class FirstRestAssuredScript {
	
	public static void main(String[] args) {
		
		/*
		 * Pre-Condition for the ServiceNow API Service:-
		 * 
		 * URL = "https://dev262949.service-now.com/api/now/table/{tableName}"
		 * HTTP Method = GET
		 * Basic-Auth = username/password
		 * Set Path Parameter value as "incident"
		 * 
		 * Action:-
		 * 
		 * Send the GET request
		 * 
		 * Assertion:
		 * 
		 * In RestAssured we used Hamcrest Library for Assertion
		 * 
		 *  1. Status Code
		 *  2. Status Line
		 *  3. Content Type
		 *  4. Response Time
		 * 
		 */
		
		RestAssured.given()
		             .auth()
		             .basic("admin", "vW0eDfd+A0V-")
		             .pathParam("tableName", "incident")
		             .log().all() // Request Log
		           .when()
		             .get("https://dev262949.service-now.com/api/now/table/{tableName}")
		           .then()
		           .log().all() // Response Log
		           .assertThat()
		             .statusCode(200)
		             .and()
		             .statusLine(Matchers.containsString("OK"))
		             .and()
		             .contentType(ContentType.JSON)
		             .and()
		             .time(Matchers.lessThan(5000L));
		
	}

}