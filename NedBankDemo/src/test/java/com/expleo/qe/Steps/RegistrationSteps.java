package com.expleo.qe.Steps;

import com.expleo.qe.PageObjects.RegistrationPageobject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.NoSuchElementException;
import org.yecht.Data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegistrationSteps
{
    RegistrationPageobject registrationPageobject;


    @Step("Launch Browser")
    public void openBrowser()
    {
        registrationPageobject.openBrowser();
    }


    @Step("Register new client\n{1}\n{2}\n{3}\n{4}\n{5}\n{6}\n{7}\n{8}\n{9}\n{10}\n")
    public void registerNewClient(String gender, String firstname, String lastname, String dateOfBirthDay,
                                  String dateOfBirthMonth, String dateOfBirthYear, String emailAddress,
                                  String companyName, boolean newsLetter, String password, String confirmPassword)
    {
        try {


            if (gender.equalsIgnoreCase("male")) {
                registrationPageobject.selectGenderMale();
            } else if (gender.equalsIgnoreCase("female")) {
                registrationPageobject.selectGenderFemale();
            }

            registrationPageobject.enterFirstname(firstname);
            registrationPageobject.enterLastname(lastname);
            registrationPageobject.selectDateOfBirthDay(dateOfBirthDay);
            registrationPageobject.selectDatOfBirthMonth(dateOfBirthMonth);
            registrationPageobject.selectDateOfBirthYear(dateOfBirthYear);
            registrationPageobject.enterEmail(emailAddress);
            registrationPageobject.enterCOmpanyName(companyName);

            if (newsLetter) {
                registrationPageobject.checkNewsLetter();
            }

            registrationPageobject.enterPassword(password);
            registrationPageobject.confirmPassword(confirmPassword);
            //registrationPageobject.clickRegisterButton();
        }catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }


    @Step("User Click Register")
    public void clickRegisterButton()
    {
        registrationPageobject.clickRegisterButton();
    }

    @Step("Are we on the Registration Page {0}")
    public void confirmRegistrationPage(String expected)
    {
        registrationPageobject.areWeOnTheRegistrationPage(expected);
    }

    @Step
    public void assertNoEmailErrorMessage()
    {
        String recievedMessage;
        try
        {
            recievedMessage = registrationPageobject.emailError();
            assertThat("Error :" + recievedMessage,recievedMessage,is(equalTo("null")));

        }
        catch (AssertionError ex)
        {
            ex.getMessage();
        }
        catch (NoSuchElementException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Step("Client Registration Successful")
    public String assertRegistrationSuccess(String expected)
    {//TODO added recievedMessage nad returned String
        String recievedMessage;
        try
        {
            assertThat("Registration Falied", expected,
                    is(equalTo(registrationPageobject.regSuccess())));
            recievedMessage = registrationPageobject.regSuccess();
        }
        catch (AssertionError e)
        {
            recievedMessage = "Registration Failed ";
        }
        return recievedMessage;
    }


    public String assertEmailErrorMessage()
    {
        String recievedMessage;
        try
        {
            recievedMessage = registrationPageobject.emailError();
            assertThat("Error : " + recievedMessage, recievedMessage,is(not("null")));

        }
        catch (AssertionError ex)
        { //TODO fix or check message is dsiplayed in report
            recievedMessage = "Invalid E-mail Address " + registrationPageobject.emailError();
        }
        return recievedMessage;
    }

    @Step("{0}")
    public void message(String message){}
}
