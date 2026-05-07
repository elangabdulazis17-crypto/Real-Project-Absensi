Feature: EditUser

  Scenario: Failed edit user
    # Tambahkan step login di sini
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    # Baru setelah itu masuk ke bagian menu user
    And user click menu management 
    And user click user menu
    And user continue click titik tiga menu
    And user click edit
    Then user mengosongkan field NIK
    And user click button save