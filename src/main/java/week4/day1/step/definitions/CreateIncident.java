package week4.day1.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import week3.day1.CreateIncidentPojo;

public class CreateIncident {
	
	Response response;
	CreateIncidentPojo pojo = new CreateIncidentPojo();
	
	@Given("User set the the baseuri and baseurl of the servicenow api")
	public void user_set_the_the_baseuri_and_baseurl_of_the_servicenow_api() {
		RestAssured.baseURI = "https://dev262949.service-now.com";
		RestAssured.basePath = "/api/now/table/{tableName}";
	}

	@Given("the user set the basic authentication for the servicenow api")
	public void the_user_set_the_basic_authentication_for_the_servicenow_api() {
		RestAssured.authentication = RestAssured.basic("admin", "vW0eDfd+A0V-");
	}

	@When("sent the post request without body to the servicenow server")
	public void sent_the_post_request_without_body_to_the_servicenow_server() {
		response = RestAssured.given()
				   .log().all()
		           .header("Content-Type", "application/json")
		           .pathParam("tableName", "incident")
		           .when()
		           .post();
	}
	
	@When("/^send the post request with the descreprtion (.*) in the request payload$/")
	public void send_the_post_request_with_the_descreprtion_description_in_the_request_payload(String arg) {
	    pojo.setDescription(arg);
	}
	
	@When("/^send the post request with the short descreprtion (.*) in the request payload$/")
	public void send_the_post_request_with_the_short_descreprtion_short_description_in_the_request_payload(String arg) {
	    pojo.setShort_description(arg);
	    response = RestAssured.given()
	                .log().all()
	                .header("Content-Type", "application/json")
			        .pathParam("tableName", "incident")
			        .when()
			        .body(pojo)
			        .post();
	}

	@Then("the user successfully create one incident new record into the table")
	public void the_user_successfully_create_one_incident_new_record_into_the_table() {
		response.then().log().all().assertThat().statusCode(201);
	}

}