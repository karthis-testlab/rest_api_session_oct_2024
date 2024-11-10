package week3.day2;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class ServiceNowIncidentTablePostTest extends TestNGHooks {
	
	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
		given()
		  .header("Content-Type", "application/json")
		  .pathParam("tableName", "incident")
		.when()		  
		  .post("/{tableName}")
		.then()
		  .log().all()
		  .spec(createResponseSpec());
	}

}