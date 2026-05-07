Feature: Manage Jabatan
    Scenario: Add new Jabatan
       When user klik menu jabatan
       And user klik tombol tambahkan
       Then user isi nama jabatan "Testing" dan level "13"
    
    Scenario: Edit Jabatan
       When user klik tombol more vertical pada data jabatan 
       And user klik tombol edit 
       Then user ubah nama jabatan "EditCoba" dan level "13"

    Scenario: Edit Jabatan Kosongkan nama jabatan
       When user klik tombol more vertical pada data jabatan 
       And user klik tombol edit 
       Then User Tidak Menambahkan Data nama jabatan ""
    
    Scenario: Search Jabatan
       When User Search Jabatan with level "13"
       Then User Menanmpilkan data jabatan dengan level "13"
    
    Scenario: Delete Jabatan
        When user klik tombol more vertical pada data jabatan untuk menghapus
        And user klik tombol delete
        Then data jabatan dengan level "13" harus terhapus

    Scenario: Kosongkan nama jabatan 
        When user klik tombol tambahkan
        And User Add Jabatan with name "" and level ""
        And User Klik Button Simpan
        Then User Gagal Menambahkan Jabatan dengan nama "" dan level ""

    Scenario: Reset search
        When User Reset Jabatan with level "2"
        Then User Reset data jabatan dengan level "2"
