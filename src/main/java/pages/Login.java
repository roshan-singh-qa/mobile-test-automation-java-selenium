package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-login-container\"]")
    public WebElement loginTab;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]")
    public WebElement loginScreen;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
    public WebElement email;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
    public WebElement password;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]")
    public WebElement loginButton;

    @FindBy(id = "android:id/alertTitle")
    public WebElement successPopup;

    @FindBy(xpath = "//android.widget.Button[@text=\"OK\"]")
    public WebElement okButton;

    public Login(AppiumDriver driver) {
        super(driver);
    }
}
