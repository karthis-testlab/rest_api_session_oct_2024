package week6.day2;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredCookiesHandling {
	
	public static void main(String[] args) {
		
		String url = "https://dev262949.service-now.com/api/now/table/{tableName}";
		
		Response response = RestAssured.given()
		   .auth()
		   .basic("admin", "vW0eDfd+A0V-")
		   .pathParam("tableName", "incident")
		   .log().all()
		   .when()		      
		   .get(url);
		
		Map<String, String> cookies = response.getCookies();
		for (Entry<String, String> map : cookies.entrySet()) {
			System.out.println(map.getKey() +" = "+map.getValue());
		}
		
		System.out.println(response.getCookie("JSESSIONID"));
		
		RestAssured.given()  
		    .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
			.pathParam("tableName", "incident")
		    .log().all()
		    .when()		      
		    .get(url+"/1c741bd70b2322007518478d83673af3")
		    .then()
		    .assertThat()
		    .statusCode(200);
		
		RestAssured.given()
		           .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
		           .pathParam("tableName", "incident")
		           .header("Content-Type", "application/json")
		           .log().all()
		           .when()
		           .post(url)
		           .then()
		           .log().all();
		              
		
	}

}