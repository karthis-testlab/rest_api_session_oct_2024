package week3.day2;

import static io.restassured.RestAssured.*;

public class CreateOAuthToken {

	public static void main(String[] args) {
		given()
		  .header("Content-Type", "application/x-www-form-urlencoded")
		.when()		  
		  .formParam("grant_type", "password")
		  .formParam("client_id", "f598d0b6b8e19210a27b0a941da667cb")
		  .formParam("client_secret", "~}b<giUQpi")
		  .formParam("username", "admin")
		  .formParam("password", "vW0eDfd+A0V-")
		  .post("https://dev262949.service-now.com/oauth_token.do")
		.then()
		  .log().all();
	}

}