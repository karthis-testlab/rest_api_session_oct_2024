package week3.day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ServiceNowIncidentTableE2ETest extends TestNGHooks {
	
	private String tableName = "incident";
	
	@Test(priority = 0)
	public void userShouldAbleToCreateANewIncidentRecord() {
	   sysId = given()
		  .header("Content-Type", "application/json")
		  .pathParam("tableName", tableName)
		  .log().all()
		.when()
		  .post("/{tableName}")
		.then()
		  .spec(createResponseSpec())
		  .extract()
		  .jsonPath()
		  .getString("result.sys_id");
	}
	
	@Test(priority = 1)
	public void userShouldAbleToGetASingleIncidentRecord() {
		given()
		  .pathParam("tableName", tableName)
		  .pathParam("sysId", sysId)
		  .log().all()
		.when()
		  .get("/{tableName}/{sysId}")
		.then()
		  .spec(getResponseSpec());
	}	
	
	@Test(priority = 2)
	public void userShouldAbleToUpdateAIncidentRecord() {
		given()
		  .pathParam("tableName", tableName)
		  .pathParam("sysId", sysId)
		  .log().all()
		.when()
		  .put("/{tableName}/{sysId}")
		.then()
		  .spec(putResponseSpec());
	}
	
	@Test(priority = 3)
	public void userShouldAbleToDeleteExicistingIncidentRecord() {
		given()
		  .pathParam("tableName", tableName)
		  .pathParam("sysId", sysId)
		  .log().all()
		.when()
		  .delete("/{tableName}/{sysId}")
		.then()
		  .spec(deleteResponseSpec());
	}
	
	@Test(priority = 4)
	public void userShouldAbleToSeeDeletedRecord() {
		given()
		  .pathParam("tableName", tableName)
		  .pathParam("sysId", sysId)
		  .log().all()
		.when()
		  .get("/{tableName}/{sysId}")
		.then()
		  .spec(notFoundResponseSpec());
	}

}