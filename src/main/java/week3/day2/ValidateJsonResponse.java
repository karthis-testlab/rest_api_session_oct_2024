package week3.day2;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateJsonResponse extends TestNGHooks {
	
	@Test
	public void validateTheKeyPresenceInTheResponse() {
		given()
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "7c4b31dd83f1d610695bc7b6feaad3ae")
		  .log().all()
		.when()
		  .get("/{tableName}/{sysId}")
		.then()
		  .assertThat()
		  .statusCode(200)
		  .statusLine(Matchers.containsString("OK"))
		  .contentType(ContentType.JSON)
		  .body("result", Matchers.hasKey("short_description"))
		  .body("result", Matchers.hasKey("description"));		   
	}
	
	@Test
	public void validateTheValueOfTheKeyInResponse() {
		given()
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "814c39518335d610695bc7b6feaad353")
		  .log().all()
		.when()
		  .get("/{tableName}/{sysId}")
		.then()
		  .assertThat()
		  .statusCode(200)
		  .statusLine(Matchers.containsString("OK"))
		  .contentType(ContentType.JSON)
		  .body("result.short_description", Matchers.equalTo("RESTAPIOCT2024"))
		  .body("result.description", Matchers.equalTo("Hitting POST method with request body / request payload"));		   
	}
	
	@Test
	public void validateSizeOfTheArrayInResponse() {
		given()
		  .pathParam("tableName", "incident")
		  .log().all()
		.when()
		  .get("/{tableName}")
		.then()
		  .assertThat()
		  .statusCode(200)
		  .statusLine(Matchers.containsString("OK"))
		  .contentType(ContentType.JSON)
		  .body("result.size()", Matchers.greaterThan(500));		
	}
	
	@Test
	public void extractSizeOfTheJsonArray() {
		List<Object> list = given()
				              .pathParam("tableName", "incident")
				              .log().all()
				           .when()
				              .get("/{tableName}")
				.then()
				  .assertThat()
				  .statusCode(200)
				  .statusLine(Matchers.containsString("OK"))
				  .contentType(ContentType.JSON)
				  .extract()
				  .jsonPath()
				  .getList("result");
				
		System.out.println(list.size());		
	}	
	
	@Test
	public void validateTheValueTypeOfTheKeyInResponse() {
		Response response = given()
		  .pathParam("tableName", "incident")
		  .pathParam("sysId", "814c39518335d610695bc7b6feaad353")
		  .log().all()
		.when()
		  .get("/{tableName}/{sysId}");	 
		
		Assert.assertTrue(response.jsonPath().get("result.short_description") instanceof String);
	}

}