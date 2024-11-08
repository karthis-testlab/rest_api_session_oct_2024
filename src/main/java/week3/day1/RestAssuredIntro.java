package week3.day1;

public class RestAssuredIntro {
	
	/*
	 * 
	 * Rest-Assured is a Java domain-specific language (DSL) that simplifies the process of testing and validating REST APIs. 
	 * It's designed to make API testing more natural and easier to perform. Rest-Assured integrates well with existing 
	 * Java-based testing frameworks like JUnit and TestNG.
	 * 
	 * Key Features of Rest-Assured:
	 * 
	 * 1.) Readable Syntax: Provides a readable DSL for writing tests, making tests easy to understand and write.
	 * 
	 * 2.) BDD-style Tests: Supports Behavior-Driven Development (BDD) given/when/then syntax.
	 * 
	 * 3.) Support for Various HTTP Methods: Easily supports GET, POST, PUT, DELETE, PATCH, OPTIONS, and HEAD requests.
	 * 
	 * 4.) Authentication Support: Supports various authentication mechanisms like Basic, Digest, Form, and OAuth.
	 * 
	 * 5.) Easy Extraction and Validation: Provides easy ways to extract response data and validate JSON & XML responses.
	 * 
	 * 6.) Integration: Seamlessly integrates with testing frameworks like JUnit and TestNG.
	 * 
	 * 7.) Logging: Allows detailed request and response logging.
	 * 
	 * ex: First RestAssured Test Script
	 * 
	 *   given()
	 *     .pathParam("bookId", "12345")                               // Set path parameter
	 *   .when()
	 *     .get("https://api.yourdomain.com/books/{bookId}")           // Make GET request
	 *   .then() 
	 *     .statusCode(200)                                           // Check status code is 200
	 *     .and()
	 *     .statusLine(containsString("OK"))                          // Check status line contains OK
	 *     .and()
	 *     .contentType(ContentType.JSON)                             // Check response contentType is JSON format
	 *     .and()
	 *     .time(Matchers.lessThan(3000L));                           // Check response time should be less than 3000L
	 *     
	 * Here's a breakdown of the code:
	 * 
	 * -> baseURI sets the base URL for the API.
	 * -> given() begins a request specification. Inside it, we use .pathParam("bookId","2345") to set a path parameter for the book ID.
	 * -> when().get("/books/{bookId}") makes a GET request to the endpoint.
	 * -> then() begins a response specification. It verifies that the status code is 200, status line contains OK, 
	 *    response contentType is JSON format and response time should be less than 3000L
	 *    
	 *    With its fluent DSL and seamless integration with Java testing frameworks, 
	 *    Rest-Assured is an excellent choice for automating REST API testing. 
	 *    As you get more familiar with its features, you'll find it helps significantly in creating robust API tests.
	 * 
	 * 
	 */

}