Feature: User

  Scenario: Export data user
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management 
    And user click user menu
    And user click button export
    Then user success download file export