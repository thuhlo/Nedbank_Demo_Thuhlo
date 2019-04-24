package com.expleo.qe.StepDefenition;

import com.expleo.qe.CSVfileConnection;
import com.expleo.qe.DataModel;
import com.expleo.qe.PageObjects.IterCounter;
import com.expleo.qe.Steps.NavigationSteps;
import com.expleo.qe.Steps.RegistrationSteps;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import java.io.IOException;
import java.util.ArrayList;

public class RegistrationStepDef
{

    @Steps
    NavigationSteps navigationSteps;

    @Steps
    RegistrationSteps registrationSteps;

    IterCounter iter = new IterCounter();
    boolean newsLetterTick;
    ArrayList<DataModel> testData;


    @Given("^User opens home page$")
    public void user_opens_home_page()
    {
        navigationSteps.openBrowser();
    }

    @And("^User clicks on register link$")
    public void user_clicks_on_register_link()
    {
        navigationSteps.clickRegister();
    }

    /////////////////////////////////////////////////////////////////////////////
    ////////////////////////////Scenario 1//////////////////////////////////////

    @When("^User enters invalid details$")
    public void user_enters_invalid_details() throws IOException
    {
        testData = CSVfileConnection.readCSVfile();

        newsLetterTick = iter.setNewsLetter(testData.get(iter.getCounter()).getNewsLetter());

        registrationSteps.registerNewClient(testData.get(iter.getCounter()).getGender(),
                testData.get(iter.getCounter()).getFirstName(),testData.get(iter.getCounter()).getLastName(),
                testData.get(iter.getCounter()).getDateOfBirthDay(),testData.get(iter.getCounter()).getDateOfBirthMonth()
                ,testData.get(iter.getCounter()).getDateOfBirthYear(),testData.get(iter.getCounter()).getEmailAddress(),
                testData.get(iter.getCounter()).getCompanyName(),newsLetterTick
                , testData.get(iter.getCounter()).getPassWord(),testData.get(iter.getCounter()).getConfirmPassword());
    }

    @And("^clicks on the register link$")
    public void clicks_on_the_register_link() throws InterruptedException {

        registrationSteps.clickRegisterButton();
        //was 5000
        Thread.sleep(2000);

    }

    @Then("^User should not be registered$")
    public void user_should_not_be_registered() throws InterruptedException {
        iter.incrmentCounter();
        System.out.println("First Then : counter ==" + iter.getCounter());
        registrationSteps.message(registrationSteps.assertEmailErrorMessage());
        //registrationSteps.assertEmailErrorMessage();
        //was 2000
        Thread.sleep(1000);
        //TODO put assertion code for the registration process

    }

    /////////////////////////////////////////////////////////////////////////////
    ///////////////////////////Scenario 2////////////////////////////////////////



    @When("^user enters valid details$")
    public void user_enters_valid_details() throws IOException
    { //TODO maybe increment from this point
        testData = CSVfileConnection.readCSVfile();
        newsLetterTick = iter.setNewsLetter(testData.get(iter.getCounter()).getNewsLetter());
        registrationSteps.registerNewClient(testData.get(iter.getCounter()).getGender(),
                testData.get(iter.getCounter()).getFirstName(),testData.get(iter.getCounter()).getLastName(),
                testData.get(iter.getCounter()).getDateOfBirthDay(),testData.get(iter.getCounter()).getDateOfBirthMonth()
                ,testData.get(iter.getCounter()).getDateOfBirthYear(),testData.get(iter.getCounter()).getEmailAddress(),
                testData.get(iter.getCounter()).getCompanyName(),newsLetterTick
                , testData.get(iter.getCounter()).getPassWord(),testData.get(iter.getCounter()).getConfirmPassword().trim());
    }

    @And("^clicks on the register button$")
    public void clicks_on_the_register_button() throws InterruptedException {
        //was 5000
        Thread.sleep(2000);
        registrationSteps.clickRegisterButton();
        //Thread.sleep(5000);
    }


    @Then("^user should be registered$")
    public void user_should_be_registered()
    {
        registrationSteps.message(registrationSteps.assertRegistrationSuccess("Your registration completed"));
        //registrationSteps.assertRegistrationSuccess("Your registration completed");
        iter.incrmentCounter();
        System.out.println("Second Then : counter ==" + iter.getCounter());

    }

}
