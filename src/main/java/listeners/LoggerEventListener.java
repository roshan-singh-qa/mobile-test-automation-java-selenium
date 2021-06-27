package listeners;

import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class LoggerEventListener implements AppiumWebDriverEventListener {
    public final static Logger LOG = LogManager.getLogger(LoggerEventListener.class);


    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
        LOG.debug("Changing value of: " + webElement);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
        LOG.debug("changed value of " + webElement);
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        LOG.debug("Accepting Alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        LOG.debug("Accepted Alert");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        LOG.debug("dismissed alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        LOG.debug("dismissing alert");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        LOG.debug("navigating to " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        LOG.debug("navigated to " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        LOG.debug("navigating back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        LOG.debug("navigated back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        LOG.debug("navigating forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        LOG.debug("navigated forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        LOG.debug("Refreshing...");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        LOG.debug("Refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        LOG.debug("Looking for element: " + webElement);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        LOG.debug("Found element " + webElement);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        LOG.debug("Clicking on element: " + element);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        LOG.debug("Element: " + webElement + " has been clicked");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOG.debug("Changing value to: " + Arrays.toString(charSequences) + " in element: " + webElement);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOG.debug("Changed value to: " + Arrays.toString(charSequences) + " in element: " + webElement);
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        LOG.debug("Executing Script : " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        LOG.debug("Executed Script : " + s);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver webDriver) {
        LOG.debug("Switching to window: " + windowName);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver webDriver) {
        LOG.debug("Switched to window: " + windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        LOG.debug("");
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        LOG.debug("");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        LOG.debug("");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        LOG.debug("Getting text from element: " + webElement);
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        LOG.debug("Get text from element: " + webElement);
    }
}
