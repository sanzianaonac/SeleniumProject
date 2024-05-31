package com.hotwire.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class FlightsPage extends BasePage {
    private By leavingFromButtonSelector = By.xpath("//div[@data-testid='location-field-leg1-origin-container']");
    private By leavingFromSuggestionListSelector = By.xpath("//ul[@class='uitk-action-list no-bullet']/li");

    public FlightsPage(WebDriver driver, long timeout) {
        super(driver, timeout);
    }

    public boolean setLeavingFrom(String source) {
        try {
            WebElement leaveFromButton = driver.findElement(leavingFromButtonSelector);
            leaveFromButton.click();

            WebElement leaveInputField = driver.switchTo().activeElement();
            leaveInputField.sendKeys("LAX");


            //sleep(5);
            //wait.until(ExpectedConditions.presenceOfElementLocated(leavingFromSuggestionListSelector));

//            List<WebElement> suggestedItems = driver.findElements(leavingFromSuggestionListSelector);
//
//            for (WebElement suggestedItem : suggestedItems) {
//                System.out.println("Item " + suggestedItem.getText());
//            }

            System.out.println("flightTab.getText()");
        }
        catch(NoSuchElementException e) {
            return false;
        }
        return true;
    }

}
