package com.emag.tests;

import com.emag.pages.CartPage;
import com.emag.pages.HomePage;
import com.emag.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverManager;

public class BaseTest {
    protected long timeout = 10; // no of seconds to wait before timing out
    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected CartPage cartPage;

    protected static final Logger logger = LoggerFactory.getLogger(EmagTest.class);

    @BeforeMethod
    public void setUp() {
        WebDriver driver = WebDriverManager.getDriverInstance();
        driver.get("https://www.emag.ro/");
        homePage = new HomePage(driver, timeout);
        searchResultsPage = new SearchResultsPage(driver, timeout);
        cartPage = new CartPage(driver, timeout);
        logger.info("Setup completed, navigated to eMAG homepage.");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager.quitDriver();
        logger.info("Driver quit and resources cleaned up.");

    }
}
