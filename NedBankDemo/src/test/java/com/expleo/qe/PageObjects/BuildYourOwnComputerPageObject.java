package com.expleo.qe.PageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://demo.nopcommerce.com/")
public class BuildYourOwnComputerPageObject extends PageObject
{
    @FindBy(how = How.ID, using = "product_attribute_1")
    private WebElement drpProcessor;

    @FindBy(how = How.ID, using = "product_attribute_2")
    private WebElement drpRam;

    @FindBy(how = How.ID, using = "product_attribute_3_6")
    private WebElement rdo320GBHDD;

    @FindBy(how = How.ID, using = "product_attribute_3_7")
    private WebElement rdo400GBHDD;

    @FindBy(how = How.ID, using = "product_attribute_4_8")
    private WebElement rdoOSVistaHome;

    @FindBy(how = How.ID, using = "product_attribute_4_9")
    private WebElement rdoOSVistaPremium;

    @FindBy(how = How.ID, using = "product_attribute_5_10")
    private WebElement chkMicrosoftOffice;

    @FindBy(how = How.ID, using = "product_attribute_5_11")
    private WebElement chkAcrobatReader;

    @FindBy(how = How.ID, using = "product_attribute_5_12")
    private WebElement chkTotalCommander;

    @FindBy(how = How.ID, using = "addtocart_1_EnteredQuantity")
    private WebElement txtProductQuantity;

    @FindBy(how = How.ID, using = "add-to-cart-button-1")
    private WebElement btnAddToCart;


    public void firstClick()
    {
        chkMicrosoftOffice.click();
    }

    public void clickAddToCart()
    {
        btnAddToCart.click();
    }

    public void enterProductQuantity(String quantity)
    {
        txtProductQuantity.clear();
        txtProductQuantity.sendKeys(quantity);
    }


    public void openBrowser()
    {
        open();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public void selectProcessor(String processor)
    {
        Select drpProcessor1 = new Select(drpProcessor);
        drpProcessor1.selectByVisibleText(processor);
    }

    public void selectTotalCommander(boolean addItem)
    {
        if(addItem) {
            chkTotalCommander.click();
        }
    }

    public void selectAcrobatReader(boolean addItem)
    {
        if(addItem) {
            chkAcrobatReader.click();
        }
    }

    public void selectMicrosoftoffice(boolean addItem)
    {
        if(addItem) {
            chkMicrosoftOffice.click();
        }
    }

    public void selectOSVistaPremium()
    {
        rdoOSVistaPremium.click();
    }

    public void selectOSVistaHome()
    {
        rdoOSVistaHome.click();
    }

    public void select400GBHDD()
    {
        rdo400GBHDD.click();
    }

    public void select320GBHDD()
    {
        rdo320GBHDD.click();
    }

    public void selectOS(String os)
    {

        if(os.contains("Home"))
        {
            selectOSVistaHome();
        }
        else if(os.contains("Premium"))
        {
            selectOSVistaPremium();
        }
    }

    public void selectRam(String ram)
    {
        Select drpRam1 = new Select(drpRam);
        drpRam1.selectByVisibleText(ram);
    }

    public void selectHDD(String hdd)
    {
        if(hdd.contains("320 GB"))
        {
            select320GBHDD();
        }
        else if(hdd.contains("400 GB"))
        {
            select400GBHDD();
        }
    }



    public String readTable()
    {

        WebElement baseTable = getDriver().findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table"));
        WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[4]"));
        String rowtext = tableRow.getText();
        return rowtext;
    }



}
