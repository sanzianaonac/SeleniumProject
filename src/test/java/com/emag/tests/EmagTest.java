package com.emag.tests;

import com.emag.pages.CartPage;
import com.emag.pages.HomePage;
import com.emag.pages.SearchResultsPage;
import utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmagTest extends BaseTest {

    @Test
    public void testAddAndRemoveItemFromCart() {
        final int itemIndex = 2;

        boolean searchSuccess = homePage.searchFor("aspiratoare");
        Assert.assertTrue(searchSuccess, "Search for 'aspiratoare' failed");

        String itemName = searchResultsPage.getItemName(itemIndex);
        logger.info("Adding " + itemName + " to the cart");

        boolean addItemSuccess = searchResultsPage.addItemToCart(itemIndex);
        Assert.assertTrue(addItemSuccess, "Failed to add item to cart");

        boolean isItemInCart = cartPage.isItemInCart(itemName);
        Assert.assertTrue(isItemInCart, "Item was not added to cart");
        logger.info("Item added to cart.");

        cartPage.removeItemFromCart();

        boolean isCartEmpty = cartPage.isCartEmpty();
        Assert.assertTrue(isCartEmpty, "Item was not removed from cart");

        boolean navigateHomeSuccess = cartPage.navigateHome();
        Assert.assertTrue(navigateHomeSuccess, "Failed to navigate home");
        logger.info("Item removed from cart.");
    }
}
