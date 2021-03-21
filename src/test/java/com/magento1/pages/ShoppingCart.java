package com.magento1.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {
    WebDriver driver;
    WebDriverWait wait;

    public ShoppingCart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By title = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span ");
    By deleteProduct = By.xpath(" //*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[3]");
    By quantityOfProduct = By.xpath("//*[@class=\"field qty\"]/div/label/input");
    By updateCart = By.xpath("//*[@id=\"form-validate\"]/div[2]/button[2]/span");
    By proceedCheckout = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button");


    public String ShoppingCartTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public void clickDeleteProduct(int i) {

        Actions actions = new Actions(driver);
        WebElement proceedC1 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(deleteProduct)).get(i);
        actions.moveToElement(proceedC1).click().perform();
    }

    public void enterQuantityofProduct(int i, String number) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(quantityOfProduct)).get(i).sendKeys(Keys.chord(Keys.CONTROL, "a"), number);
    }

    public void clickUpdateCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateCart)).click();
    }

    public void clickProceedToCheckout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", wait.until(ExpectedConditions.visibilityOfElementLocated(proceedCheckout)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedCheckout)).click();

    }
}
