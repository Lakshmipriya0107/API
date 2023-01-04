package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lib.rest.PreAndTest;
import lib.selenium.PreAndPost;

@CucumberOptions(features = { "src/test/java/features" }, 
glue = { "pages.selenium","pages.rest" }, 
monochrome = true)

//public class RunCucumberUsingTestNG extends PreAndTest{
//public class RunCucumberUsingTestNG extends PreAndPost{
	public class RunCucumberUsingTestNG extends AbstractTestNGCucumberTests{


}
