package com.magento1.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    WebDriver driver;

    public WebDriver open(String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("gecko")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
            driver=new FirefoxDriver();

        }
        else
        {
            System.out.println("Browser unknown!");
        }
        return driver;
    }
}
