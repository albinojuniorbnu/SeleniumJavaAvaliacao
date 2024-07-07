package pages.guide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class GuidePage extends BasePage {

    private By photosLink = By.linkText("/albums/1/photos");

    public GuidePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPhotosPage() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(photosLink));
        link.click();
    }
}
