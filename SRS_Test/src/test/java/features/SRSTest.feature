
Feature: Search Charging Stations
  Navigate to SRS website and search for charging stations

  Background:
    Given I am on the home page

  @smoke
  Scenario: Navigate to SRS website and search for charging stations
    Then Accept all cookies if presented
    Then Select Required Country
    Then Click on My Account
    Then Change to new Tab
    And  Validate Page Title
    Then Switch to map frame
    Then Search by Location
    Then Search by Charge Point ID



