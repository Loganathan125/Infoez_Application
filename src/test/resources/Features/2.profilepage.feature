@profile
Feature: Profile Page Functionality

  Scenario: Admin sees control center on profile
    When the user tap profile button
    Then the admin control center is displayed on profile

  Scenario: Admin opens approvals page from business moderation
    And the user tap business moderation menu
    Then the approvals page is displayed
    And the user tap on Claim
    And the user tap on users
    And the user tap on categories
    Then the user again tap on approvals

  Scenario: verify the claims review mwnu
    When admin tap claims review
    Then claims review page should be displayed but navigated to approvals page

  Scenario: verify the Manage User Menu
    When admin tap Manage User
    Then User management page shoould be dislayed but navigated to approvals page

  Scenario: verif the Manage Categories
    When admin tap Manager categories
    Then categories Management Page should be displayed but navigated to approvals page

  Scenario: Verify pending Business count
    When the user capture the current pending count
    And the user approve the first pending business
    Then the pending count should decrease by one
    
    Scenario: verify pending Business count
    When the admin capture the current pending count
    And the admin reject the first pending business
    Then the pending count should be decrease by one


  Scenario: verify the Users Count and platform members llist
    When the admin tap manage user
    Then the users count,platform members count nd listed members should match
    
    Scenario: verify the user suspend list
    When the admin tap suspend button
    And the suspended button should be displayed
    And the admin tap restore button 
    Then the suspend button should be displayed


  Scenario: verify claims count and listed claims
    When admin tap on claims review
    Then the claims count and listed claims should match

  Scenario Outline: verify categories count and listed categories
    When the admin tap on categories
    And tap on new button
    And the admin enter new categories "<New Categories>"
    And the admin tap on add categories
    Then the admin validate the new categories
    Then the categories header count and listed categories should match

    Examples:
      | New Categories |
      | SS Crackers    |

  Scenario Outline: verify categories deactivate and activate
    When the admin click on categories
    And the admin tap on deactivates
    And the activate button should be displayed
    And the admin tap on activate
    Then the deactivate button should be displayed
