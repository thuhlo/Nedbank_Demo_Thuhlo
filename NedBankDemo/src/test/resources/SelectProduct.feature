Feature: Selecting a product from the Build your own computer page
  As a registered user, I would like to log in and select a product from
  the list and add it to cart

  Background: Selecting a product from Build your own computer page
    Given User is on the home page
    And User is logged in

    Scenario: Select a product with specific details
      When User navigates to the Computers tap and selects Desktop
      And Selects Build your own Computer link
      And Add a computer with certain specifications to the cart
      Then confirm that the item has correct specification