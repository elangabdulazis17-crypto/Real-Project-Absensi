Feature: Search name User

  Scenario: reset User Monitoring
     # 1. Login dulu supaya menu muncul
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    
    # 2. Masuk ke halaman User
    And user click menu management
    And user click user monitoring menu
    
    # 3. Baru lakukan pencarian (Search)
    And user input field search name monitoring "Gatuso"
    And user click search monitoring button
    And user click button reset 
    Then user verify field search name monitoring should be empty