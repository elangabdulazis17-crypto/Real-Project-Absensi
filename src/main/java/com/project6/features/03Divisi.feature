Feature: Manage Divisi
    Scenario: Add new Divisi
       When user klik menu divisi
       And user klik tombol tambahkan divisi
       Then user isi nama divisi "ASP"
    
    Scenario: Edit Divisi
       When User search divisi dengan nama "ASP"
       And User klik tombol more vertical pada data divisi
       And User klik tombol edit pada data divisi
       Then User edit nama divisi menjadi "IT ASP"

    Scenario: Edit Divisi Kosongkan
       When User search divisi dengan nama "IT ASP"
       And User klik tombol more vertical pada data divisi
       And User klik tombol edit pada data divisi
       Then User Tidak Menambahkan Data nama divisi ""

    Scenario: Delete Divisi
       When User search divisi dengan nama baru "IT ASP"
       And User klik tombol more vertical pada data divisi untuk menghapus
       Then User klik tombol delete pada data divisi

    Scenario: Search Divisi
        When User search divisi dengan nama "123456"
        Then User Menampilkan data divisi dengan nama "123456"

    Scenario: Reset Search
        When User search divisi dengan nama "123456"
        Then User Reset data divisi dengan nama "123456"

    Scenario: Add Divisi Kosongkan
         When user klik tombol tambahkan divisi
         And user klik tombol tambah divisi ""
         And user menambahkan divisi dengan nama
         Then user gagal menambahkan divisi ""