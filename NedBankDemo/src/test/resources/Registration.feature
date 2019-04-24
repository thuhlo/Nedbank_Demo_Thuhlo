Feature: Functionality of the registration page of nopCommerce demo website
  To test functionality of the registration page with invalid user details

  Background: Registration Page
    Given User opens home page
    And User clicks on register link

  Scenario: NopCommerce - Invalid Registration
    When User enters invalid details
    And clicks on the register link
    Then User should not be registered


  Scenario: NopCommerce - Valid Registration
    When user enters valid details
    And clicks on the register button
    Then user should be registered