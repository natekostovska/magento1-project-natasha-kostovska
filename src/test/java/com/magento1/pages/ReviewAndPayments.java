package com.magento1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewAndPayments {
    WebDriver driver;
    WebDriverWait wait;

    public ReviewAndPayments(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By orderDetails = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[2]/div/div[2]");
    By placeOrder = By.xpath("//*[@class=\"payment-method-content\"]/div[4]/div/button/span");
    By confirmOrder = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    By receipt = By.xpath("//*[@id=\"maincontent\"]/div[1]/a");

    public String getInformations() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderDetails)).getText();
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder)).click();
    }

    public String orderSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder)).getText();
    }

    public void clickPrintReceipt() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(receipt)).click();
    }
}
