package chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class RestAssuredBase {
	
	public static String sys_id;
	
	@BeforeMethod
	public void setup()
	{ 
		RestAssured.baseURI="https://dev60345.service-now.com/api/now/table";
		RestAssured.authentication=RestAssured.oauth2("0GEpeiRy6WGJ4PFJg2DJgBapuCgKG45HBBI9-1hUWmcjuxQXDUD7p9_4LvF0981mOnvUgdQRYJ66uYIjrEu_Nw");
	}

}
