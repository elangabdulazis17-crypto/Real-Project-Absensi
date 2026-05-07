Feature: Add Absen Point

  Scenario: Empty Absen Point
    # Langkah login dan navigasi biasanya sudah ada di step definition lain
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    And user click menu management
    And user click absen point menu

    # Langkah yang sesuai dengan kode Java kamu
    And user click tambah absen point menu
    And user click submit absen point
    Then user kembali ke halaman absen point