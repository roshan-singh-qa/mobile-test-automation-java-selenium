package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipePage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Carousel']")
    public WebElement carousel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SUPPORT VIDEOS']")
    public WebElement youtubeCarousel;

    public SwipePage(AppiumDriver driver) {
        super(driver);
    }
}
