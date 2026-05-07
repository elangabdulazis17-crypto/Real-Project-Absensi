package com.project6;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.model.Log;
import com.project6.drivers.DriverSingleton;
import com.project6.pages.Divisi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DivisiTest {
    private Divisi divisi;
    private WebDriver driver = DriverSingleton.getDriver(); // Pastikan ambil instance yang aktif
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // ...
    public DivisiTest() {
        this.driver = DriverSingleton.getDriver();
        this.divisi = new Divisi(driver);
        
    }
    @When("user klik menu divisi")
    public void user_klik_menu_divisi() {
        divisi.ClickMenuManagementDivisi();
        divisi.ClickMenuDivisi();
    }
    @And("user klik tombol tambahkan divisi")
    public void user_klik_tombol_tambahkan() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        divisi.ClickButtonTambahkanDivisi();
    }
    @Then("user isi nama divisi {string}")
    public void user_isi_nama_divisi(String nama) throws InterruptedException {
        divisi.AddDivisi(nama);
    }

    @When ("user klik tombol tambah divisi {string}")
    public void user_klik_tombol_tambah_divisi(String nama) {
        divisi.AddDivisi(nama);
     }
     @And("user menambahkan divisi dengan nama")
     public void user_klik_tombol_tambah(){
         divisi.ClickButtonTambahDivisi();
     }
     @Then("user gagal menambahkan divisi {string}")
        public void user_gagal_menambahkan_divisi(String nama) {
        WebElement inputNama = driver.findElement(By.xpath("//input[@placeholder='Nama Divisi']"));

        // Ambil pesan validasi HTML5
        String actualMessage = inputNama.getAttribute("validationMessage");

        System.out.println("Pesan yang muncul: " + actualMessage);
        Assert.assertEquals(actualMessage, "Please fill out this field.");

        String message = divisi.getValidationMessageNamaDivisi();
        Assert.assertEquals(message, "Please fill out this field.");
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        divisi.ClickButtonBatalDivisi();
    }


    @When("User search divisi dengan nama {string}")
    public void user_search_divisi_dengan_nama(String nama) {
        divisi.refreshPageDivisi();
        divisi.setInputSearchDivisi(nama);
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        divisi.ClickButtonSearchDivisi();
    }
    @And("User klik tombol more vertical pada data divisi")
    public void user_klik_tombol_more_vertical_pada_data_divisi() {
        // Melakukan refresh adalah cara paling ampuh untuk mengatasi Stale Element di awal skenario
        try { Thread.sleep(3000); } catch (Exception e) {}
        divisi.ClickButtonMoreVerticalDivisi();
    }
    @And("User klik tombol edit pada data divisi")
    public void user_klik_tombol_edit_pada_data_divisi() {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        divisi.ClickButtonEditDivisi();
    }
    @Then("User edit nama divisi menjadi {string}")
    public void user_edit_nama_divisi_menjadi_dan_search_dengan_nama(String namaBaru) {
        divisi.setInputNamaDivisi(namaBaru);
        divisi.ClickButtonSimpanDivisi();
    }
    @When ("User search divisi{string}")
    public void user_search_divisi(String namaBaru) {
        divisi.setInputSearchDivisi(namaBaru);
        divisi.ClickButtonSearchDivisi();
    }
    @And("User klik tombol more vertical pada data divisi untuk mengedit")
    public void user_klik_tombol_more_vertical_pada_data_divisi_untuk_mengedit() {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    
        // Melakukan refresh adalah cara paling ampuh untuk mengatasi Stale Element di awal skenario
        driver.navigate().refresh();
        
        divisi.setInputSearchDivisi("IT ASP");
        divisi.ClickButtonSearchDivisi();
        
        try { Thread.sleep(1000); } catch (Exception e) {}
        divisi.ClickButtonMoreVerticalDivisi();
    }

    @Then("User Tidak Menambahkan Data nama divisi {string}")
    public void user_tidak_menambahkan_data_nama_divisi(String string) {
    // Jalankan aksi mengosongkan nama
    divisi.editNamaDivisiKosong();
    
    
    // Ambil pesan validasi yang muncul
    String actualMessage = divisi.getValidationMessageNamaDivisi();
    Assert.assertEquals(actualMessage, "Please fill out this field.");
    divisi.ClickButtonBatalDivisi(); // Klik batal untuk menutup modal setelah verifikasi
    }



    @When("User search divisi dengan nama baru {string}")
    public void user_search_divisi_dengan_nama_baru(String namaBaru) {
       try { Thread.sleep(2000); } catch (InterruptedException e) {}
    
        
        driver.navigate().refresh();
        
        divisi.setInputSearchDivisi("IT ASP");
        divisi.ClickButtonSearchDivisi();
    }
    @And("User klik tombol more vertical pada data divisi untuk menghapus")
    public void user_klik_tombol_more_vertical_pada_data_divisi_untuk_menghapus() {
        
        
        try { Thread.sleep(1000); } catch (Exception e) {}
        divisi.ClickButtonMoreVerticalDivisi();
    }
    @Then("User klik tombol delete pada data divisi")
    public void user_klik_tombol_delete_pada_data_divisi() {
        divisi.ClickButtonDeleteDivisi();
        divisi.ClickButtonDeleteConfirmDivisi();
    }

     @Then("User Menampilkan data divisi dengan nama {string}")
     public void user_menampilkan_data_divisi_dengan_nama(String nama) {
        String actualNama = divisi.getNamaText(nama);
    
        System.out.println("Nama yang ditemukan di UI: " + actualNama);
    
    
        Assert.assertEquals(actualNama, nama, "Data nama tidak sesuai atau tidak muncul!");
    }
    @Then("User Reset data divisi dengan nama {string}")
    public void user_reset_data_divisi_dengan_nama(String nama) {
    divisi.ClickButtonResetDivisi();
    }

}
