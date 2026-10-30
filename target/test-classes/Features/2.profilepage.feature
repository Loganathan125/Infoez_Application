@admin
Feature: Profile Page Functionality

  Scenario: Admin sees control center on profile
    When the user tap profile button
    Then the admin control center is displayed on profile

  Scenario Outline: to verify the business moderation menu
    Given the user tap on business moderation menu
    When the approvals page is displayed
    And the user capture the current pending count
    And the user approve the tap pending business
	Then the pending count should decrease by one
    When the admin capture the current pending count
    And the admin reject the first pending business
    Then the pending count should be decrease by one
    And admin tap on claims review
    Then the claims count and listed claims should match
    And the admin tap manage user
    Then the users count,platform members count nd listed members should match
    And the admin tap suspend button
    And the suspended button should be displayed
    And the admin tap restore button
    Then the suspend button should be displayed
    And the admin tap on categories
    And tap on new button
    And the admin enter new categories "<New Categories>"
    And the admin tap on add categories
    And the admin validate the new categories
    Then the categories header count and listed categories should match
    And the admin tap on deactivates
    And the activate button should be displayed
    And the admin tap on activate
    Then the deactivate button should be displayed

    Examples:
      | New Categories        |
      | SS Crackers           |
      | abcdgfhskdjsdydhssfgs |
      | 12345678              |

  Scenario: verify the claims review menu
    When admin tap claims review
    Then claims review page should be displayed but navigated to approvals page

  Scenario: verify the Manage User Menu
    When admin tap Manage User
    Then User management page shoould be dislayed but navigated to approvals page

  Scenario: verif the Manage Categories
    When admin tap Manager categories
    Then categories Management Page should be displayed but navigated to approvals page
    
    Scenario: to verify the notification count decreased after opening a notification
    Given the admin tap on notification
    When the user capture the current notification count
    And the user open the first notification
    Then the notification count should decrease by one
