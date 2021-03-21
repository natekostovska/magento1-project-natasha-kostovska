package com.magento1.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Magento1Tests extends BaseTest {

    // samo prviot test kje pomine, ostanatite imaat greshka vo password i ispechatuva shto treba da se smeni

    @DataProvider(name = "TestMagento1")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Natasha", "Kostovska", "hotmail.com", "123456789Aa!", "123456789Aa!", "SEDC", "Tashko Karadza", "Skopje", "Macedonia", "/", "1000", "123456789"},
                /*{"Emilija", "Liljanov", "outlook.com", "2314567A", "2314567A","E-bay","Street2","Bitola","Macedonia","/", "1000", "123456789"},
                {"Petar", "Petrovski", "gmail.com", "1236549872a", "1236549872a","Nike","Street3","Negotino","Macedonia","/", "1000", "123456789"},
                {"Marija ", "Janevska", "yahoo.com", "6549873210!", "654987321!","Apple","Street4","Veles","Macedonia","/", "1000", "123456789"},
                {"Elena", " Petrovska", "mail.com", "12456@At", "12456@A","EVN","Street5","Kumanovo","Macedonia","/", "1000", "123456789"},*/

        };
    }

    @Test(dataProvider = "TestMagento1")
    public void test(String name, String surname, String domain, String password, String confirmPassword, String company, String street,
                     String city, String country, String province, String zipCode, String phone) {
        driver.navigate().to(URL);
        createAnAccount.clickCreateAnAccount();
        createAnAccount.getTitleCreateNewCustomerAccount();
        createAnAccount.getTitles(0);
        createAnAccount.getTitles(1);
        Assert.assertEquals(createAnAccount.getTitleCreateNewCustomerAccount(), "Create New Customer Account");
        Assert.assertEquals(createAnAccount.getTitles(0), "Personal Information");
        Assert.assertEquals(createAnAccount.getTitles(1), "Sign-in Information");
        createAnAccount.enterFirstname(name);
        createAnAccount.enterLastname(surname);
        createAnAccount.clickSignUpFN();
        sleep(2000);
        createAnAccount.enterEmail(domain);
        createAnAccount.enterPassword(password, confirmPassword);
        createAnAccount.clickCreateButton();
        sleep(3000);

        Assert.assertEquals(createAnAccount.registrationMessage(), "Thank you for registering with Main Website Store.");
        //Assert.assertEquals(createAnAccount.registrationFullNameMailSubscription(),name+" "+surname+"\n"+createAnAccount.getSaltString()+"@"+domain);
        Assert.assertEquals(createAnAccount.Newsletters(), "You are subscribed to \"General Subscription\".");
        sleep(3000);

        // choose category for ex: Game Boards, Movies etc from 1-25
        addToCart.chooseCategory(5);
        //Add Products
        addToCart.addCart(9);
        sleep(2000);
        addToCart.addCart(4);
        sleep(2000);
        addToCart.addCart(10);
        sleep(10000);
        addToCart.clickCart();
        sleep(3000);
        addToCart.clickViewAndEditCart();

        //Add and Remove Products from Cart
        shoppingCart.ShoppingCartTitle();
        Assert.assertEquals(shoppingCart.ShoppingCartTitle(), "Shopping Cart");
        sleep(3000);
        shoppingCart.clickDeleteProduct(1);
        sleep(5000);
        shoppingCart.enterQuantityofProduct(0, "2");
        sleep(8000);
        shoppingCart.clickUpdateCart();
        sleep(8000);
        shoppingCart.clickProceedToCheckout();
        sleep(3000);


        //Shipping
        shipping.enterCompany(company);
        shipping.enterStreet(0, street);
        shipping.enterCity(city);
        sleep(3000);
        shipping.selectCountryProvince(country, province);
        shipping.enterZipCode(zipCode);
        shipping.enterPhone(phone);
        shipping.clickNext();
        sleep(5000);


        //Review and Payment
        Assert.assertEquals(reviewAndPayments.getInformations(), name + " " + surname + "\n" + street + "\n" + city + ", " + province +
                " " + zipCode + "\n" + country + "\n" + phone + "\n" + "Edit");
        sleep(3000);
        reviewAndPayments.clickPlaceOrder();
        sleep(3000);
        Assert.assertEquals(reviewAndPayments.orderSuccessful(), "Checkout");
        sleep(8000);
        reviewAndPayments.clickPrintReceipt();
        sleep(8000);

    }

}

