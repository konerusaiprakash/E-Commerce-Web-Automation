package com.saiprakash.flipkart.stepdefs;

import com.saiprakash.flipkart.base.DriverFactory;
import com.saiprakash.flipkart.pages.CartPage;
import com.saiprakash.flipkart.pages.HomePage;
import com.saiprakash.flipkart.pages.ProductPage;
import com.saiprakash.flipkart.pages.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/** Step definitions for the Flipkart feature files. */
public class FlipkartSteps {

    private HomePage homePage() {
        return new HomePage(DriverFactory.getDriver());
    }

    private SearchResultsPage resultsPage() {
        return new SearchResultsPage(DriverFactory.getDriver());
    }

    @Given("the Flipkart home page is open")
    public void theFlipkartHomePageIsOpen() {
        homePage().open();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String product) {
        homePage().searchFor(product);
    }

    @Then("product results are displayed")
    public void productResultsAreDisplayed() {
        Assert.assertTrue(resultsPage().hasResults(), "No product results were displayed");
    }

    @When("the user sorts the results by price low to high")
    public void theUserSortsTheResultsByPriceLowToHigh() {
        resultsPage().sortByPriceLowToHigh();
    }

    @Then("the results are sorted by price in ascending order")
    public void theResultsAreSortedByPriceInAscendingOrder() {
        Assert.assertTrue(resultsPage().isSortedByPriceAscending(), "Results were not sorted by price ascending");
    }

    @When("the user opens the first product")
    public void theUserOpensTheFirstProduct() {
        resultsPage().openFirstProduct();
        new ProductPage(DriverFactory.getDriver()).switchToLatestWindow();
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        new ProductPage(DriverFactory.getDriver()).addToCart();
    }

    @Then("the cart page is displayed")
    public void theCartPageIsDisplayed() {
        Assert.assertTrue(new CartPage(DriverFactory.getDriver()).isDisplayed(), "Cart page was not displayed");
    }
}
