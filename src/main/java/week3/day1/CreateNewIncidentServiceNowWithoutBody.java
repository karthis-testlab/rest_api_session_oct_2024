package week3.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.http.ContentType;

public class CreateNewIncidentServiceNowWithoutBody {
	
	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .header("Content-Type", "application/json")
		  .log().all()
	    .when()
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
	        .time(lessThan(2000L));
		
	}

}