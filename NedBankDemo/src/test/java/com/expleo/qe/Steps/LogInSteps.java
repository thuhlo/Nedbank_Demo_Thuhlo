package com.expleo.qe.Steps;

import com.expleo.qe.PageObjects.LoginPageObject;
import com.expleo.qe.StepDefenition.LoginStepDef;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class LogInSteps
{


    LoginPageObject loginPageObject;

    @Step("Open the Browser")
    public void openBrowser()
    {
        loginPageObject.openBrowser();
    }


    @Step("Client login {0}\n{1}")
    public void logIn(String emailAddress, String password)
    {
        loginPageObject.enterEmailAddress(emailAddress);
        loginPageObject.enterPassword(password);
        loginPageObject.clickLogIn();
    }

    @Step("Client login {0}\n{1}\n{2}")
    public void logIn(String emailAddress, String password, boolean rememberMe)
    {
        loginPageObject.enterEmailAddress(emailAddress);
        loginPageObject.enterPassword(password);
        if(rememberMe) {
            loginPageObject.clickRemmemberMe();
        }
        loginPageObject.clickLogIn();
    }

    @Step("Are we on the log in Page {0}")
    public void assertLoginpage(String expected)
    {
        loginPageObject.assertLogInPage(expected);
    }

}
