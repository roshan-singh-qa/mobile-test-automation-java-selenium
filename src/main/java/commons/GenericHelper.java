package commons;

import configurations.sections.DriverDetails;
import configurations.sections.Timeout;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

public class GenericHelper {

    public static final Logger log = LogManager.getLogger(GenericHelper.class);

    private final WebDriver driver;

    public GenericHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        log.info(locator);
        if (IsElementPresentQuick(locator)) {
            return driver.findElement(locator);
        }
        try {
            throw new NoSuchElementException("Element Not Found : " + locator);
        } catch (RuntimeException e) {
            log.error(e);
            throw e;
        }
    }

    public boolean IsElementPresentQuick(By locator) {
        boolean flag = driver.findElements(locator).size() >= 1;
        log.info(flag);
        return flag;
    }

    public void hideKeyboard() {
        ((AppiumDriver) driver).hideKeyboard();
    }

    public void back() {
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    /**
     * method to tap on the screen on provided coordinates
     *
     * @param xPosition x coordinate to be tapped
     * @param yPosition y coordinate to be tapped
     */
    public void tap(double xPosition, double yPosition) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("startX", xPosition);
        tapObject.put("startY", yPosition);
        js.executeScript("mobile: tap", tapObject);
    }

    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (NoAlertPresentException e) {
            log.error("no alert present");
            throw e;
        }
    }

    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Timeout.explicit);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            throw e;
        }
    }

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Timeout.explicit);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Timeout.explicit);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    /**
     * method to get network settings
     */
    public void getNetworkConnection() {
        System.out.println(((AndroidDriver) driver).getConnection());
    }


    /**
     * method to set network settings
     *
     * @param airplaneMode pass true to activate airplane mode else false
     * @param wifi         pass true to activate wifi mode else false
     * @param data         pass true to activate data mode else false
     */
    public void setNetworkConnection(boolean airplaneMode, boolean wifi, boolean data) {

        long mode = 1L;

        if (wifi) {
            mode = 2L;
        } else if (data) {
            mode = 4L;
        }

        ConnectionState connectionState = new ConnectionState(mode);
        ((AndroidDriver) driver).setConnection(connectionState);
        System.out.println("Your current connection settings are :" + ((AndroidDriver) driver).getConnection());
    }


    /**
     * method to get all the context handles at particular screen
     */
    public void getContext() {
        ((AppiumDriver) driver).getContextHandles();
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {

        Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();

        if (contextNames.contains(context)) {
            ((AppiumDriver) driver).context(context);
            log.info("Context changed successfully");
        } else {
            log.info(context + "not found on this page");
        }

        log.info("Current context" + ((AppiumDriver) driver).getContext());
    }

    /**
     * method to open notifications on Android
     */

    public void openNotifications() {
        ((AndroidDriver) driver).openNotifications();
    }

    /**
     * method to launchApp
     */

    public void launchApp() {
        ((AppiumDriver) driver).launchApp();
    }

    public void longPress(WebElement webElement, int timeInSecond) {
        TouchAction touchAction = new TouchAction((AppiumDriver) driver);
        touchAction.longPress(
                LongPressOptions.longPressOptions().
                        withElement(ElementOption.element(webElement)).
                        withDuration(Duration.ofSeconds(timeInSecond))).release();
    }


    /**
     * method to scroll down on screen
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollDown(int swipeTimes, int durationForSwipe) {
        for (int i = 1; i <= swipeTimes; i++) {
            scrollDown(durationForSwipe);
        }
    }

    private void scrollDown(int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();
        int start = (int) (dimension.getHeight() * 0.5);
        int end = (int) (dimension.getHeight() * 0.3);
        new TouchAction((PerformsTouchActions) driver).
                press(PointOption.point(0, start)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durationForSwipe))).
                moveTo(PointOption.point(0, end)).release().perform();
    }

    public void scrollIntoView(String text) {
        if (DriverDetails.platform.equalsIgnoreCase("emulator") || DriverDetails.platform.equalsIgnoreCase("android")) {
            ((AndroidDriver) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()." +
                            "scrollable(true).instance(0)).scrollIntoView(new UiSelector()." +
                            "textContains(\"" + text + "\").instance(0))");
        } else {
            HashMap<String, Object> scrollObject = new HashMap<>();
            scrollObject.put("direction", "down");
            scrollObject.put("value", text);
            ((IOSDriver) driver).executeScript("mobile:scroll", scrollObject);
        }
    }

    /**
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void swipeLeft(int swipeTimes,int durationForSwipe) {
        for (int i = 1; i <= swipeTimes; i++) swipeLeft(durationForSwipe);
    }

    public void swipeRight(int swipeTimes, int durationForSwipe) {
        for (int i = 1; i <= swipeTimes; i++) swipeRight(durationForSwipe);
    }

    private void swipeRight(int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();
        int end_x = (int) (dimension.getWidth() * 0.5);
        int start_x = (int) (dimension.getWidth() * 0.1);
        int y = (int) (dimension.getHeight() * 0.5);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.
                press(PointOption.point(start_x, y)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durationForSwipe))).
                moveTo(PointOption.point(end_x, y)).release().perform();
    }

    private void swipeLeft(int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.getWidth() * 0.5);
        int end_x = (int) (dimension.getWidth() * 0.1);
        int y = (int) (dimension.getHeight() * 0.5);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.
                press(PointOption.point(start_x, y)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durationForSwipe))).
                moveTo(PointOption.point(end_x, y)).release().perform();
    }

}
