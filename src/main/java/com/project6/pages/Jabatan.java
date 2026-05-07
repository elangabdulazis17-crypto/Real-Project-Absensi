package com.project6.pages;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Jabatan {
    private WebDriver driver;
    private WebDriverWait wait;

    public Jabatan( WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy (xpath = "//p[text()='Management']")
    private WebElement MenuManagement;

    @FindBy (xpath = "//p[text()='Jabatan']")
    private WebElement MenuJabatan;

    @FindBy (xpath = "//button[text()='Tambahkan']")
    private WebElement ButtonTambahkan;

    @FindBy (id = "name")
    private WebElement InputNama;

    @FindBy (id = "level")
    private WebElement InputLevel;
    
    @FindBy (xpath = "//button[text()='Tambah']")
    private WebElement ButtonTambah;

    @FindBy (xpath = "//*[local-name()='svg' and contains(@class, 'feather-more-vertical')]")
    private WebElement ButtonMoreVertical;

    @FindBy (xpath = "(//li[text()='Edit'])[1]")
    private WebElement ButtonEdit;

    @FindBy (xpath = "//button[text()='Simpan']")
    private WebElement ButtonSimpan;

    @FindBy (xpath = "(//li[text()='Delete'])[1]")
    private WebElement ButtonDelete;

    @FindBy (xpath = "//button[text()='Ya']")
    private WebElement ButtonDeleteConfirm;

    @FindBy (id = "search")
    private WebElement InputSearch;

    @FindBy (xpath ="//button[text()='Search']")
    private WebElement ButtonSearch;

    @FindBy (xpath ="//button[text()='Reset']")
    private WebElement ButtonReset;

    @FindBy (xpath = "//h6[text()='13']")
    private WebElement DataJabatan;

    public void ClickMenuManagement() {
        MenuManagement.click();
    }
    public void ClickMenuJabatan() {
        MenuJabatan.click();
    }
    public void ClickButtonTambahkan() {
        ButtonTambahkan.click();
    }
    public void setInputNama(String nama) {
        InputNama.clear();
        InputNama.sendKeys(nama);

    }
    public void setInputLevel(String level) {
        InputLevel.clear();
        InputLevel.sendKeys(level);
    }
    public void ClickButtonTambah() {
        ButtonTambah.click();
    }
    public void ClickButtonSimpan() {
        ButtonSimpan.click();
    }
    public void setInputSearch(String search) {
    // 1. Inisialisasi JS Executor
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    // 2. Cari elemen secara standar dulu
    WebElement searchElement = driver.findElement(By.id("search"));

    // 3. Gunakan JS untuk set nilai (ini yang membuat tes jadi stabil)
    js.executeScript("arguments[0].value='';", searchElement); // Bersihkan field
    js.executeScript("arguments[0].value='" + search + "';", searchElement); // Isi field
    
    // 4. Trigger event agar aplikasi (React/Vue) tahu ada input baru
    js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", searchElement);
    
    // 5. Kirim Enter jika diperlukan
    searchElement.sendKeys(Keys.ENTER);
    }
    public void ClickButtonMoreVertical() {
        ButtonMoreVertical.click();
    }
    public void ClickButtonEdit() {
        try {
        // Gunakan JavaScript Click untuk menghindari masalah interaksi UI
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ButtonEdit);
    } catch (Exception e) {
        System.out.println("Gagal mengklik tombol Edit: " + e.getMessage());
    }
    }
    public void ClickButtonDelete() {
        ButtonDelete.click();
    }
    public void ClickButtonDeleteConfirm() {
        ButtonDeleteConfirm.click();
    }
    public void ClickButtonSearch() {
        ButtonSearch.click();
    }
    public void ClickButtonReset() {
        ButtonReset.click();
    }

    public void AddJabatan(String nama, String level) {
        setInputNama(nama);
        setInputLevel(level);
        ClickButtonTambah();
    }
    public void EditJabatan(String nama, String level , String search) {
        setInputSearch(search);
        ClickButtonSearch();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        ClickButtonMoreVertical();
        ClickButtonEdit();
        setInputNama(nama);
        setInputLevel(level);
        ClickButtonSimpan();
    }
    public void DeleteJabatan(String level , String search) {
        setInputSearch(search);
        ClickButtonSearch();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        ClickButtonMoreVertical();
        ClickButtonDelete();
        ClickButtonDeleteConfirm();
    }
    public String getSuksesMessageText() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard Menu']")));
        return successMessage.getText();
    }
    public String getErrorMessageText() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']")));
        return errorMessage.getText();
    }

    public String getLevelText(String level) {
        // XPath menggunakan teks yang kita cari
        String xpath = "//h6[text()='" + level + "']";
        
        try {
            // Tunggu sampai elemen terlihat (Visibility)
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return element.getText();
        } catch (Exception e) {
            return "Element tidak ditemukan: " + e.getMessage();
        }
    }

    public String getValidationMessageNama() {
    // Pastikan locator (id:name) benar sesuai inspect element kamu
    WebElement inputNama = driver.findElement(By.id("name"));
    
    JavascriptExecutor js = (JavascriptExecutor) driver;
    // Mengambil pesan validasi langsung dari property internal HTML5
    return (String) js.executeScript("return arguments[0].validationMessage;", inputNama);
    }
    
    public void clearInputNama() {
    WebElement inputNama = driver.findElement(By.id("name"));
    inputNama.sendKeys(Keys.CONTROL + "a");
    inputNama.sendKeys(Keys.BACK_SPACE);
}
}
