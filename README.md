# Flipkart E-Commerce Web Automation (Selenium + Cucumber + TestNG)

Practice BDD automation project for the Flipkart website, built with Java, Selenium WebDriver, Cucumber,
TestNG and Maven using the Page Object Model.

## What it covers
- Product search, data-driven with Scenario Outline (laptop, headphones, smartphone)
- Sorting results by price, low to high
- Opening a product (new browser tab handling) and adding it to the cart
- Login pop-up handling, explicit waits and text-based XPath locators

## Tech stack
Java 17, Selenium WebDriver 4, Cucumber 7 (BDD), TestNG, Maven, Extent Reports, Jenkins

## Project structure
```
src/test/java/com/saiprakash/flipkart
  base/        DriverFactory (Chrome/Firefox, headless option) and Hooks (setup, teardown, failure screenshots)
  pages/       HomePage, SearchResultsPage, ProductPage, CartPage
  stepdefs/    Cucumber step definitions
  runners/     TestNG + Cucumber runner
  utils/       ConfigReader
src/test/resources
  features/    search, cart
  config.properties, extent.properties
Jenkinsfile
```

## How to run
Requirements: JDK 17, Maven, Chrome or Firefox.

```
mvn clean test
```

Useful options:

```
mvn clean test -Dbrowser=firefox
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Reports
- Extent Report: `target/extent-report/ExtentSpark.html`
- Cucumber HTML report: `target/cucumber-reports/cucumber.html`
- Failed scenarios include a screenshot

## Important notes
- Flipkart is a live website. Its page layout changes often, and it may show a captcha or block automated
  browsers (especially headless mode). Run with a visible browser (`headless=false`, the default).
- If a locator stops working, inspect the element in the browser and update it in the matching class in `pages/`.
- Some products (for example clothes) need a size to be chosen before "Add to cart". The cart scenario uses
  headphones to avoid this.
- This is a learning project and is not affiliated with Flipkart.

## Author
Koneru Loka Saiprakash
