package week3.day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week3.day1.CreateIncidentPojo;

public class ServiceNowPostMethodDataDriven extends TestNGHooks {
	
	@DataProvider
	public Object[][] requestPayload() {		
		return new Object[][] {
			{"Description 1", "Short Description 1"},
			{"Description 2", "Short Description 2"}
		};
	}
	
	@Test(dataProvider = "requestPayload")
	public void shouldUserAbleToCreateNewIncidentRecord(String description, String shortDescription) {
		
		CreateIncidentPojo pojo = new CreateIncidentPojo();
		pojo.setDescription(description);
		pojo.setShort_description(shortDescription);
		
		given()
		  .header("Content-Type", "application/json")
		  .pathParam("tableName", "incident")
		  .log().all()
		.when()	
		  .body(pojo)
		  .post("/{tableName}")
		.then()		  
		  .assertThat()
		  .statusCode(201);
	}

}