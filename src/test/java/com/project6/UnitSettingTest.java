package com.project6;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project6.drivers.DriverSingleton;
import com.project6.pages.UnitSetting;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnitSettingTest {
    private UnitSetting unitSetting;
    private WebDriver driver = DriverSingleton.getDriver(); // Pastikan ambil instance yang aktif
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // ...
    public UnitSettingTest() {
        this.driver = DriverSingleton.getDriver();
        this.unitSetting = new UnitSetting(driver);
        
    }
    @When("user klik menu unit setting")
    public void user_klik_menu_unit_setting() {
        unitSetting.clickMenuManagement();
        unitSetting.clickMenuUnitSetting();
    }
    @And("user klik tombol tambahkan unit setting")
    public void user_klik_tombol_tambahkan_unit_setting() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        unitSetting.clickTambahButtonUnitSetting();
    }
    @Then("user isi nama unit setting {string}")
    public void user_isi_nama_unit_setting(String Divisi) {
        unitSetting.clickComboBoxLevel(Divisi);
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        unitSetting.clickSubmitTambahUnitSetting();
    }
    @Then("user kosong nama unit setting negative")
    public void user_kosong_nama_unit_setting_negative() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        unitSetting.clickSubmitTambahUnitSetting();
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        unitSetting.clickSubmitBatalUnitSetting();
    }
    @When("user klik tombol unit setting")
    public void user_klik_tombol_unit_setting() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        unitSetting.clickMenuUnitSetting();
    }
    @Then("User Delete Unit Setting")
    public void user_delete_unit_setting() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        unitSetting.clickDeleteButton();
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        unitSetting.clickDeleteYaUnitSetting();
    }
    @Then ("User Click Selfie")
    public void user_click_selfie() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        unitSetting.clickSwitchInput();
    }
}
