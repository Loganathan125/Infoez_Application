@login
Feature: Infoez Mobile Application login functionality

  Scenario Outline: Login with valid credentials
    Given ven the user tap profile button
    And the user tap login or register button
    Given the user enter username "<username>"
    And the user enter password "<password>"
    And the user click on login button
    Then the user redirected the home page "<HomePage>"

    Examples:
      | username         | password  | HomePage |
      # | admininfoez.com  | Admin@123 | InValidEmail |
      # |                  | Admin@123 | emptyEmail   |
      # | admin@infoez.com |           | EmptyPass    |
      | admin@infoez.com | Admin@123 | Valid    |



