package listeners;

import commons.JavaScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class ConsolePrinterEventListener extends AbstractWebDriverEventListener {
    private final JavaScriptHelper JS;

    public ConsolePrinterEventListener(WebDriver driver) {
        this.JS = new JavaScriptHelper(driver);
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Accepting alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("Dismissing alert");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigating to: " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Looking for element: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element " + by + " found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicking on element: " + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Element: " + element + " has been clicked");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Changing value to: " + keysToSend + " in element: " + element);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.println("Getting text from element: " + element);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Switching to window: " + windowName);
    }
}
