package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC011_PutIncident2 extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Update the Incident (REST)";
		testDescription = "Update the incident and Verify";
		nodes = "Incident";
		authors = "Shruthi Sudhakaran";
		category = "REST";
		//dataProvider
		dataFileName = "TC2";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData",dependsOnMethods="tests.rest.TC001_CreateIncident.createIncident")
	public void putIncident(File file) {	
		
		System.out.println(sysID+ " Update is starting");
				
		Response response = putWithBodyParam(file,"/incident/"+sysID);
		response.prettyPrint();
		verifyContentType(response, "application/json");
		
		verifyResponseCode(response, 200);
		
		
		verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia-updated by shru");
		
	}


}




















