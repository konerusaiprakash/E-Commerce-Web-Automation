@search
Feature: Flipkart product search

  Background:
    Given the Flipkart home page is open

  @smoke
  Scenario Outline: Searching for a product shows results
    When the user searches for "<product>"
    Then product results are displayed

    Examples:
      | product    |
      | laptop     |
      | headphones |
      | smartphone |

  Scenario: Sort search results by price low to high
    When the user searches for "laptop"
    And the user sorts the results by price low to high
    Then the results are sorted by price in ascending order
