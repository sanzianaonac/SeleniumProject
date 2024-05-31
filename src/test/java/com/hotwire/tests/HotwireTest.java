package com.hotwire.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotwireTest extends BaseTest {

    @Test
    public void testFindFare() {
        Assert.assertTrue(flightsPage.setLeavingFrom("LAX"));
        logger.info("test find fare");
    }
}
