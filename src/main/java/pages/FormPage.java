package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='button-Active']")
    public WebElement activeButton;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='Forms-screen']")
    public WebElement formScreen;

    public FormPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }
}