package week6.day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class MockingGetCallAndTest {
	
	WireMockServer mockingServer;
	
	@BeforeMethod
	public void setUp() {
		mockingServer = new WireMockServer(8181);
		mockingServer.start();
		
		mockingServer.stubFor(
				     
				     WireMock.post("/creating")
				     .withHeader("Content-Type", WireMock.equalTo("application/json"))
				     .withRequestBody(WireMock.equalToJson("{ \"name\": \"Karthi\"}"))
				     
				     .willReturn(
				    	WireMock.aResponse()
				    	        .withStatus(200)
				    	        .withHeader("Content-Type", "application/json")
				    	        .withBody("{ \"code\": \"201\", \"message\": \"Created\" }")
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
		           .header("Content-Type", "application/json")
		           .when()
		           .body("{ \"name\": \"Karthi\"}")
		           .post("http://localhost:8181/creating")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(201);
		
	}

}