package lib.rest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lib.utils.DataInputProvider;
import lib.utils.HTMLReporter;

public class PreAndTest extends HTMLReporter{

	public String dataFileName, dataFileType;
	public static String sysID;
	public static String token;
	//Reporting
	@BeforeSuite
	public void beforeSuite() {
		startReport();	// set report path	
	}
	//Reporting - > creating entry for each testcases
	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);		
	}


	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {
		//for reports		
		svcTest = startTestModule(nodes);
		svcTest.assignAuthor(authors);
		svcTest.assignCategory(category);

		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));



		
		//RestAssured.authentication = RestAssured.oauth2(prop.getProperty("OAuth"));
		RestAssured.baseURI = "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/";
		RestAssured.authentication = RestAssured.basic(prop.getProperty("username"),prop.getProperty("password"));
		//Response response = RestAssured.given().contentType("application/json").when().body("{\"username\":\"darshanr\",\"password\":\"Leaf@1234\"}").post();
		//JsonPath path = response.jsonPath();
		//token=path.get("id");




	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterSuite
	public void afterSuite() {
		// report output
		endResult();
	}

	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		if(dataFileType.equalsIgnoreCase("Excel"))
			return DataInputProvider.getSheet(dataFileName);	
		else if(dataFileType.equalsIgnoreCase("JSON")){
			Object[][] data = new Object[1][1];
			data[0][0] = new File("./data/"+dataFileName+"."+dataFileType);
			System.out.println(data[0][0]);
			return data;
		}else {
			return null;
		}

	}

	public long takeSnap() {
		return 0;
	}	



}
