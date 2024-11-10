package week3.day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ServiceNowIncidentTablePutTest extends TestNGHooks {
	
	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
		given()
		  .header("Content-Type", "application/json")
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "5ff86d15837d9610695bc7b6feaad361")
		.when()		  
		  .put("/{tableName}/{sysId}")
		.then()
		  .assertThat()
		  .statusCode(200);
	}

}