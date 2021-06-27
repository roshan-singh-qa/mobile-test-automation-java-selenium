package base;

import commons.ExplicitWait;
import commons.GenericHelper;
import commons.JavaScriptHelper;
import configurations.sections.Timeout;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends GenericHelper{

    protected AppiumDriver driver;
    public ExplicitWait wait;
    public JavaScriptHelper js;
    public GenericHelper gh;

    public BasePage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new ExplicitWait(driver);
        js = new JavaScriptHelper(driver);
        gh = new GenericHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void click(WebElement webElement) {
        click(webElement, Timeout.explicit);
    }

    public void click(WebElement webElement, int timeOutInSeconds) {
        wait.forElementToBeClickable(webElement, timeOutInSeconds, Timeout.poolingInterval);
        js.clickElement(webElement);
    }

    public void sendKeys(WebElement webElement, String value, int timeOutInSeconds) {
        click(webElement, timeOutInSeconds);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void sendKeys(WebElement webElement, String value) {
        sendKeys(webElement, value, Timeout.explicit);
    }

    public void executeJavascript(String string) {
        js.executeScript(string);
    }

    public void executeJavascript(String string, WebElement element) {
        js.executeScript(string, element);
    }
}
