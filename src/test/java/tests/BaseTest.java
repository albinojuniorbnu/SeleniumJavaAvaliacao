package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configure o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\drivers\\chromedriver.exe");

        // Configurações opcionais para o Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Inicializar o WebDriver
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Open URL: {url}")
    protected void openUrl(String url) {
        driver.get(url);
    }
}
