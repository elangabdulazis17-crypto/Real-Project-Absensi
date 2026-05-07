package com.project6.UserMonitoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import com.project6.drivers.DriverSingleton;
import com.project6.pages.UserMonitoring;
import com.project6.pages.User;  // <--- IMPORT kelas User untuk akses menu management
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserMonitoringSteps {
    private WebDriver driver;
    private UserMonitoring userMonitoringPage;
    private User userPage;  // <--- untuk klik management
    private WebDriverWait wait;

    public UserMonitoringSteps() {
        this.driver = DriverSingleton.getDriver();
        this.userMonitoringPage = new UserMonitoring(driver);
        this.userPage = new User(driver);  // <--- inisialisasi User page
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @When("user click user monitoring menu")
    public void user_click_user_monitoring() {
        userMonitoringPage.clickUserMonitoringMenu();
    }    

    @And("user click tambah menu monitoring")
    public void user_click_tambah_menu_monitoring() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        userMonitoringPage.clickaddMonitorButton();
    }

    @And("user input full name {string}")
    public void user_input_full_name(String fullName) {
    userMonitoringPage.inputFullName(fullName);
    }

    @And("user input field search name monitoring {string}")
    public void user_input_field_search_name_monitoring(String searchQuery) {
        userMonitoringPage.inputSearchNameMonitoring(searchQuery);
    }

    @And("user click search monitoring button")
    public void user_click_search_monitoring_button() {
        userMonitoringPage.clickSearchMonitoring();
    }

    @Then("user should see search monitoring result with name {string}")
    public void user_should_see_search_monitoring_result_with_name(String expectedName) {
        By resultLocator = By.xpath("//h6[contains(text(),'" + expectedName + "')]");
        WebElement result = wait.until(
            ExpectedConditions.visibilityOfElementLocated(resultLocator));
        Assert.assertTrue(
            result.isDisplayed(),
            "Nama tidak ditemukan! Yang dicari: " + expectedName);
        }


    @And("user input email {string}")
    public void user_input_email(String email) {
        userMonitoringPage.inputEmail(email);
    }  

    @And("user input password {string}")
    public void user_input_password(String password) {  
        userMonitoringPage.inputPassword(password);
    } 

    @And("user input unit {string}")
    public void user_input_unit(String unit) {
        userMonitoringPage.selectUnit(unit);
    }

    @And("user click submit add user button")
    public void user_click_submit_add_user_button() {
        userMonitoringPage.clickSubmit();
    }

    @Then("user berhasil menambahkan data user")
    public void user_berhasil_menambahkan_data_user() {
        String expectedEndpoint = "/management/user-monitoring";
        try {
            wait.until(ExpectedConditions.urlContains(expectedEndpoint));
            String actualUrl = driver.getCurrentUrl();
            System.out.println("Berhasil Tambah Data! Sekarang berada di: " + actualUrl);
            Assert.assertTrue(actualUrl.contains(expectedEndpoint), 
                "Halaman tidak sesuai! Harusnya mengandung " + expectedEndpoint + " tapi malah: " + actualUrl);
        } catch (Exception e) {
            Assert.fail("Gagal pindah halaman! URL saat ini: " + driver.getCurrentUrl());
        }
    }  

        @Then("user verify field search name monitoring should be empty")
        public void user_verify_field_search_name_monitoring_should_be_empty() {   
        userMonitoringPage.clickResetButtonMonitoring(); // Pastikan klik reset sebelum validasi
            // Beri jeda singkat untuk memastikan field benar-benar ter-reset   
        String searchValue = userMonitoringPage.getSearchFieldValueMonitoring();
        Assert.assertEquals(searchValue, "", "Field search tidak kosong setelah reset!");
    }

    @Then("user kembali ke halaman user monitoring")
    public void user_kembali_ke_halaman_user_monitoring() {
        String expectedEndpoint = "/management/user-monitoring";
        
        try {
            // Tunggu hingga URL mengandung endpoint yang diharapkan
            wait.until(ExpectedConditions.urlContains(expectedEndpoint));
            String actualUrl = driver.getCurrentUrl();
            System.out.println("DEBUG: URL saat ini adalah [" + actualUrl + "]");
            Assert.assertTrue(actualUrl.contains(expectedEndpoint), 
                "Gagal! URL seharusnya mengandung [" + expectedEndpoint + "] tetapi saat ini [" + actualUrl + "]");
        } catch (Exception e) {
            // Jika timeout, berikan pesan error yang jelas
            Assert.fail("Timeout: Gagal kembali ke halaman user monitoring setelah klik Batal. URL saat ini: " + driver.getCurrentUrl());
        }
    }
}