Feature: Search for ID and get values

  Scenario: Validate values when user search for an ID
    Given User inputs an ID number
    When Open Web Browser and Navigate to ASPDemo
    When User Navigates to ASPDemo website
    And User Navigates to Grid page
    And User Selects Specific ID
    Then User should see the table information
    And Close Browser