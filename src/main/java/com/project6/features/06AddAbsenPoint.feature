Feature: Add Absen Point

  Scenario: User successfully add new absen point
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management
    And user click absen point menu
    And user click tambah absen point menu
    And user click field nama absen point
    And user input nama absen point "Kantor Pusat"
    And user input latitude absen point "-6.1751"
    And user input longitude absen point "106.8272"
    And user input radius absen point "100"
    And user input deskripsi absen point "Absen point untuk area lobby utama"
    And user click submit absen point
    Then user should see the new absen point in the list