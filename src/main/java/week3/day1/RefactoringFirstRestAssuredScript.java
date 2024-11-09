package week3.day1;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class RefactoringFirstRestAssuredScript {

	public static void main(String[] args) {
	
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		given()
         .auth()
         .basic("admin", "vW0eDfd+A0V-")
         .pathParam("tableName", "incident")
         .log().all() 
       .when()
         .get(url)
       .then()
         .log().all() // Response Log
         .assertThat()
         .statusCode(200)
         .and()
         .statusLine(containsString("OK"))
         .and()
         .contentType(ContentType.JSON)
         .and()
         .time(lessThan(5000L));
		
	}

}