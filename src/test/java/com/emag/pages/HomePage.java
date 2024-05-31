package com.emag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class HomePage extends BasePage {
    private By searchBox = By.xpath("//input[@id='searchboxTrigger']");

    public HomePage(WebDriver driver, long timeout) {
        super(driver, timeout);
    }

    public void searchFor(String query) {
        try {
            WebElement searchBoxElement = driver.findElement(searchBox);
            searchBoxElement.sendKeys(query);
            searchBoxElement.submit();
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
       return;
    }
}
