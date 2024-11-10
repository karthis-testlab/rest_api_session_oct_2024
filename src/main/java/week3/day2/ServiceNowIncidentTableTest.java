package week3.day2;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ServiceNowIncidentTableTest {
	
	@BeforeMethod
	public void setUp() {
		baseURI = "https://dev262949.service-now.com";
		basePath = "/api/now/table";
		authentication = basic("admin", "vW0eDfd+A0V-");
	}
	
	@Test
	public void shouldUserAbleToFetchAllIncidentRecords() {
		given()
		  .pathParam("tableName", "incident")
		  .log().all()
		.when()
		  .get("/{tableName}")
		.then()
		  .assertThat()
		  .statusCode(200);
	}
	
	@Test
	public void shouldUserAbleToFetchASingleIncidentRecord() {
		given()
		.pathParam("tableName", "incident")
		.log().all()
		.when()
		  .get("/{tableName}")
		.then()
		  .assertThat()
		  .statusCode(200);
	}

}