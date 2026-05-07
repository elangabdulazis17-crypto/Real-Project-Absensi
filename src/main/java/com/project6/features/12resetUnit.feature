Feature: Reset Unit 

Scenario: User reset search filter in unit page
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management
    When user click unit menu
    And user input field search name unit "IT Support"
    And user click reset unit
    Then user kembali ke halaman unit