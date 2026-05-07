Feature: Management Unit Functionality

Scenario: User search for a specific unit name
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management
    When user click unit menu
    And user input field search name unit "IT Support"
    And user click search unit button
    Then user verify input search unit name "IT Support"