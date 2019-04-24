Feature: Functionality of the checkout price
      To test if the checkout price is calculated correctly

  Background: Confirm checkout price
    Given User navigates to home page
    And logs in with valid <username> and <password>
    And Navigates to the Computers page and clicks Desktop tap

  Scenario: To test final price of check out
    When user selects build your own computer tab
    And user selects certain details of computer specifications
    And click add to cart and navigates to the shopping cart page
    Then total should be as expected

