package com.saiprakash.flipkart.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Product details page. Flipkart opens products in a new browser tab. */
public class ProductPage extends BasePage {

    private final By addToCartButton = By.xpath(
            "//button[contains(translate(normalize-space(.),"
                    + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage switchToLatestWindow() {
        wait.until(d -> d.getWindowHandles().size() >= 1);
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
        return this;
    }

    public void addToCart() {
        click(addToCartButton);
    }
}
