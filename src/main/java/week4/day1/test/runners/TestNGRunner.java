package week4.day1.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/main/java/week4/day1/features/create-incident.feature"},
		          glue = {"week4.day1.step.definitions", "week4.day1.cucumber.hooks"},
		          dryRun = true,
		          publish = true,
		          //tags = "not @smoke",
		          plugin = {
		        		  "html:reports/cucumber-report.html"
		          }
		         )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}