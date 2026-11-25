package com.saiprakash.flipkart.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Flipkart home page: open the site, dismiss the login pop-up and search. */
public class HomePage extends BasePage {

    private final By loginPopupClose = By.xpath("//button[contains(text(),'✕')]");
    private final By searchBox = By.name("q");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(baseUrl);
        closeLoginPopupIfPresent();
        return this;
    }

    private void closeLoginPopupIfPresent() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(loginPopupClose))
                    .click();
        } catch (TimeoutException ignored) {
            // pop-up not shown this time, nothing to close
        }
    }

    public void searchFor(String product) {
        type(searchBox, product);
        visible(searchBox).sendKeys(Keys.ENTER);
    }
}
