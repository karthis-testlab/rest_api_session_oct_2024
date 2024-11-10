package week3.day2;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class GetMethodWithQueryParam {

	public static void main(String[] args) {
		
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("sysparm_limit", "5");
		queryParams.put("sysparm_fields", "number,sys_id,short_description,description,state,urgency");
		
		RestAssured.given()
		             .auth()
		             .basic("admin", "vW0eDfd+A0V-")		             
		             .pathParam("tableName", "incident")		             
		             .queryParams(queryParams)
		             .log().all()
		           .when()
		             .get("https://dev262949.service-now.com/api/now/table/{tableName}")
		           .then()
		             .log().all()
		             .assertThat()
		             .statusCode(200);
		           
		           

	}

}
