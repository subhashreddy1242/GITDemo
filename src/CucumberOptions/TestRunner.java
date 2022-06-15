package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Feature
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/Test_Features",
		glue = "StepDefinitions.Stepdefinition")
public class TestRunner {

}
