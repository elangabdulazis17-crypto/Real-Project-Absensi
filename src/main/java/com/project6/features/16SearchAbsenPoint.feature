Feature: Search name Absen Point

  Scenario: Search name Absen Point
    # 1. Login dulu supaya menu muncul
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    
    # 2. Masuk ke halaman User
    And user click menu management
    And user click absen point menu
    
    # 3. Baru lakukan pencarian (Search)
    And user input field search name absen point "DIKA Banjarmasin90"
    And user click search absen button
    And user should see search absen result with name "DIKA Banjarmasin90"