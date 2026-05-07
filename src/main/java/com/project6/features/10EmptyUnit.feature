Feature: Empty data unit

Scenario: User cancel adding a new unit
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management
    When user click unit menu
    And user click tambah menu unit
    And user input nama unit "Marketing"
    And user click batal button unit
    Then user kembali ke halaman unit