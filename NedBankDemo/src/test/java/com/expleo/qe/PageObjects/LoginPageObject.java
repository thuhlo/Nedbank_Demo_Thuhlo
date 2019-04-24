package com.expleo.qe.PageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;


@DefaultUrl("https://demo.nopcommerce.com/")
public class LoginPageObject extends PageObject
{

    private WebElement Email;
    private WebElement Password;
    private WebElement RememberMe;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[3]/span/a")
    private WebElement linkForgotPassword;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
    private WebElement btnLogIn;



    public void openBrowser()
    {
        open();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }


    public void enterEmailAddress(String emailAddress)
    {
        Email.clear();
        Email.sendKeys(emailAddress);
    }

    public void enterPassword(String password)
    {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickRemmemberMe()
    {
        RememberMe.clear();
        RememberMe.click();
    }

    public void forgotPassword()
    {
        linkForgotPassword.click();
    }

    public void clickLogIn()
    {
        btnLogIn.click();
    }

    public String assertLogInPage(String expected)
    {
        try
        {
            assertThat("Should be on log-in page", true, is(equalTo(getDriver().getTitle().contains(expected))));
        }
        catch (AssertionError e)
        {
           expected += " " +e.getMessage();
        }
        return expected;
    }





}
