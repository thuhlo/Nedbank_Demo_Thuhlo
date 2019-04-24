package com.expleo.qe.PageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://demo.nopcommerce.com/")
public class NavigationObject extends PageObject
{
    //@FindBy(how = How.CLASS_NAME, using = "ico-register")
    @FindBy(how =How.XPATH, using = "//a[@href='/register']")WebElement lnkRegister;
    //private

    @FindBy(how = How.XPATH, using = "/html//div[@class='master-wrapper-page']" +
            "/div[@class='header']//div[@class='header-links']/ul//a[@href='/login']")
    private WebElement lnkLogOrOut;


    @FindBy(how = How.CLASS_NAME, using = "ico-wishlist")
    private WebElement lnkWishList;


    //@FindBy(how = How.CLASS_NAME, using = "ico-cart")

    //topcartlink
     //"//li[@id='topcartlink']/a[@href='/cart']"
    @FindBy(how = How.XPATH, using ="//li[@id='topcartlink']/a[@href='/cart']")
    private WebElement lnkCart;





    @FindBy(how = How.CLASS_NAME, using = "customerCurrency")
    private WebElement drpCurrency;
    @FindBy(how = How.ID, using = "small-searchterms")
    private WebElement txtSearchStore;
    @FindBy(how = How.CLASS_NAME, using = "button-1 search-box-button")
    private WebElement btnSearchStore;
    @FindBy(how = How.CSS, using = "body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > li:nth-child(1) > a")
    private WebElement navComputer;
    @FindBy(how = How.CSS, using = "body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > li:nth-child(2) > a")
    private WebElement navElectronics;
    @FindBy(how = How.CSS, using = "body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > li:nth-child(3) > a")
    private WebElement navApparel;
    @FindBy(how = How.CSS, using = "body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > li:nth-child(4) > a")
    private WebElement navDigitalDownloads;
    @FindBy(how = How.CSS, using = "body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > li:nth-child(5) > a")
    private WebElement navBooks;
    @FindBy(how = How.CSS, using = "body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > li:nth-child(6) > a")
    private WebElement navJewelry;
    @FindBy(how = How.CSS, using = "body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > li:nth-child(7) > a")
    private WebElement navGidtCards;

    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/h2/a")
    private WebElement buildYourOwnComputer;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong")
    private WebElement lblCartFinalprice;


    public String getCartTotalPrice()
    {
        System.out.println("Final checkout price :: " + lblCartFinalprice.getText());
        return lblCartFinalprice.getText();
    }


    //public NavigationObject(WebDriver objDriver)
   // {
      //  PageFactory.initElements(objDriver,this);
   // }

    public void openBrowser()
    {
        open();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public void buildYourComputer()
    {
        buildYourOwnComputer.click();
    }

   public void subComputerDesktop(WebDriver objDriver)
   {
       Actions action = new Actions(objDriver);
       WebElement desktopMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > " +
               "div.header-menu > ul:nth-child(1) > li:nth-child(1) > a"));
       action.moveToElement(desktopMenu).build().perform();

       //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       WebElement subMenuclick = objDriver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a"));
       subMenuclick.click();

    }

    public void subComputerNotebooks(WebDriver objDriver)
    {
        Actions action = new Actions(objDriver);
        WebElement desktopMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > " +
                "div.header-menu > ul:nth-child(1) > li:nth-child(1) > a"));
        action.moveToElement(desktopMenu).build().perform();


        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a"));
        subMenuclick.click();

    }

    public void subComputerSoftware(WebDriver objDriver)
    {

        JavascriptExecutor js = (JavascriptExecutor) objDriver;
        js.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(objDriver);
        WebElement desktopMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > " +
                "div.header-menu > ul:nth-child(1) > li:nth-child(1) > a"));
        action.moveToElement(desktopMenu).build().perform();

        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu >" +
                " ul:nth-child(1) > li:nth-child(1) > ul > li:nth-child(3) > a"));
        subMenuclick.click();

    }




    public void subElectronicsCamereANDPhoto(WebDriver objDriver)
    {
        Actions action = new Actions(objDriver);
        WebElement electronicsMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > " +
                "div.header-menu > ul:nth-child(1) > li:nth-child(2) > a"));
        action.moveToElement(electronicsMenu).build().perform();

        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu >" +
                " ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(1) > a"));
        subMenuclick.click();
    }


    public void subElectronicsCellPhones(WebDriver objDriver)
    {
        Actions action = new Actions(objDriver);
        WebElement electronicsMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > " +
                "div.header-menu > ul:nth-child(1) > li:nth-child(2) > a"));
        action.moveToElement(electronicsMenu).build().perform();

        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu >" +
                " ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(2) > a"));
        subMenuclick.click();
    }

    public void subElectronicOther(WebDriver objDriver)
    {
        Actions action = new Actions(objDriver);
        WebElement electronicsMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > " +
                "div.header-menu > ul:nth-child(1) > li:nth-child(2) > a"));
        action.moveToElement(electronicsMenu).build().perform();

        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu >" +
                " ul:nth-child(1) > li:nth-child(2) > ul > li:nth-child(3) > a"));
        subMenuclick.click();
    }


    public void subApparelShoes(WebDriver objDriver)
    {
        Actions action = new Actions(objDriver);
        WebElement apparelShoesMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > " +
                "ul:nth-child(1) > li:nth-child(3) > a"));
        action.moveToElement(apparelShoesMenu).build().perform();

        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul:nth-child(1)" +
                " > li:nth-child(3) > ul > li:nth-child(1) > a"));
        subMenuclick.click();
    }

    public void subApparelClothing(WebDriver objDriver)
    {
        Actions action = new Actions(objDriver);
        WebElement apparelClothingMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > " +
                "ul:nth-child(1) > li:nth-child(3) > a"));
        action.moveToElement(apparelClothingMenu).build().perform();

        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.cssSelector(" body > div.master-wrapper-page > div.header-menu > " +
                "ul:nth-child(1) > li:nth-child(3) > ul > li:nth-child(2) > a"));
        subMenuclick.click();
    }

    public void subApparelAccesories(WebDriver objDriver)
    {
        Actions action = new Actions(objDriver);
        WebElement apparelClothingMenu = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > " +
                "ul:nth-child(1) > li:nth-child(3) > a"));
        action.moveToElement(apparelClothingMenu).build().perform();

        //objDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement subMenuclick = objDriver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul:nth-child(1) > " +
                "li:nth-child(3) > ul > li:nth-child(3) > a"));
        subMenuclick.click();
    }


    public void linkRegister()

    {
        lnkRegister.click();
    }

    public void linkLogInOrOut()
    {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        lnkLogOrOut.click();
    }

    public String validateLogin() throws InterruptedException
    {
        WebElement link = getDriver().findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        return link.getText();
    }

    public void linkWishList()
    {
        lnkWishList.click();
    }

    public void linkWishListHover()
    {
        //Get code to hover
    }


    public void linkCart()
    {
        lnkCart.click();
    }

    public void linkCartHover()
    {
        //Get code to hover
    }

    public void drpCurrency()
    {
        Select dropCurrency = new Select(drpCurrency);

        if(drpCurrency.getText().equalsIgnoreCase("US Dollar"))
        {
            dropCurrency.selectByVisibleText("Euro");
        }
        else if(drpCurrency.getText().equalsIgnoreCase("Euro"))
        {
            dropCurrency.selectByVisibleText("US Dollar");
        }
    }

    public void txtSearchStore(String searchStore)
    {
        txtSearchStore.clear();
        txtSearchStore.sendKeys(searchStore);
    }

    public void btnSearchClick()
    {
        btnSearchStore.click();
    }

    public void navComputerMeth()
    {
        navComputer.click();
    }

    public void navElectronicsMeth()
    {
        navElectronics.click();
    }

    public void navApparelMeth()
    {
        navApparel.click();
    }

    public void navDigitalDownloadsMeth()
    {
        navDigitalDownloads.click();
    }

    public void navBooksMeth()
    {
        navBooks.click();
    }

    public void navJewelryMeth()
    {
        navJewelry.click();
    }

    public void navGiftCardsMeth()
    {
        navGidtCards.click();
    }


    public void pageScrollUp()
    {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,-250)", "");
    }

    public void pageScrollDown()
    {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,1000)");
    }
    



}
