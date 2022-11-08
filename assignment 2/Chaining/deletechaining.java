package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deletechaining extends RestAssuredBase{
	@Test(dependsOnMethods="chaining.updatewithPutchaining.Updatewithstring")
	public void Delete()
	{
		System.out.println("Deleting");
		
		Response response = RestAssured.delete("/incident/"+sys_id);
				System.out.println(response.getStatusCode());
		
		response.prettyPrint();
	}
	

}
