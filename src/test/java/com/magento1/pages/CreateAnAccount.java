package com.magento1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CreateAnAccount {

    WebDriver driver;
    WebDriverWait wait;

    public CreateAnAccount(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By clickCreate = By.xpath("//*[@class=\"panel header\"]/ul/li[3]/a");
    By firstname = By.id("firstname");
    By lastname = By.id("lastname");
    By newsletter = By.id("is_subscribed");
    By email = By.id("email_address");
    By password = By.id("password");
    By passConfirm = By.id("password-confirmation");
    By button = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");
    By pageTitle1 = By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
    By pageTitles = By.xpath("//*[@id=\"form-validate\"]/fieldset/legend/span"); // so indeks 0 i 1 za naslovite
    By registrationSuccess = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    By registrationCredentials = By.xpath("//*[@class='box-content']/p"); ////*[@id="maincontent"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/p
    By newsletters = By.xpath("//*[@class=\"box box-newsletter\"]/div/p");


    public void clickCreateAnAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickCreate)).click();
    }

    public String getTitleCreateNewCustomerAccount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle1)).getText();
    }

    public String getTitles(int i) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pageTitles)).get(i).getText();
    }

    public void enterFirstname(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys(name);
    }

    public void enterLastname(String surname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys(surname);
    }

    public void clickSignUpFN() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newsletter)).click();
    }

    public String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();


    }

    public void enterEmail(String domain) { //random email
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(getSaltString() + "@" + domain);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

    }

     public void enterPassword(String pass, String confirmpass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passConfirm)).sendKeys(confirmpass);

        if (pass.length() > 15 || pass.length() < 8) {
            System.out.println("Password must be less than 15 and more than 8 characters in length.");
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!pass.matches(upperCaseChars)) {
            System.out.println("Password must have at least one uppercase character");
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!pass.matches(lowerCaseChars)) {
            System.out.println("Password must have at least one lowercase character");
        }
        String numbers = "(.*[0-9].*)";
        if (!pass.matches(numbers)) {
            System.out.println("Password must have at least one number");
        }
        String specialChars = "(.*[@,#,$,%,!,^,&,*,?].*$)";
        if (!pass.matches(specialChars)) {
            System.out.println("Password must have at least one special character among @#$%!^&*?");
        }
        if (!pass.equals(confirmpass)) {
            System.out.println("Password and confirmPass are not the same");
        }


        // Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.
        //Minimum of different classes of characters in password is 3.!!!!!!!!!!!
        // Classes of characters: Lower Case, Upper Case, Digits, Special Characters.
        // if pass!=confirmpass ne mozhe ponataka
    }

    public void clickCreateButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(button)).click();
    }

    public String registrationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registrationSuccess)).getText();
    }

    public String registrationFullNameMailSubscription() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(registrationCredentials)).getText();

    }


    public String Newsletters() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newsletters)).getText();
    }

}
