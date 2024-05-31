package com.emag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends BasePage {
    private By cartItemsSelector = By.xpath("//div[@class='main-product-title-container']/a");
    private By deleteButtonSelector = By.xpath("//div[@class=\"line-footer-action-buttons\"]/button");
    private By cartEmptySelector = By.xpath("//p[@class='mrg-btm-none']");
    private By homeButtonSelector = By.xpath("//a[@class='navbar-brand']");

    public CartPage(WebDriver driver, long timeout) {
        super(driver, timeout);
    }

    public boolean isItemInCart(String itemName) {

        // when 1st loading the page we have to wait for everything to load
        wait.until(ExpectedConditions.presenceOfElementLocated(cartItemsSelector));

        try {
            List<WebElement> cartItems = driver.findElements(cartItemsSelector);

            if (cartItems.isEmpty()) {
                return false;
            }

            for (WebElement cartItem : cartItems) {
                String itemTitleStr = cartItem.getText();

                if (itemName.equals(itemTitleStr)) {
                    return true;
                }
            }
        }
        catch (NoSuchElementException e) {
            return false;
        }

        return false;
    }

    public boolean removeItemFromCart() {
        try {
            List<WebElement> buttons = driver.findElements(deleteButtonSelector);

            for (WebElement button : buttons) {
                if (button.isDisplayed() && button.isEnabled()) {
                    button.click();
                }
            }
        }
        catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }

    public boolean isCartEmpty() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cartEmptySelector));

        try {
            WebElement cartEmptyBanner = driver.findElement(cartEmptySelector);
            return cartEmptyBanner.isDisplayed();

        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public void navigateHome() {
        try {
            WebElement homeButton = driver.findElement(homeButtonSelector);
            homeButton.click();
        }
        catch (NoSuchElementException e) {
             e.printStackTrace();
        }
        return;
    }
}
