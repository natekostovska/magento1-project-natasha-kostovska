package com.magento1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shipping {
    WebDriver driver;
    WebDriverWait wait;

    public Shipping(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By company = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[3]/div/input");
    By streets = By.xpath("//*[@id=\"shipping-new-address-form\"]/fieldset/div/div/div/input"); //0-2 za povejke adresi (max3)
    By city = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[4]/div/input");
    By country = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[8]/div/select");
    By stateProvinceUS = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[5]/div/select");
    By stateProvince = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[6]/div/input");
    By zipPostalCode = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[7]/div/input");
    By phone = By.xpath("//*[@id=\"shipping-new-address-form\"]/div[9]/div/input");
    By next = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span");

    public void enterCompany(String c) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(company)).sendKeys(c);
    }

    public void enterStreet(int i, String street) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(streets)).get(i).sendKeys(street);
    }

    public void enterCity(String grad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(city)).sendKeys(grad);
    }

    public void selectCountryProvince(String valueCountry, String province) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(country)));
        select.selectByVisibleText(valueCountry);
        if (valueCountry.equals("United States")) {
            Select select1 = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(stateProvinceUS)));
            select1.selectByValue(province);
            System.out.println("For US you have to enter value of province, value= range from 1 to 65");
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(stateProvince)).sendKeys(province);
        }
    }

    public void enterZipCode(String code) {
        if (code.length() == 4) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(zipPostalCode)).sendKeys(code);
        } else {
            System.out.println("Zip code must have 4 digits");
        }
    }

    public void enterPhone(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phone)).sendKeys(number);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(next)).click();
    }
}
