package com.expleo.qe.StepDefenition;

import com.expleo.qe.Steps.LogInSteps;
import com.expleo.qe.Steps.NavigationSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStepDef
{

    @Steps
    LogInSteps logInSteps;

    @Steps
    NavigationSteps navigationSteps;

    @Given("^I navigate to homepage$")
    public void iNavigateToHomepage()
    {
        logInSteps.openBrowser();
    }

    @And("^click on the log-in link$")
    public void clickOnTheLogInLink()
    {
        navigationSteps.clickLogInOrOut();
        logInSteps.assertLoginpage("nopCommerce demo store. Login");
    }

    @When("^enter valid <username> and <password>$")
    public void enterValidUsernameAndPassword()
    {
        logInSteps.logIn("tjMoabi@sqs.com", "password");
    }

    @Then("^I should be logged into the system$")
    public void iShouldBeLoggedIntoTheSystem() throws InterruptedException {
        //was 2000
        Thread.sleep(1000);
        navigationSteps.validateLogIn("My account");
    }
}
