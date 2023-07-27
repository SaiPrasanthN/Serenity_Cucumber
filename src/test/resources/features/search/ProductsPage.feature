@Products
Feature: Products Page Validation

  Scenario: Selecting a random Product and adding to cart
    Given user is on login Page
    When user enters username and password
    And clicks on LoginButton
    Then user is on HomePage
    When  user selects a random product
    Then user should be on preview Page
    And user verifies data on preview page
   And user clicks on AddToCart Button
    And Cart symbol should be displayed with count of "1"

