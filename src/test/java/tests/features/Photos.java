package tests.features;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import pages.guide.GuidePage;
import pages.photos.PhotosPage;
import tests.BaseTest;

public class Photos extends BaseTest {

    @Test
    @Description("Test to verify the photo with id 6")
    public void testPhotoWithId6() {
        openUrl("https://jsonplaceholder.typicode.com/guide/");

        GuidePage guidePage = new GuidePage(driver);
        PhotosPage photosPage = new PhotosPage(driver);

        navigateToPhotosPage(guidePage);
        JsonArray photosData = photosPage.getPhotosData();
        JsonObject photoWithId6 = photosPage.findPhotoById(photosData, 6);

        Assertions.assertNotNull(photoWithId6, "Objeto com id = 6 não encontrado.");
        System.out.println("Objeto com id = 6 encontrado:");
        System.out.println(photoWithId6.toString());
    }

    @Step("Navigate to Photos Page")
    private void navigateToPhotosPage(GuidePage guidePage) {
        guidePage.navigateToPhotosPage();
    }
}
