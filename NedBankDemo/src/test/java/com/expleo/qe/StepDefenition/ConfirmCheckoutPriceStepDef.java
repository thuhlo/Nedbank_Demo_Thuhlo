package com.expleo.qe.StepDefenition;

import com.expleo.qe.Steps.BuildYourOwnComputerSteps;
import com.expleo.qe.Steps.LogInSteps;
import com.expleo.qe.Steps.NavigationSteps;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;


public class ConfirmCheckoutPriceStepDef
{

    @Steps
    NavigationSteps navigationSteps;
    @Steps
    LogInSteps logInSteps;

    @Steps
    BuildYourOwnComputerSteps buildYourOwnComputerSteps;


    @Given("^User navigates to home page$")
    public void userNavigatesToHomePage()
    {
        navigationSteps.openBrowser();
    }

    @And("^logs in with valid <username> and <password>$")
    public void clickLoginLinkAndLogsInWithValidUsernameAndPassword()
    {
       navigationSteps.clickLogInOrOut();
       logInSteps.logIn("tjMoabi@sqs.com","password");
    }

    @And("^Navigates to the Computers page and clicks Desktop tap$")
    public void navigatesToTheComputersPageAndClicksDesktopTap()
    {
        navigationSteps.navigateToSubComputerDesktop();
    }

    @When("^user selects build your own computer tab$")
    public void user_selects_build_your_own_computer_tab()
    {
        navigationSteps.buildYourOwnComputer();
    }

    @When("^user selects certain details of computer specifications$")
    public void user_selects_certain_details_of_computer_specifications() throws InterruptedException {
        buildYourOwnComputerSteps.firstClick();
        buildYourOwnComputerSteps.buildComputer("2.2 GHz Intel Pentium Dual-Core E2200","2 GB","320 GB","Home",
                false,false,false,"1");
    }

    @When("^click add to cart and navigates to the shopping cart page$")
    public void click_add_to_cart_and_navigates_to_the_shopping_cart_page() throws InterruptedException {
        buildYourOwnComputerSteps.clickAddToCart();
        //was 2000
        Thread.sleep(2000);
        //navigationSteps.scrollUp();
       // navigationSteps.scrollUp();
       // navigationSteps.scrollUp();
       // navigationSteps.scrollUp();
        //was 3000
        Thread.sleep(1000);
        navigationSteps.navigateToCart();


    }

    @Then("^total should be as expected$")
    public void total_should_be_as_expected()
    {
        navigationSteps.message(navigationSteps.assertFinalCheckoutPrice("$1,250.00"));
    }

}
