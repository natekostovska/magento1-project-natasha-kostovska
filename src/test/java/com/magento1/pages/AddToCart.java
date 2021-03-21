package com.magento1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {
    WebDriver driver;
    WebDriverWait wait;

    public AddToCart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By add = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li/div/div/div/div/div/form/button");
    By menu = By.xpath("//*[@id=\"ui-id-2\"]/li");
    By cart = By.xpath("//*[@class='page-wrapper']/header/div[2]/div[1]/a");
    By viewEditCart = By.xpath("//*[@class='actions']/div/a/span");

    public void chooseCategory(int i) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menu)).get(i).click();
    }

    public void addCart(int indeks) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(add)).get(indeks));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(add)).get(indeks).click();
    }

    public void clickCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", wait.until(ExpectedConditions.visibilityOfElementLocated(cart)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cart)).click();
    }

    public void clickViewAndEditCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", wait.until(ExpectedConditions.visibilityOfElementLocated(viewEditCart)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewEditCart)).click();
    }


}
