package com.hotwire.tests;
import com.hotwire.pages.FlightsPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverManager;

public class BaseTest {
    protected long timeout = 10; // no of seconds to wait before timing out
    protected FlightsPage flightsPage;

    protected static final Logger logger = LoggerFactory.getLogger(HotwireTest.class);

    @BeforeMethod
    public void setUp() {
        WebDriver driver = WebDriverManager.getDriverInstance();
        driver.get("https://www.hotwire.com/flights/");
        this.flightsPage = new FlightsPage(driver, timeout);
        logger.info("Setup completed, navigated to hotwire homepage.");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager.quitDriver();
        logger.info("Driver quit and resources cleaned up.");

    }
}
