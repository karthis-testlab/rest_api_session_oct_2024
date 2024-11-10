package week3.day2;

import io.restassured.RestAssured;

public class GetMethodWithQueryParamsUsingMap {

	public static void main(String[] args) {
		
		RestAssured.given()
		             .auth()
		             .basic("admin", "vW0eDfd+A0V-")
		             .pathParam("tableName", "incident")		             
		             .queryParam("sysparm_limit", "5")
		             .queryParam("sysparm_fields", "number,sys_id,short_description,description,state,urgency")
		             .log().all()
		           .when()
		             .get("https://dev262949.service-now.com/api/now/table/{tableName}")
		           .then()
		             .log().all()
		             .assertThat()
		             .statusCode(200);
		           
		           

	}

}
