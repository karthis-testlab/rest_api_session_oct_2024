package week3.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.http.ContentType;

public class CreateNewIncidentServiceNowWithBodyAsString {
	
	/*
	 * In Rest-Assures We can Pass the Request Body in 3 ways
	 * 
	 * 1. Pass request-body as a String
	 * 2. Pass request-body as a File
	 * 3. Pass request-body as a Object (POJO - Serialisation)
	 * 
	 */

	public static void main(String[] args) {
		
        String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
        
        String requestBody = """        		
        		 {
        		   "short_description": "RESTAPIOCT2024",
        		   "description": "Hitting POST method with request body / request payload"
                 }        		
        		""";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .header("Content-Type", "application/json")
		  .log().all()
	    .when()
	      .body(requestBody)
	      .post(url)
	    .then()	      
	      .log().all()
	      .assertThat()
	        .statusCode(201)
	        .and()
	        .statusLine(containsString("Created"))
	        .and()
	        .contentType(ContentType.JSON)
	        .and()
	        .time(lessThan(5000L));

	}

}
