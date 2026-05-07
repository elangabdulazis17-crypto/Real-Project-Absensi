package com.project6.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Posisi {
    private WebDriver driver;
    private WebDriverWait wait;

    public Posisi( WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//p[text()='Management']")
    private WebElement MenuManagement;

    @FindBy (xpath = "(//p[text()='Posisi'])[1]")
    private WebElement MenuPosisi;

    @FindBy (xpath = "//button[text()='Tambahkan']")
    private WebElement tambahButtonPosisi;

    @FindBy (xpath = "//input[@id='name']") // Menggunakan atribut id)
    private WebElement InputNamaPosisi;

    @FindBy (xpath = "(//div[@role='combobox'])[2]")
    private WebElement ComboBoxDepartemen;

    @FindBy (xpath = "//button[text()='Tambah']")
    private WebElement SubmitTambahPosisi;

    @FindBy(xpath = "//div[@role='dialog']//button[contains(text(),'Tambah')]")
    WebElement btnSimpanModal;

    @FindBy (xpath ="//button[text()='Batal']")
    private WebElement ButtonBatal;

    @FindBy(xpath = "//*[local-name()='svg' and contains(@class, 'feather-more-vertical')]")
    private WebElement ButtonMoreVerticalDivisi;

    @FindBy(xpath = "(//li[text()='Edit'])[1]")
    private WebElement ButtonEditDivisi;

    @FindBy(xpath = "//button[text()='Simpan']")
    private WebElement ButtonSimpanDivisi;

    @FindBy(xpath = "(//li[text()='Delete'])[1]")
    private WebElement ButtonDeleteDivisi;

    @FindBy(xpath = "//button[text()='Ya']")
    private WebElement ButtonDeleteConfirmDivisi;

    @FindBy(id = "search")
    private WebElement InputSearchDivisi;

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement ButtonSearchDivisi;

    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement ButtonResetDivisi;

        public void ClickMenuManagementPosisi() {
            MenuManagement.click();
        }
        public void ClickMenuPosisi() {
            MenuPosisi.click();
        }
        public void ClickButtonTambahkanPosisi() {
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            tambahButtonPosisi.click();
        }
        public void BtnTambahPosisi() {
            // Tunggu modal stabil
            wait.until(ExpectedConditions.visibilityOf(btnSimpanModal));
            btnSimpanModal.click();
        }
        public void setInputNamaPosisi(String nama) {
            InputNamaPosisi.clear();
            InputNamaPosisi.sendKeys(nama);
        }
        public void setDropdownPosisi(String pilihan) {
        // 1. Klik dropdown untuk membuka listbox 
        // Klik dropdown
        wait.until(ExpectedConditions.elementToBeClickable(ComboBoxDepartemen)).click();

        // Tunggu sampai backdrop (MuiModal-backdrop) tidak menghalangi lagi
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiBackdrop-root")));

        // Klik opsi secara normal
        String xpathOpsi = String.format("//li[@role='option' and text()='%s']", pilihan);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOpsi))).click();
        }
        public void ClickButtonTambahPosisi() {
            SubmitTambahPosisi.click();
        }
        public void ClickButtonBatal() {
            ButtonBatal.click();
        }
        public void ClickButtonMoreVerticalDivisi() {
            ButtonMoreVerticalDivisi.click();
        }
        public void ClickButtonEditDivisi() {
            ButtonEditDivisi.click();
        }
        public void ClickButtonSimpanDivisi() {
            wait.until(ExpectedConditions.visibilityOf(ButtonSimpanDivisi));
            ButtonSimpanDivisi.click();
        }
        public void ClickButtonDeleteDivisi() {
            ButtonDeleteDivisi.click();
        }
        public void ClickButtonDeleteConfirmDivisi() {
            ButtonDeleteConfirmDivisi.click();
        }
        public void setInputSearchDivisi(String nama) {
        WebElement InputSearchDivisi = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        // 2. Klik dulu untuk memastikan fokus
        InputSearchDivisi.click();
        InputSearchDivisi.clear();
        InputSearchDivisi.sendKeys(nama);
        }
        public void ClickButtonSearchDivisi() {
            ButtonSearchDivisi.click();
         }
        public void ClickButtonResetDivisi() {
            ButtonResetDivisi.click();
         }
        public void refreshPageDivisi() {
        driver.navigate().refresh();
        }
        public String getSuksesMessageTextDivisi() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard Menu']")));
        return successMessage.getText();
        }
        public String getErrorMessageTextDivisi() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']")));
        return errorMessage.getText();
        }
        public String getValidationMessageNama() {
        // Pastikan locator (id:name) benar sesuai inspect element kamu
        WebElement inputNama = driver.findElement(By.id("name"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Mengambil pesan validasi langsung dari property internal HTML5
        return (String) js.executeScript("return arguments[0].validationMessage;", inputNama);
        }
        public void addNamaPosisi(String nama , String dropdown) {
            setInputNamaPosisi(nama);
            setDropdownPosisi(dropdown);
            ClickButtonTambahPosisi();
        }
        public void clearInputNamaPosisi() {
        WebElement inputNama = driver.findElement(By.id("name"));
        inputNama.sendKeys(Keys.CONTROL + "a");
        inputNama.sendKeys(Keys.BACK_SPACE);
        }
        public WebElement getInputNamaField() {
        // Memaksa mencari ulang di DOM setiap kali dipanggil
        return driver.findElement(By.xpath("//input[@placeholder='Nama Position']"));
        }

        public String getNamaText(String nama) {
        // XPath menggunakan teks yang kita cari
        String xpath = "//h6[text()='" + nama + "']";
        
        try {
            // Tunggu sampai elemen terlihat (Visibility)
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return element.getText();
        } catch (Exception e) {
            return "Element tidak ditemukan: " + e.getMessage();
        }
    }
}
