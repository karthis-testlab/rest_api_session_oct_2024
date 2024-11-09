package week3.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.http.ContentType;

public class UpdateIncidentSercviceNow {

	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}/{sysId}";
        
        String requestBody = """        		
        		 {
        		   "short_description": "RESTAPIOCT2024 - Update",
        		   "description": "Hitting PUT method with request body / request payload"
                 }        		
        		""";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "0ecd604183f51210695bc7b6feaad3ce")
		  .header("Content-Type", "application/json")
		  .log().all()
	    .when()
	      .body(requestBody)
	      .put(url)
	    .then()	      
	      .log().all()
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
