package com.project6.Unit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import javax.naming.Name;

import com.project6.drivers.DriverSingleton;
import com.project6.pages.UserMonitoring;
import com.project6.pages.Unit;
import com.project6.pages.User;  // <--- IMPORT kelas User untuk akses menu management

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

public class UnitSteps {
    private WebDriver driver;
    private Unit unitPage;
    private User userPage;  // <--- untuk klik management
    private WebDriverWait wait;

    public UnitSteps() {
        this.driver = DriverSingleton.getDriver();
        this.unitPage = new Unit(driver);
        this.userPage = new User(driver);  // <--- inisialisasi User page
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    @When("user click unit menu")
    public void user_click_unit_menu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        unitPage.clickUnitMenu();
     }    

     @And("user click tambah menu unit")
     public void user_click_tambah_menu_unit() {
         unitPage.clickAddUnitButton();     
    }

    @And("user input nama unit {string}")
    public void user_input_nama_unit(String name) {
        unitPage.setFieldName(name);
    }

    @And("user input field search name unit {string}")
    public String user_input_field_search_name_unit(String name) {
        unitPage.setFieldSearchUnit(name);
        return name;
    }

    @And("user click search unit button")
    public void user_click_search_unit_button() {
        unitPage.clickSearchButtonUnit();
    }

    @Then("user verify input search unit name {string}")
    public void user_verify_input_search_unit_name(String name) {
    By resultLocator = By.xpath("//h6[contains(text(),'" + name + "')]");
        WebElement result = wait.until(
            ExpectedConditions.visibilityOfElementLocated(resultLocator));
        Assert.assertTrue(
            result.isDisplayed(),
            "Nama tidak ditemukan! Yang dicari: " + name);
        }

        @And("user click button save unit")
            public void user_click_button_save_unit() {
        unitPage.clickSubmitAddUnitButton();
    }

    @And("user click edit unit")
    public void user_click_edit_unit() {
        unitPage.clickEditUnitButton();
    }

    @And("user click batal button unit")
    public void user_click_batal_button_unit() {
        unitPage.clickBatalButtonUnit();
    }

    @Then("user kembali ke halaman unit")
    public void user_kembali_ke_halaman_unit() {
        String expectedUrl = "https://magang.dikahadir.com/management/departemens"; // Ganti dengan URL yang sesuai
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL tidak sesuai! Harusnya: " + expectedUrl);
    }

        @And("user click search unit")
    public void user_click_search_unit() {
        unitPage.clickSearchButtonUnit();
    }

    @And("user click reset unit")
    public void user_click_reset_unit() {
        unitPage.clickResetButtonUnit();
    }

}