Feature: Reset button

  Scenario: reset Button User
    # 1. Login dulu supaya menu muncul
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    
    # 2. Masuk ke halaman User
    And user click menu management
    And user click user menu
    
    # 3. Baru lakukan pencarian (Search)
    And user input field search name
    And user click button search
    And user verify user search result contains "!ikan Salmon"
    And user click button reset 
    Then user verify field search name should be empty

