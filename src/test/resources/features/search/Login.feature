@Login
Feature: User Login

  Background:
    Given user is on login Page
    When user enters username and password
    And clicks on LoginButton

  Scenario: Login with Valid Credentials

    Then user is on HomePage

    Scenario: Logout Scenario
      Given  user is on HomePage
     When user clicks on logout Button
      Then user should land on Login Page

      Scenario: Login with bulk users
        Given user is on login Page
        When user gets data from "Data.xlsx" file for login
