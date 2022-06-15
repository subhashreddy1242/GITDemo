package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Stepdefinition {

    @Given("^User is on Home Page$")
    public void user_is_on_home_page() throws Throwable {
        throw new PendingException();
    }

    @When("^User Navigate to LogIn Page$")
    public void user_navigate_to_login_page() throws Throwable {
        throw new PendingException();
    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_login_successfully() throws Throwable {
        throw new PendingException();
    }

    @And("^User enters UserName and Password$")
    public void user_enters_username_and_password() throws Throwable {
        throw new PendingException();
    }

}