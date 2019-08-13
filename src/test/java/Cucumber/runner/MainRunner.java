package Cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
/*
 * 
 */

@CucumberOptions(
		features = {"src/test/java/Cucumber/featureFiles/"},
		glue = {"Cucumber.steps"},
		monochrome = true,
		dryRun =false ,
		tags = {"@Chrome"},
		plugin = {"pretty","html:target/cucumber","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter: target/report.html"}
		)

public class MainRunner extends AbstractTestNGCucumberTests{
	
	

}
