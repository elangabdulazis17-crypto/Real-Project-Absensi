package com.project6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.project6.drivers.DriverSingleton;
import com.project6.pages.Posisi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PosisiTest {
    private Posisi posisi;
    private WebDriver driver = DriverSingleton.getDriver(); // Pastikan ambil instance yang aktif
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
public PosisiTest() {
    this.driver = DriverSingleton.getDriver();
    this.posisi = new Posisi(driver);
}
    @When("user klik menu posisi")
    public void user_klik_menu_posisi() {
        posisi.ClickMenuManagementPosisi();
        posisi.ClickMenuPosisi();
    }
    @And("user klik tombol tambahkan posisi")
    public void user_klik_tombol_tambahkan_posisi() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.ClickButtonTambahkanPosisi();
    }
    @Then("user isi nama posisi {string} dan memilih dropdown {string}")
    public void user_isi_nama_posisi(String nama,String Pilihan) {
        posisi.setInputNamaPosisi(nama);
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.setDropdownPosisi(Pilihan);
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.ClickButtonTambahPosisi();
    }
    
    @When("User search posisi dengan nama {string}")
    public void user_search_posisi_dengan_nama(String nama) {
        posisi.refreshPageDivisi();
        posisi.setInputSearchDivisi(nama);
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.ClickButtonSearchDivisi();
    }
    @And("User klik tombol more vertical pada data posisi")
    public void user_klik_tombol_more_vertical_pada_data_posisi() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.ClickButtonMoreVerticalDivisi();
    }
    @And("User klik tombol edit pada data posisi")
    public void user_klik_tombol_edit_pada_data_posisi() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.ClickButtonEditDivisi();
    }
    @Then("User edit nama posisi menjadi {string}")
        public void user_edit_nama_posisi_menjadi(String namaBaru) {
            posisi.setInputNamaPosisi(namaBaru);
            posisi.ClickButtonSimpanDivisi();
    }
    @And("User klik tombol more vertical pada data posisi untuk menghapus")
    public void user_klik_tombol_more_vertical_pada_data_posisi_untuk_menghapus() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.ClickButtonMoreVerticalDivisi();
    }
    @Then("User klik tombol delete pada data posisi")
    public void user_klik_tombol_delete_pada_data_posisi() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        posisi.ClickButtonDeleteDivisi();
        posisi.ClickButtonDeleteConfirmDivisi();
    }
    @When("User Add posisi with name {string} and dropdown {string}")
    public void user_add_posisi_with_name_and_dropdown(String nama, String dropdown) {
        posisi.addNamaPosisi(nama, dropdown);
    }
    @And("User Klik Button Simpan Posisi")
    public void user_klik_button_simpan() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        posisi.BtnTambahPosisi();
    }
    @Then("User Gagal Menambahkan Posisi dengan nama {string} dan dropdown {string}")
    public void user_gagal_menambahkan_posisi_dengan_nama_dan_dropdown(String nama, String dropdown) {
    WebElement inputNama = driver.findElement(By.xpath("//input[@placeholder='Nama Position']"));

    // Ambil pesan validasi HTML5
    String actualMessage = inputNama.getAttribute("validationMessage");

    System.out.println("Pesan yang muncul: " + actualMessage);
    Assert.assertEquals(actualMessage, "Please fill out this field.");

    String message = posisi.getValidationMessageNama();
    Assert.assertEquals(message, "Please fill out this field.");
    posisi.ClickButtonBatal();
    }
    @Then("User Gagal Menambahkan Posisi dengan nama {string}")
    public void user_gagal_menambahkan_posisi_dengan_nama(String nama) {
    posisi.clearInputNamaPosisi();
    posisi.ClickButtonSimpanDivisi();
    try { Thread.sleep(5000); } catch (InterruptedException e) {}
    posisi.ClickButtonBatal();
    }

    @Then("User Menampilkan data posisi dengan nama {string}")
     public void user_menampilkan_data_posisi_dengan_nama(String nama) {
        String actualNama = posisi.getNamaText(nama);
    
        System.out.println("Nama yang ditemukan di UI: " + actualNama);
    
    
        Assert.assertEquals(actualNama, nama, "Data nama tidak sesuai atau tidak muncul!");
    }

    @Then("User reset data posisi dengan nama {string}")
    public void user_reset_data_posisi_dengan_nama(String nama) {
        posisi.ClickButtonResetDivisi();
    }

}

