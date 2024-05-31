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
        Assert.assertTrue(homePage.searchFor("aspiratoare"));
        String itemName = searchResultsPage.getItemName(itemIndex);
        logger.info("Adding " + itemName + " to the cart");
        Assert.assertTrue(searchResultsPage.addItemToCart(itemIndex)); // Attempting to add the third item
        Assert.assertTrue(cartPage.isItemInCart(itemName), "Item was not added to cart");
        logger.info("Item added to cart.");
        cartPage.removeItemFromCart();
        Assert.assertTrue(cartPage.isCartEmpty(), "Item was not removed from cart");
        Assert.assertTrue(cartPage.navigateHome());
        logger.info("Item removed from cart.");
    }
}
