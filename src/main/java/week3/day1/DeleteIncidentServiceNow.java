package week3.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class DeleteIncidentServiceNow {

	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}/{sysId}";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "46b66a40a9fe198101f243dfbc79033d")
		  .log().all()
	    .when()
	      .delete(url)
	    .then()	      
	      .log().all()
	      .assertThat()
	        .statusCode(204)
	        .and()
	        .statusLine(containsString("No Content"))
	        .and()	        
	        .time(lessThan(5000L));

	}

}