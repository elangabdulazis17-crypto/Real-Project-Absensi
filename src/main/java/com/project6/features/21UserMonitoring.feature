Feature: User Monitoring
  Sebagai admin
  Saya ingin menambahkan data user baru melalui halaman user monitoring
  Untuk mengelola pengguna sistem

  Background:
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button

  Scenario: Menambahkan user baru dengan data valid
    And user click menu management 
    And user click user monitoring menu
    And user click tambah menu monitoring
    And user input full name "Budi Santoso"
    And user input email "budi.santoso@example.com"
    And user input password "Password123"
    And user input unit "1 edit"
    And user click submit add user button
    Then user berhasil menambahkan data user