package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Home']")
    public WebElement homeTabBar;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Login']")
    public WebElement loginTabBar;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Forms']")
    public WebElement formTabBar;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Swipe']")
    public WebElement swipeTabBar;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }
}
