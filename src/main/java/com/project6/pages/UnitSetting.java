package com.project6.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnitSetting {
    private WebDriver driver;
    private WebDriverWait wait;

    public UnitSetting( WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//p[text()='Management']")
    private WebElement MenuManagement;

    @FindBy (xpath = "(//p[text()='Unit Setting'])[1]")
    private WebElement MenuUnitSetting;

    @FindBy (xpath = "//button[text()='Tambahkan']")
    private WebElement tambahButtonUnitSetting;

    @FindBy (xpath = "(//div[@role='combobox'])[2]")
    private WebElement comboBoxLevel;

    @FindBy (xpath = "//button[text()='Tambah']" )
    private WebElement SubmitTambahUnitSetting;

    @FindBy (xpath = "//button[text()='Batal']" )
    private WebElement SubmitBatalUnitSetting;

    @FindBy (xpath = "//*[local-name()='svg' and contains(@class, 'feather-trash')]")
    private WebElement deleteButton;

    @FindBy (xpath = "//button[text()='Ya']")
    private WebElement DeleteYaUnitSetting;

    @FindBy (xpath = "//button[text()='Tidak']")
    private WebElement DeleteTidakUnitSetting;

    @FindBy (xpath = "//input[@type='checkbox' and contains(@class, 'MuiSwitch-input')]")
    private WebElement switchInput;

    public void clickMenuManagement() {
        MenuManagement.click();
    }
    public void clickMenuUnitSetting() {
        MenuUnitSetting.click();
    }
    public void clickTambahButtonUnitSetting() {
        tambahButtonUnitSetting.click();
    }
    public void clickComboBoxLevel(String Divisi) {
        wait.until(ExpectedConditions.elementToBeClickable(comboBoxLevel)).click();

        // Tunggu sampai backdrop (MuiModal-backdrop) tidak menghalangi lagi
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiBackdrop-root")));

        // Klik opsi secara normal
        String xpathOpsi = String.format("//li[@role='option' and text()='%s']", Divisi);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOpsi))).click();
    }
    public void clickSubmitTambahUnitSetting() {
        SubmitTambahUnitSetting.click();
    }
    public void clickSubmitBatalUnitSetting() {
        SubmitBatalUnitSetting.click();
    }
    public void clickDeleteButton() {
        deleteButton.click();
    }
    public void clickDeleteYaUnitSetting() {
        DeleteYaUnitSetting.click();
    }
    public void clickDeleteTidakUnitSetting() {
        DeleteTidakUnitSetting.click();
    }
    public void clickSwitchInput() {
        switchInput.click();
    }

}
