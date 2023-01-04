package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC011_delete3 extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Delete an Incident (REST)";
		testDescription = "Delete an incident and Verify";
		nodes = "Incident";
		authors = "Shruthi Sudhakaran";
		category = "REST";
		
	}

	@Test(dependsOnMethods="tests.rest.TC011_PutIncident2.putIncident")
	public void deleteIncident() {		
				
		Response response = delete("/incident/"+sysID);
		System.out.println("hi inside deleting phase");
		response.prettyPrint();
		System.out.println("Hence deleted " +response.getStatusCode());
		
		//verification 
		verifyResponseCode(response,204);
		
	}


}




















