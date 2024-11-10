package week3.day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ServiceNowPostMethodXmlResponse extends TestNGHooks {
	
	@Test
	public void shouldUserAbleToCreateNewIncidentRecord() {
		
		  given()
		    .header("Content-Type", "application/json")
		    .header("Accept", "application/xml")
		    .pathParam("tableName", "incident")		                 
		  .when()		  
		     .post("/{tableName}")
		  .then()		                
		      .assertThat()
		       .statusCode(201)
		       .and()
		       .contentType(ContentType.XML);
		
	}

}