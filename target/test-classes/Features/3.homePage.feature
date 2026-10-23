
Feature: verify the home page fuctionality

  Scenario: to verify the notification count decreased after opening a notification
   # Given the admin tap on notification
  #  When the user capture the current notification count
  #  And the user open the first notification
   # Then the notification count should decrease by one

    Scenario Outline: to verify the location selection on home page
    Given the user tap on location field
    When the user search city "<City>"
    And the user select city "chennai" from the list
    Then the home page should display location 
    
    Examples:
    |City|
    |Chennai|
   
    Scenario: to verify the notify me functionality
    Given the admin tap near me option
    When the admin tap on only this time option
    And the admin tap turn on option
    Then the Nearby business should be displayed
     @home
    Scenario: to verify the use my current location
    Given the admin tap on lodation field
    When the amin tap on use my current location 
    And the admin tap on this time option
    Then use my current location should be displayed
  
 
    


