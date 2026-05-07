Feature: Management User Filter

  Scenario: Membatalkan filter pada halaman management user
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management 
    And user click user menu
    And user click filter button
    And user click batal filter button
    Then user kembali ke halaman user