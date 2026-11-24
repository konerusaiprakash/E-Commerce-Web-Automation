package com.saiprakash.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/** Search results page: results, sorting and opening a product. */
public class SearchResultsPage extends BasePage {

    // Flipkart product URLs contain "/p/", which is more stable than its generated CSS class names
    private final By productLinks = By.xpath("//a[contains(@href,'/p/')]");
    private final By sortLowToHigh = By.xpath("//div[normalize-space()='Price -- Low to High']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasResults() {
        wait.until(ExpectedConditions.urlContains("/search"));
        wait.until(ExpectedConditions.presenceOfElementLocated(productLinks));
        return !driver.findElements(productLinks).isEmpty();
    }

    public void sortByPriceLowToHigh() {
        click(sortLowToHigh);
    }

    public boolean isSortedByPriceAscending() {
        return wait.until(ExpectedConditions.urlContains("sort=price_asc"));
    }

    public void openFirstProduct() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productLinks));
        click(productLinks);
    }
}
