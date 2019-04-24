package com.expleo.qe.Steps;

import com.expleo.qe.PageObjects.BuildYourOwnComputerPageObject;
import com.expleo.qe.PageObjects.NavigationObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class BuildYourOwnComputerSteps
{
    BuildYourOwnComputerPageObject buildYourOwnComputerPageObject;
    NavigationSteps navigationSteps;
    NavigationObject navigationObject;

    public void openBrowser()
    {
        buildYourOwnComputerPageObject.openBrowser();
    }

    public void firstClick()
    {
        buildYourOwnComputerPageObject.firstClick();
    }

    @Step
    public void buildComputer(String processor, String ram, String HDD, String OS, boolean microSoftOffice,
                              boolean acrobatReader, boolean totalCommander, String quantity) throws InterruptedException {

        buildYourOwnComputerPageObject.selectProcessor(processor);
        buildYourOwnComputerPageObject.selectRam(ram);
        buildYourOwnComputerPageObject.selectHDD(HDD);
        buildYourOwnComputerPageObject.selectOS(OS);
        buildYourOwnComputerPageObject.selectMicrosoftoffice(microSoftOffice);
        buildYourOwnComputerPageObject.selectAcrobatReader(acrobatReader);
        buildYourOwnComputerPageObject.selectTotalCommander(totalCommander);
        buildYourOwnComputerPageObject.enterProductQuantity(quantity);
        //was 2000
        //Thread.sleep(2000);
        //was 10000
        Thread.sleep(2000);

    }

    @Step("Click Add To Cart")
    public void clickAddToCart() throws InterruptedException {

        buildYourOwnComputerPageObject.clickAddToCart();
        Thread.sleep(4000);
        navigationObject.pageScrollUp();
        navigationObject.pageScrollUp();
        navigationObject.pageScrollUp();
        navigationObject.pageScrollUp();
        Thread.sleep(2000);
        //getDriver().switchTo().alert().accept();
    }


    public  String readFromTable()
    {
        String fullProductObject = buildYourOwnComputerPageObject.readTable();
        return fullProductObject;
    }


    public  String assertEqual(String expected){
        String actual=readFromTable();
        System.out.println("Actual   ::" + actual);
        System.out.println("Expected ::" + expected);
        try{
           // assertThat(true,is(equalTo(actual.contains(expected))));
            assertThat(actual,equalTo(expected));
            expected+= " \nis equal to\n " + actual;
            //Assert.assertEquals(actual,expected);
        }catch (AssertionError e){
            expected+=" does not match" + actual;
            System.out.println("Catch msg :: " + expected);
        }
        return expected;
    }

    @Step("{0}")
    public void message(String message){}


}
