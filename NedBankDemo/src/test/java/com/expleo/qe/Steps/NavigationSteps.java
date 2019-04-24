package com.expleo.qe.Steps;

import com.expleo.qe.PageObjects.NavigationObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.StaleElementReferenceException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NavigationSteps
{
    NavigationObject navigationObject;

    @Step("Click on Register")
    public void clickRegister()
    {
        navigationObject.linkRegister();
    }

    @Step("Click on login or logout")
    public void clickLogInOrOut()
    {
        navigationObject.linkLogInOrOut();

    }

    @Step("Open the Browser")
    public void openBrowser()
    {
        navigationObject.openBrowser();
    }

    @Step("Navigate to Computers sub Menu Desktop")
    public void navigateToSubComputerDesktop()
    {
        navigationObject.subComputerDesktop(getDriver());
    }

    @Step("Select Build YourOwn Computer")
    public void buildYourOwnComputer()
    {
        navigationObject.buildYourComputer();
    }

    @Step("Navigate to Shopping Cart")
    public void navigateToCart()
    {
        navigationObject.linkCart();
    }

    @Step("Validate Page {0}")
    public String validateLogIn(String expected) throws InterruptedException
    {
        String recievedMessage = "";
        System.out.println("In the validate ...");
        try
        {
            assertThat("Incorrect Page ", expected, is(navigationObject.validateLogin()));
        }
        catch (AssertionError e)
        {
           recievedMessage = "Incorrect Page :" + e.getMessage();
        }
        return recievedMessage;
    }


    public String assertFinalCheckoutPrice(String expected)
    {
        try{
            navigationObject.pageScrollDown();
            System.out.println("Expected ::: " + expected);

            //assertThat("Checkout price invalid",true,is(equalTo(navigationObject.getCartTotalPrice().trim())));
            System.out.println(navigationObject.getCartTotalPrice().equalsIgnoreCase(expected));
            assertThat(navigationObject.getCartTotalPrice(),equalTo(expected));

        }
        catch (AssertionError e)
        {
            expected+=" is not equal to "+ navigationObject.getCartTotalPrice();
       }catch (StaleElementReferenceException e){
            expected+= "  Invalid Expected Price  :  "+ navigationObject.getCartTotalPrice();
       }
        return  expected;
    }

    @Step("{0}")
    public void message(String message){}

    public void scrollUp()
    {
        navigationObject.pageScrollUp();
    }


}
