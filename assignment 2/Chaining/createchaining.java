package chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class createchaining extends RestAssuredBase {
	@Test
	public void createwithfile()
	
	{  System.out.println("creating");
	
		File fileName=new File("./src/test/resources/create.json");
		
		Response response = RestAssured.given().contentType("application/json")
				.when().body(fileName)
				.post("/incident");
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		JsonPath Path = response.jsonPath();
	    sys_id = Path.get("result.sys_id");
		System.out.println(sys_id);
		
	}

}
