package pages;

import io.appium.java_client.AppiumDriver;

public class PageObjectManager {

    private AppiumDriver driver;
    private FormPage formPage;
    private HomePage homePage;
    private Login loginPage;
    private SwipePage swipePage;

    public PageObjectManager(AppiumDriver driver) {
        this.driver = driver;
    }

    public FormPage formPage() {
        return (formPage == null) ? formPage = new FormPage(driver) : formPage;
    }

    public HomePage homePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public Login loginPage() {
        return (loginPage == null) ? loginPage = new Login(driver) : loginPage;
    }

    public SwipePage swipePage() {
        return (swipePage == null) ? swipePage = new SwipePage(driver) : swipePage;
    }
}
