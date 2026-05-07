Feature: Manage Unit Setting
    Scenario: Add new Unit Setting
       When user klik menu unit setting
       And user klik tombol tambahkan unit setting
       Then user isi nama unit setting "IT Support"

    Scenario: Add new Unit Setting Negative
        When user klik tombol tambahkan unit setting
        Then user kosong nama unit setting negative

    Scenario: Delete Unit Setting
        When user klik tombol unit setting
        Then User Delete Unit Setting
    
    Scenario: Click Selfie 
        When user klik tombol unit setting
        Then User Click Selfie