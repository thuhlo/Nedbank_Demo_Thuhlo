package com.expleo.qe.StepDefenition;

import com.expleo.qe.CSVfileConnection;
import com.expleo.qe.PageObjects.IterCounter;
import com.expleo.qe.ProductModel;
import com.expleo.qe.Steps.BuildYourOwnComputerSteps;
import com.expleo.qe.Steps.LogInSteps;
import com.expleo.qe.Steps.NavigationSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import java.io.IOException;
import java.util.ArrayList;


public class SelectProductStepDef {

    @Steps
    NavigationSteps navigationSteps;

    @Steps
    LogInSteps logInSteps;
    @Steps
    BuildYourOwnComputerSteps buildYourOwnComputerSteps;
    boolean microsoftOffice,acrobatReader,totCommander;
    ArrayList<ProductModel> productData;
    IterCounter iter = new IterCounter();

    @Given("^User is on the home page$")
    public void userIsOnTheHomePage()
    {
        logInSteps.openBrowser();
    }

    @And("^User is logged in$")
    public void userIsLoggedIn()
    {
        navigationSteps.clickLogInOrOut();
        logInSteps.logIn("tjMoabi@sqs.com","password");

    }

    @When("^User navigates to the Computers tap and selects Desktop$")
    public void userNavigatesToTheComputersTapAndSelectsDesktop()
    {
        navigationSteps.navigateToSubComputerDesktop();
    }

    @And("^Selects Build your own Computer link$")
    public void selectsBuildYourOwnComputerLink()
    {
        navigationSteps.buildYourOwnComputer();
    }

    @And("^Add a computer with certain specifications to the cart$")
    public void addAComputerWithCertainSpecificationsToTheCart() throws InterruptedException, IOException
    {
        productData = CSVfileConnection.readComputerSpecsfile();
        System.out.println("Step Def test position 0 of Iter ::" + productData.get(iter.getCounter2()).getProcessor());
        System.out.println("product data file size :" + productData.size());
        System.out.println("Product file counter at:" + iter.getCounter2());
        microsoftOffice = iter.chooseMSOffice(productData.get(iter.getCounter2()).getMicrosoftOffice());
        acrobatReader = iter.chooseAcrobat(productData.get(iter.getCounter2()).getAcrobatReader());
        totCommander = iter.chooseTotalCommander(productData.get(iter.getCounter2()).getTotalCommander());

        buildYourOwnComputerSteps.buildComputer(productData.get(iter.getCounter2()).getProcessor(),productData.get(iter.getCounter2()).getRam()
                ,productData.get(iter.getCounter2()).getHdd(),productData.get(iter.getCounter2()).getOparatingSystem(),microsoftOffice,
                acrobatReader,totCommander,productData.get(iter.getCounter2()).getQuantity());

        buildYourOwnComputerSteps.clickAddToCart();

        navigationSteps.navigateToCart();
    }

    @Then("^confirm that the item has correct specification$")
    public void confirmThatTheItemHasCorrectSpecification() throws InterruptedException {

        String expected= buildYourOwnComputerSteps.readFromTable();
        buildYourOwnComputerSteps.message(buildYourOwnComputerSteps.assertEqual(expected));

            //TODO check that the cart table has the same content
    }
}
