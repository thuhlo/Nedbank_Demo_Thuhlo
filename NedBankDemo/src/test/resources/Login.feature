Feature: As a registered user I would like to log into the system

  Scenario: I would like to log into the website
    Given I navigate to homepage
    And click on the log-in link
    When enter valid <username> and <password>
    Then I should be logged into the system
