package week3.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.http.ContentType;

public class CreateNewIncidentServiceNowWithBodyAsPojoObject {

	public static void main(String[] args) {
		
		CreateIncidentPojo obj = new CreateIncidentPojo();
		obj.setDescription("Hitting POST method with request body / request payload using POJO Object");
		obj.setShort_description("RESTAPIOCT2024");
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .header("Content-Type", "application/json")
		  .log().all()
	    .when()
	      .body(obj)
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