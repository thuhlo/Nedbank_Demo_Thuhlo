package com.expleo.qe.PageObjects;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DefaultUrl("https://demo.nopcommerce.com/")
public class RegistrationPageobject extends PageObject
{

    @FindBy(how = How.ID, using = "gender-male")
    private WebElement rdoMale;
    @FindBy(how =How.ID, using = "gender-female")
    private WebElement rdoFemale;
    private WebElement FirstName;
    private WebElement LastName;
    ///Set to find selected option by index in the method(local)
    @FindBy(how = How.NAME, using = "DateOfBirthDay")
    private WebElement drpDay;
    @FindBy(how = How.NAME, using = "DateOfBirthMonth")
    private WebElement drpMonth;
    @FindBy(how = How.NAME, using = "DateOfBirthYear")
    private WebElement drpYear;
    ///Set to find selected option by index in the method

    private WebElement Email;
    @FindBy(how = How.ID, using = "Email-error")
    private WebElement msgEmail;
    private WebElement Company;
    private WebElement Newsletter;
    private WebElement Password;
    private WebElement ConfirmPassword;

    @FindBy(how = How.ID, using = "register-button")
    private WebElement btnRegister;
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/form/div/div[2]/div[1]")
    private WebElement lblRegSuccess;

    public String regSuccess()
    {
        return lblRegSuccess.getText().toString();
    }

    public String emailError()
    {
        String message = "null";
        try{
            message = msgEmail.getText();
        }
        catch (ElementNotFoundException e)
        {
            e.getMessage();
        }

        return message;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
    private WebElement lblRegister;

    public void openBrowser()
    {
        open();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void confirmPassword(String confirmPassword)
    {
        ConfirmPassword.clear();
        ConfirmPassword.sendKeys(confirmPassword);
    }

    public void enterPassword(String password)
    {
        Password.clear();
        Password.sendKeys(password);
    }

    public void checkNewsLetter()
    {//TODO fix to properly click when registering
        Newsletter.click();
    }

    public void enterCOmpanyName(String companyName)
    {
        Company.clear();
        Company.sendKeys(companyName);
    }

    public void enterEmail(String email)
    {
        Email.clear();
        Email.sendKeys(email);
    }

    /////////////dob//////////////////////////////////////
    public void selectDateOfBirthDay(String day)
    {
        try
        {
            Select drpDayOfBirth = new Select(drpDay);
            drpDayOfBirth.selectByVisibleText(day);
        }
        catch (NoSuchElementException e)
        {
            throw new NoSuchElementException("Invalid Data : "+e.getMessage());
        }
    }

    public void selectDatOfBirthMonth(String month)
    {
        try {
            Select drpMotnhofBirth = new Select(drpMonth);
            drpMotnhofBirth.selectByVisibleText(month);
        }
        catch (NoSuchElementException ex)
        {
            ex.getMessage();
        }

    }

    public void selectDateOfBirthYear(String year)
    {
        try
        {
            Select drpYearOfBirth = new Select(drpYear);
            drpYearOfBirth.selectByVisibleText(year);
        }
        catch (NoSuchElementException ec)
        {
            ec.getMessage();
        }

    }
    /////////////////////////dob//////////////////////////

    public void enterLastname(String lastname)
    {
        LastName.clear();
        LastName.sendKeys(lastname);
    }

    public void enterFirstname(String firstname)
    {
        FirstName.clear();
        FirstName.sendKeys(firstname);
    }

    public void selectGenderFemale()
    {
        rdoFemale.click();
    }

    public void selectGenderMale()
    {
        rdoMale.click();
    }

    public void clickRegisterButton()
    {
        btnRegister.click();
    }

    public void areWeOnTheRegistrationPage(String expected)
    {
        JOptionPane.showMessageDialog(null,lblRegister.getText().toString());
        assertThat("We should be on the Register Page ",expected, is(equalTo(lblRegister.getText())));
    }



}
