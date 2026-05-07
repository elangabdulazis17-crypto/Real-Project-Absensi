package com.project6.pages;

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

public class Divisi {
    private WebDriver driver;
    private WebDriverWait wait;

    public Divisi( WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Management']")
    private WebElement MenuManagement;

    @FindBy(xpath = "(//p[text()='Divisi'])[1]")
    private WebElement MenuDivisi;

    @FindBy(xpath = "//button[text()='Tambahkan']")
    private WebElement tambahButtonX;

    @FindBy(xpath = "//input[@id='name']") // Menggunakan atribut id)
    private WebElement InputNamaDivisi;

    @FindBy(xpath = "//button[text()='Tambah']")
    private WebElement SubmitTambahDivisi;

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

    @FindBy(xpath = "//button[text()='Batal']")
    private WebElement ButtonBatalDivisi;

     public void ClickMenuManagementDivisi() {
        MenuManagement.click();
    }
    public void ClickMenuDivisi() {
        MenuDivisi.click();
    }
    public void ClickButtonTambahkanDivisi() {
        try{
            Thread .sleep(20000); // Tunggu 2 detik untuk memastikan halaman sudah stabil
            System.out.println("Mencoba klik tombol 'Tambahkan'..." + tambahButtonX);
        wait.until(ExpectedConditions.elementToBeClickable(tambahButtonX)).click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking 'Tambahkan' button: " + e.getMessage());
        }
    }

    public void setInputNamaDivisi(String nama) {
        InputNamaDivisi.clear();
        InputNamaDivisi.sendKeys(nama);
    }
    public void ClickButtonTambahDivisi() {
        wait.until(ExpectedConditions.elementToBeClickable(SubmitTambahDivisi)).click();
    }
    public void ClickButtonMoreVerticalDivisi() {
        ButtonMoreVerticalDivisi.click();
    }
    public void ClickButtonEditDivisi() {
        ButtonEditDivisi.click();
    }
    public void ClickButtonSimpanDivisi() {
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
    
    // 3. Gunakan cara alternatif untuk membersihkan teks jika clear() gagal
    InputSearchDivisi.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
    
    InputSearchDivisi.clear();
    // 4. Baru masukkan nama divisi
    InputSearchDivisi.sendKeys(nama);
    
    // 5. Tambahkan Enter untuk trigger pencarian
    InputSearchDivisi.sendKeys(Keys.ENTER);
    }
    public void ClickButtonSearchDivisi() {
        ButtonSearchDivisi.click();
    }
    public void ClickButtonResetDivisi() {
        ButtonResetDivisi.click();
    }
    public void ClickButtonBatalDivisi() {
        ButtonBatalDivisi.click();
    }

    public void AddDivisi(String nama) {
        setInputNamaDivisi(nama);
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
        ClickButtonTambahDivisi();
    }
    public void EditDivisi(String namaBaru) {
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        ClickButtonMoreVerticalDivisi();
        ClickButtonEditDivisi();
        setInputNamaDivisi(namaBaru);
        ClickButtonSimpanDivisi();
    }
    public void DeleteDivisi(String search) {
        setInputSearchDivisi(search);
        ClickButtonSearchDivisi();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        ClickButtonMoreVerticalDivisi();
        ClickButtonDeleteDivisi();
        ClickButtonDeleteConfirmDivisi();
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
    public void clearInputNameDivisi() {
    WebElement inputNama = driver.findElement(By.id("name"));
    inputNama.sendKeys(Keys.CONTROL + "a");
    inputNama.sendKeys(Keys.BACK_SPACE);
    }

    public String getDataDivisi() {
        try {
            WebElement dataDivisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='13']")));
            return dataDivisi.getText();
        } catch (Exception e) {
            return null; // Jika data tidak ditemukan, kembalikan null
        }
    }
        public String getValidationMessageNamaDivisi() {
        // Pastikan locator (id:name) benar sesuai inspect element kamu
        WebElement inputNama = driver.findElement(By.id("name"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Mengambil pesan validasi langsung dari property internal HTML5
        return (String) js.executeScript("return arguments[0].validationMessage;", inputNama);
        }

    public void clickMenuWithWait(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // Menunggu hingga loading/overlay hilang
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiDialog-container")));
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

     public void clickSimpanNegatif() {
    // Cukup tunggu tombol bisa diklik, jangan tunggu modal hilang
    wait.until(ExpectedConditions.elementToBeClickable(ButtonSimpanDivisi)).click();
    }
    public void editNamaDivisiKosong() {
    WebElement input = wait.until(ExpectedConditions.visibilityOf(InputNamaDivisi));
    // Kosongkan input
    input.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
    
    // Panggil method klik yang tidak menunggu modal hilang
    clickSimpanNegatif(); 
    
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
