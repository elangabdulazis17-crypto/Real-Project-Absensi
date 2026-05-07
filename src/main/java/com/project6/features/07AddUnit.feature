Feature: Management Unit Functionality

  Scenario: User successfully add a new unit with name only
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management
    When user click unit menu
    And user click tambah menu unit
    And user input nama unit "IT Support"
    And user click button save unit
    Then user kembali ke halaman unit