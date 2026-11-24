@cart
Feature: Flipkart shopping cart

  Background:
    Given the Flipkart home page is open

  @smoke
  Scenario: Add the first search result to the cart
    When the user searches for "headphones"
    And the user opens the first product
    And the user adds the product to the cart
    Then the cart page is displayed
