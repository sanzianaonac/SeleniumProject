package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;

    private WebDriverManager() {
        // private constructor to prevent instantiation
    }

    // thread safe method for creating or getting a single web driver instance
    public static synchronized WebDriver getDriverInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
