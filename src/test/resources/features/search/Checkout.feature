@Checkout
Feature: Checkout Validation
  Scenario: Checkout a random product
    Given user is on login Page
    When user enters username and password
    And clicks on LoginButton
    Then user is on HomePage
    When  user selects a random product
    Then user should be on preview Page
    And user clicks on AddToCart Button
    And user clicks on Cart Button
    Then user should be on cart page
    And user verifies details on cart page
    When user clicks on checkout button
    Then user is on OverView Page
    And user enters checkout details
    And then user clicks on Continue Button
    Then user is on Finish Page
    Then user verifies all the details
    And clicks on Finish Button
    Then verifies confirmation order details
