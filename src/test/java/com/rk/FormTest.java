package com.rk;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends TestBase {
    @Test
    void form() {
        pages.homePage().wait.forElementToBeVisible(pages.homePage().homeTabBar);
        pages.homePage().formTabBar.click();
        pages.formPage().formScreen.click();
        pages.formPage().scrollIntoView("Active");
        Assert.assertTrue(pages.formPage().activeButton.isDisplayed());
    }
}
