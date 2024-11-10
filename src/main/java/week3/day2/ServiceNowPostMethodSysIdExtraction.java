package week3.day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ServiceNowPostMethodSysIdExtraction extends TestNGHooks {
	
	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
		String sysId = given()
		                 .header("Content-Type", "application/json")
		                 .header("Accpet", "application/json")
		                 .pathParam("tableName", "incident")		                 
		               .when()		  
		                 .post("/{tableName}")
		               .then()		                
		                 .assertThat()
		                 .statusCode(201)
		                 .and()
		                 .contentType(ContentType.JSON)
		                 .extract()
		                 .jsonPath()
		                 .getString("result.sys_id");
		
		System.out.println(sysId);
		
	}

}