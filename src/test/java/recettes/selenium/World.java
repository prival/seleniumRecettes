package recettes.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class World {


    private static WebDriver driver = null;

    public static WebDriver haveDriver() {
        if (driver ==null) {
            // Create a new instance of the Chrome driver
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("unexpectedAlertBehaviour", "accept");
            capabilities.setCapability("ignoreProtectedModeSettings", true);
            capabilities.setCapability("disable-popup-blocking", true);
            capabilities.setCapability("enablePersistentHover", true);
            capabilities.setCapability("ignoreZoomSetting", true);

            File file = new File("C:\\projets\\selenium\\chromedriver.exe");

            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
        }

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
