package com.rk;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void verifyLoginPageIsVisible() {
        pages.homePage().homeTabBar.isDisplayed();
        pages.homePage().loginTabBar.click();
    }

    @Test
    public void LoginWithValidCred() {
        pages.homePage().wait.forElementToBeVisible(pages.homePage().homeTabBar);
        pages.homePage().loginTabBar.click();
        pages.loginPage().loginTab.click();
        pages.loginPage().email.sendKeys("test@webdriver.io");
        pages.loginPage().password.sendKeys("Test1234!");
        pages.loginPage().loginButton.click();
        pages.loginPage().wait.forElementToBeVisible(pages.loginPage().successPopup);
        Assert.assertTrue(pages.loginPage().okButton.isDisplayed());
    }
}