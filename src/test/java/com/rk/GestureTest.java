package com.rk;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GestureTest extends TestBase {
    @Test
    void swipe() {
        pages.homePage().wait.forElementToBeVisible(pages.homePage().homeTabBar);
        pages.homePage().swipeTabBar.click();
        pages.swipePage().swipeLeft(3, 1);
        Assert.assertTrue(pages.swipePage().youtubeCarousel.isDisplayed());
    }
}
