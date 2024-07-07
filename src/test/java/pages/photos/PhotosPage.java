package pages.photos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class PhotosPage extends BasePage {

    private By dataSelector = By.cssSelector("pre");

    public PhotosPage(WebDriver driver) {
        super(driver);
    }

    public JsonArray getPhotosData() {
        List<WebElement> dataElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dataSelector));
        String jsonData = dataElements.get(0).getText();
        Gson gson = new Gson();
        return gson.fromJson(jsonData, JsonArray.class);
    }

    public JsonObject findPhotoById(JsonArray jsonArray, int id) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject obj = jsonArray.get(i).getAsJsonObject();
            if (obj.get("id").getAsInt() == id) {
                return obj;
            }
        }
        return null;
    }
}
