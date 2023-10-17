@login
Feature: Login Feature

  Scenario: User can login successfully
    Given User is on the login page
    When User enters valid username and valid password
    And clicks the login button
    Then User should be redirected to the Home or Products page

  Scenario: User cannot login with invalid credentials
    Given User is on the login page
    And User enters valid username and valid password
    When User enters invalid credentials
    And clicks the login button
    Then I should see an error message