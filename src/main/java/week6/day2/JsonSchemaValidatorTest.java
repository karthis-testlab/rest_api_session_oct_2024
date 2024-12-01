package week6.day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidatorTest {
	
	WireMockServer mockingServer;
	String expectJsonSchema = """
			{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "code": {
      "type": "integer"
    },
    "message": {
      "type": "string"
    }
  },
  "required": [
    "code",
    "message"
  ]
}
			""";
	
	@BeforeMethod
	public void setUp() {
		mockingServer = new WireMockServer(8181);
		mockingServer.start();
		
		mockingServer.stubFor(
				     
				     WireMock.get("/welcome")
				     .willReturn(
				    	WireMock.aResponse()
				    	        .withStatus(200)
				    	        .withHeader("Content-Type", "application/json")
				    	        .withBody("{ \"code\": 200, \"message\": \"Created\" }")
				      )
				
		);
	}
	
	@AfterMethod
	public void afterMethod() {
		mockingServer.stop();
	}
	
	@Test
	public void main() {		
		
		RestAssured.given()
		           .when()
		           .get("http://localhost:8181/welcome")
		           .then()
		           .log().all()
		           .assertThat()
		           .body(JsonSchemaValidator.matchesJsonSchema(expectJsonSchema));
		
	}

}