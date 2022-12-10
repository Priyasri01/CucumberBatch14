Feature: Login functionality
@sprint1 @regression
  Scenario: Valid admin login
    Given user is navigated to HRMS application
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in

  @regression @tc1101
  Scenario: Valid ess login
    Given user is navigated to HRMS application
    When user enters ess username and ess password
    And user clicks on login button
    Then user is successfully logged in

