@login
Feature: Infoez Mobile Application login functionality

  Background:
    Given the user launch the application
    When ven the user tap profile button
    And the user tap login or register button

  Scenario Outline: Login with valid credentials
    Given the user enter username "<username>"
    And the user enter password "<password>"
    And the user click on login button
    Then the user redirected the home page "<HomePage>"

    Examples:
      | username         | password  | HomePage  |
      |                  |           | InValid1  |
      | 1234567899       | 12345678  | InValid2  |
      | admin@infoez.com | Admin     | InValid3  |
      | admin@infoez.com | admin@123 | InValid4  |
      | admin@infoez.com | ADMIN@123 | InValid5  |
      | admin@infoez.com | !@$%^&*@! | InValid6  |
      | admin&infoez.com | Admin@123 | InValid7  |
      | 123456789        | Admin@123 | Invalid8  |
      | admin@infoez.com | 123456789 | InValid9  |
      | admininfoez.com  | Admin@123 | InValid10 |
      |                  | Admin@123 | Invalid11 |
      | admin@infoez.com |           | Invalid12 |
      | admin@infoez.com | Admin@123 | Valid     |
