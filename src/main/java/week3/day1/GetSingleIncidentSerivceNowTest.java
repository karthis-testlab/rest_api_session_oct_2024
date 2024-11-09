package week3.day1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetSingleIncidentSerivceNowTest {
	
	@Test
	public void shouldUserAbleToFetchSignleIncidentRecord() {

		String url = "https://dev262949.service-now.com/api/now/table/{tableName}/{sysId}";
		
		given()
		  .auth()
		  .basic("admin", "vW0eDfd+A0V-")
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "46b66a40a9fe198101f243dfbc79033d")
		  .log().all()
	    .when()
	      .get(url)
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
