package tests;

import framework.BaseTest;
import framework.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardTest extends BaseTest {

    @Test
    public void dashboardPageLoadsAndHasExpectedHeading() {
        driver.get(Config.baseUrl());

        // TODO: Replace this generic smoke assertion with a real, stable locator
        // and expected heading after inspecting the instructor-assigned website.
        Assert.assertFalse(driver.getTitle().isBlank(),
            "Page title should not be blank when the website has loaded.");

        // Optional smoke check: page body exists. This is not a substitute for
        // a requirement-based assertion of Dashboard / Project Overview.
        List<WebElement> body = driver.findElements(By.tagName("body"));
        Assert.assertEquals(body.size(), 1, "A rendered page body should exist.");
    }
}
