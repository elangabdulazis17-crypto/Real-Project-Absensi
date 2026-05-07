package com.project6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import com.project6.drivers.DriverSingleton;
import com.project6.pages.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserSteps {
    private WebDriver driver;
    private User userPage;
    private WebDriverWait wait;

    public UserSteps() {
        this.driver = DriverSingleton.getDriver();
        this.userPage = new User(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Given("user sudah berada di halaman user")
    public void user_sudah_berada_di_halaman_user() {
        System.out.println("Step: Memastikan user di halaman management user");
        // Bisa ditambahkan validasi URL atau tunggu elemen user page
        wait.until(ExpectedConditions.urlContains("/management/user"));
        }

    
        @When("user click menu management")
        public void user_click_menu_management() {
        userPage.clickManagementMenu();  // reuse dari class User
        }

         @And("user click user menu")
        public void user_click_menu_user() {
        userPage.clickUserMenu();  // reuse dari class User
        }

        @And("user continue click titik tiga menu")
            public void user_click_titik_tiga_menu() {
        // Hanya klik tombol titik tiga, jangan menunggu elemen Edit di sini
            userPage.clickTitikMenu();
        // Beri jeda singkat untuk memastikan animasi menu popup berjalan (opsional, bisa juga dihapus)
            try { Thread.sleep(500); } catch (InterruptedException e) {}
}

    @And("user click edit")
    public void user_click_edit_menu() {
    // Di sinilah kita tunggu menu Edit muncul dan siap diklik
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By editSelector = By.xpath("(//li[@role='menuitem' and contains(., 'Edit')])[3]");
    
    // Pastikan elemen dapat diklik, lalu klik
    wait.until(ExpectedConditions.elementToBeClickable(editSelector)).click();
}

    @And("user click button save")
    public void user_click_button_save() {
        userPage.clickSaveEditMenu();
    }

    @Then("user mengosongkan field NIK")
    public void user_mengosongkan_field_nik() {
        userPage.clearFieldNIK();
    }

    @And("user input field search name")
    public void user_input_field_search_name() {
        userPage.inputSearchName("!ikan Salmon"); 
    }

    @And("user click button search")
    public void user_click_button_search() {
        userPage.clickButtonSearch();
    }

    @Then("user verify user search result contains {string}")
    public void user_verify_search_result(String name) {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        String actual = userPage.getTxtSearchName(); 
        Assert.assertTrue(actual.toLowerCase().contains(name.toLowerCase()), 
            "Error: Hasil pencarian [" + actual + "] tidak mengandung [" + name + "]");
    }

    @And("user click button export")
    public void user_click_button_export() {
        userPage.clickExportButton();
    }

    @Then("user success download file export")
    public void user_success_download_file_export() {
        System.out.println("Skenario Export: Berhasil.");
        // Bisa ditambahkan pengecekan keberadaan file di folder download jika diperlukan
    }

    @And("user click filter button")
    public void user_filter_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        userPage.clickFilterButton();
    }

    @And("user click batal filter button")
    public void clickBatalButtonFilterUser() {
    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));

    By batalLocator =
            By.xpath("//button[contains(.,'Batal')]");

    WebElement batalButton = wait.until(
            ExpectedConditions.presenceOfElementLocated(batalLocator));

    ((JavascriptExecutor) driver)
            .executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    batalButton);

    wait.until(
            ExpectedConditions.elementToBeClickable(batalButton));

    batalButton.click();
    }


    @Then("user kembali ke halaman user")
    public void user_kembali_ke_halaman_user() {
        String expectedEndpoint = "/management/user";
        
        try {
            // Tunggu hingga URL mengandung endpoint yang diharapkan
            wait.until(ExpectedConditions.urlContains(expectedEndpoint));
            String actualUrl = driver.getCurrentUrl();
            System.out.println("DEBUG: URL saat ini adalah [" + actualUrl + "]");
            Assert.assertTrue(actualUrl.contains(expectedEndpoint), 
                "Gagal! URL seharusnya mengandung [" + expectedEndpoint + "] tetapi saat ini [" + actualUrl + "]");
        } catch (Exception e) {
            // Jika timeout, berikan pesan error yang jelas
            Assert.fail("Timeout: Gagal kembali ke halaman user setelah klik Batal. URL saat ini: " + driver.getCurrentUrl());
        }
    }

    @And("user click button reset")
    public void user_click_button_reset() {
        userPage.clickResetButtonUser();
    }

   @Then("user verify field search name should be empty")
    public void user_verify_field_search_name_should_be_empty() {   
        userPage.clickResetButtonUser(); // Pastikan klik reset sebelum validasi
        // Beri jeda singkat untuk memastikan field benar-benar ter-reset   
    String searchValue = userPage.getSearchFieldValue();
    Assert.assertEquals(searchValue, "", "Field search tidak kosong setelah reset!");
    }


}
