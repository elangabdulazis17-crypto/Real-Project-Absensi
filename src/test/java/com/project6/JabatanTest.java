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
import com.project6.pages.Jabatan;
import com.project6.pages.Login;
import com.project6.utills.Constans;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JabatanTest {
    private WebDriver driver;
    private Jabatan jabatan;
    private Login login;

    public JabatanTest() {
        this.driver = DriverSingleton.getDriver();
        this.jabatan = new Jabatan(driver);
        
    }
    @BeforeAll
    public static void setUp() {
    // Pastikan driver diinisialisasi sebelum tes dimulai
        WebDriver driver = DriverSingleton.getInstance(Constans.CHROME).getDriver();
        driver.get(Constans.URL);
        
        Login login = new Login(driver);
        login.setCredentials("admin@hadir.com", "MagangSQA_JC@123");
        login.ClickLogin();
    }
  
    @When("user klik menu jabatan")
    public void user_klik_menu_jabatan() {
        jabatan.ClickMenuManagement();
        jabatan.ClickMenuJabatan();
    }
    @And("user klik tombol tambahkan")
    public void user_klik_tombol_tambahkan() {
        jabatan.ClickButtonTambahkan();
    }
    @Then("user isi nama jabatan {string} dan level {string}")
    public void user_isi_nama_jabatan_dan_level(String nama, String level) {
        jabatan.AddJabatan(nama, level);;
    }

    @When("user klik tombol more vertical pada data jabatan")
    public void user_klik_tombol_more_vertical_pada_data_jabatan() {
        
    
        // Melakukan refresh adalah cara paling ampuh untuk mengatasi Stale Element di awal skenario
        driver.navigate().refresh();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        jabatan.setInputSearch("13");
        jabatan.ClickButtonSearch();
        
        try { Thread.sleep(1000); } catch (Exception e) {}
        jabatan.ClickButtonMoreVertical();
    }
    @And("user klik tombol edit")
    public void user_klik_tombol_edit() {
        jabatan.ClickButtonEdit();
    }
    @Then("user ubah nama jabatan {string} dan level {string}")
    public void user_ubah_nama_jabatan_dan_level(String namaBaru, String levelBaru) {
        jabatan.setInputNama(namaBaru);
        jabatan.setInputLevel(levelBaru);
        jabatan.ClickButtonSimpan();
    }
    @When("user klik tombol more vertical pada data jabatan untuk menghapus")
    public void user_klik_tombol_more_vertical_pada_data_jabatan_untuk_menghapus() {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    
        
        driver.navigate().refresh();
        
        jabatan.setInputSearch("13");
        jabatan.ClickButtonSearch();
        
        try { Thread.sleep(1000); } catch (Exception e) {}
        jabatan.ClickButtonMoreVertical();
    }
    @And("user klik tombol delete")
    public void user_klik_tombol_delete() {
        jabatan.ClickButtonDelete();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    
    WebElement buttonYa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ya']")));
    buttonYa.click();
    
    // 2. TUNGGU modal hilang (Sangat Penting agar tidak menghalangi kolom search)
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Ya']")));
    }
    @Then("data jabatan dengan level {string} harus terhapus")
    public void data_jabatan_dengan_level_harus_terhapus(String level) {
        jabatan.setInputSearch(level);
        jabatan.ClickButtonSearch();
    }
    @When("User Add Jabatan with name {string} and level {string}")
    public void user_add_jabatan_with_name_and_level(String nama, String level) {
        jabatan.AddJabatan(nama, level);
    }
    @And("User Klik Button Simpan")
    public void user_klik_button_simpan() {
        jabatan.ClickButtonTambah();
    }
    @Then("User Gagal Menambahkan Jabatan dengan nama {string} dan level {string}")
    public void user_gagal_menambahkan_jabatan_dengan_nama_dan_level(String nama, String level) {
    WebElement inputNama = driver.findElement(By.id("name"));
    
    // Mengambil pesan validasi HTML5
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String actualMessage = (String) js.executeScript("return arguments[0].validationMessage;", inputNama);
    
    System.out.println("Pesan yang muncul: " + actualMessage);
    
    // Verifikasi pesan
    Assert.assertEquals("Please fill out this field.", actualMessage);
    }
    @When("User Search Jabatan with level {string}")
    public void user_search_jabatan_with_level(String level) {
        driver.navigate().refresh();
    
        
        jabatan.setInputSearch(level);
        jabatan.ClickButtonSearch();
    }
    @Then ("User Menanmpilkan data jabatan dengan level {string}")
    public void user_menanmpilkan_data_jabatan_dengan_level(String level) {
    String actualLevel = jabatan.getLevelText(level);
    
    System.out.println("Level yang ditemukan di UI: " + actualLevel);
    
    
    Assert.assertEquals(actualLevel, level, "Data level tidak sesuai atau tidak muncul!");
    }
    
    @When("User Reset Jabatan with level {string}")
    public void user_reset_jabatan_with_level(String level) {
        driver.navigate().refresh();
        jabatan.setInputSearch(level);
        jabatan.ClickButtonSearch();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }
    @Then("User Reset data jabatan dengan level {string}")
    public void user_reset_data_jabatan_dengan_level(String level) {
        jabatan.ClickButtonReset();
    }
    @Then("User Tidak Menambahkan Data nama jabatan {string}")
    public void user_tidak_menambahkan_data_jabatan_dengan_nama_dan_level(String nama) {
    jabatan.clearInputNama();
    jabatan.ClickButtonSimpan(); 
    String actualMessage = jabatan.getValidationMessageNama();
    String expectedMessage = "Please fill out this field.";
    
    System.out.println("Pesan yang muncul di browser: " + actualMessage);
    
    // 3. Assertion
    Assert.assertEquals(actualMessage, expectedMessage, "Pesan validasi tidak muncul!");
    }

}