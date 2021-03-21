package com.magento1.tests;

import com.magento1.framework.Browser;
import com.magento1.pages.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public String chromeBrowser = "chrome";
    //public String firefoxBrowser="gecko";
    public static final String URL = "http://138.201.197.35:81/magento1/";

    Browser browser = new Browser();
    public CreateAnAccount createAnAccount;
    public AddToCart addToCart;
    public ShoppingCart shoppingCart;
    public Shipping shipping;
    public ReviewAndPayments reviewAndPayments;

    @BeforeMethod
    public void set_up() {
       driver = browser.open(this.chromeBrowser);
       // driver=browser.open(this.firefoxBrowser);

        Dimension dimension = new Dimension(200, 300);
        driver.manage().window().setSize(dimension);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);

        createAnAccount=new CreateAnAccount(driver,wait);
        addToCart=new AddToCart(driver,wait);
        shoppingCart=new ShoppingCart(driver,wait);
        shipping=new Shipping(driver,wait);
        reviewAndPayments=new ReviewAndPayments(driver,wait);

    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }


    @AfterMethod
    public void tear_down() {
        driver.quit();
    }
}
