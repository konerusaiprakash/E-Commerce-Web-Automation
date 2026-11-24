package com.saiprakash.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/** Shopping cart page. */
public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.urlContains("viewcart"));
    }
}
