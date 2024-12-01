package week6.day2;

import org.json.JSONObject;

import io.restassured.RestAssured;

public class GrapQLApiTest {
	
	static String queryStr = """
			query {
  viewer {
    login
    url
    repositories {
      totalCount
    }
    followers {
      totalCount
    }
    url
    avatarUrl
    location
    company
  }
}
			""";

	public static void main(String[] args) {
	
		RestAssured.given()
		           .header("Authorization", "Bearer ")
		           .log().all()		           
		           .when()
		           .body(convertQueryToJsonString(queryStr))
		           .post("https://api.github.com/graphql")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);

	}
	
	public static String convertQueryToJsonString(String value) {
		JSONObject object = new JSONObject();
		object.put("query", value);
		return object.toString();
	}

}
