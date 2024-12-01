package week6.day2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

public class MockingPostCallAndJsonTest {
	
	WireMockServer mockingServer;
	
	@BeforeMethod
	public void setUp() {
		mockingServer = new WireMockServer(8181);
		mockingServer.start();
		
		mockingServer.stubFor(
				     
				     WireMock.get("/welcome")
				     .willReturn(
				    	WireMock.aResponse()
				    	        .withStatus(200)
				    	        .withBody("Welcome to WireMock Java Library")
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
		           .log().all();		
		
	}

}