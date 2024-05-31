package com.emag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends BasePage {

    // Updated XPath to select the search result items
    private By addToCartButtonLocator = By.xpath("//form/button[@type='submit']");
    private By itemNameLocator = By.xpath("//h2[@class='card-v2-title-wrapper']/a");

    public SearchResultsPage(WebDriver driver, long timeout) {
        super(driver, timeout);
    }

    public boolean addItemToCart(int index) {
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButtonLocator));
        List<WebElement> searchResults = driver.findElements(addToCartButtonLocator);

        // Log the number of search results found
        System.out.println("Number of search results found: " + searchResults.size());

        // Ensure the list has enough elements
        if (searchResults.size() > index) {
            WebElement addToCartButton = searchResults.get(index - 1);
            addToCartButton.submit();

            System.out.println("Clicking 'Add to Cart' button for item at index: " + index);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is greater than no of items " + searchResults.size());
        }

        return true;
    }

    public String getItemName(int index) {
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButtonLocator));
        List<WebElement> searchResults = driver.findElements(itemNameLocator);

        // Log the number of search results found
        System.out.println("Number of search results found: " + searchResults.size());

        // Ensure the list has enough elements
        if (searchResults.size() > index) {
            WebElement item = searchResults.get(index - 1);
            return item.getText();
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is greater than no of items " + searchResults.size());
        }
    }
}
