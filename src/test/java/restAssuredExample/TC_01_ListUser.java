package restAssuredExample;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01_ListUser {

	Response resp;
	
	@BeforeTest
	public void setupRequest() {

		// BaseURI
		RestAssured.baseURI = "https://reqres.in"; // Environment - QA/DEV/STAGE/PROD

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		// header
		// parameter
		// auth token
		//body/payload

		// Response Object
		resp = httpRequest.request(Method.GET, "/api/users?page=2"); // request sent to server
	}
	
	

	@Test
	public void verifyListUserTest() {

//		System.out.println(resp.asString());
//		System.out.println(resp.asPrettyString());

		System.out.println(resp.getContentType()); // application/json; charset=utf-8
		System.out.println(resp.getHeader("Content-Type")); // application/json; charset=utf-8
		System.out.println(resp.getStatusCode()); // 200
		System.out.println(resp.getStatusLine()); // HTTP/1.1 200 OK
		System.out.println(resp.getTime()); // Response Time
		System.out.println(resp.getBody().asPrettyString()); // body
		System.out.println(resp.getHeader("X-Powered-By")); // Express

	}
	
	@Test
	public void verifyStatusCode() {
		
		int actualStatusCode = resp.getStatusCode();						//Status Code: 200
		System.out.println("Status Code: " + actualStatusCode);
		Assert.assertEquals(actualStatusCode, 200);
	}
	
	
	@Test
	public void verifyContentType() {
		
		String actualContentType = resp.getContentType();						//application/json; charset=utf-8
		System.out.println("Status Code: " + actualContentType);
		Assert.assertEquals(actualContentType, "application/json; charset=utf-8");
		Assert.assertTrue(actualContentType.contains("json"));
		
	}

	
	@Test
	public void verifyHeaderPowered() {
		
		String actualHeader = resp.getHeader("X-Powered-By");						//Header: Express
		System.out.println("Status Code: " + actualHeader);
		Assert.assertEquals(actualHeader, "Express");
		Assert.assertTrue(actualHeader.contains("Express"));
		
	}
}
