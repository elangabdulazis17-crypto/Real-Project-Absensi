package com.project6.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbsenPoint {
    
    private WebDriver driver; 
    private WebDriverWait wait;

    public AbsenPoint (WebDriver driver) {
        this.driver = driver; 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath ="(//*[text()='Absen Point'])[1]")
    private WebElement absenPointMenu;  

    @FindBy (xpath="//button[contains(.,'Tambahkan')]")
    private WebElement tambahAbsenPointButton;

    @FindBy (xpath="(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall')])[1]")
    private WebElement fieldNama;

    @FindBy (xpath="(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall')])[2]")
    private WebElement fieldLatitude;

    @FindBy (xpath="(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall')])[3]")
    private WebElement fieldLongitude;

    @FindBy (xpath="(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall')])[4]")
    private WebElement fieldRadius;

    @FindBy (xpath="(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall')])[5]")
    private WebElement fieldDescription;

    @FindBy (xpath="(//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium')])[3]")
    private WebElement submitButtonAbsen;

    @FindBy (xpath="(//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textSecondary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textSecondary MuiButton-sizeMedium MuiButton-textSizeMedium')])[1]")
    private WebElement batalButton;

    @FindBy (xpath="(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputSizeSmall')])[1]")
    private WebElement fieldSearchAbsenPoint;

    @FindBy (xpath="//button[contains(text(), 'Search')]")
    private WebElement searchButtonAbsenPoint;

    @FindBy(xpath = "(//h6[text()='DIKA Banjarmasin90'])")
    private WebElement txtSearchNameAbsen;

    @FindBy(xpath = "//button[contains(text(), 'Reset')]")
    private WebElement resetButtonAbsenPoint;


     // --- METHODS ---\

    
    public String getFirstResultNameAbsen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOf(txtSearchNameAbsen)).getText();
    }
    
     public void clickAbsenPointMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(absenPointMenu)).click();
    }

    public void clickTambahAbsenPointMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(tambahAbsenPointButton)).click();
    }

    public void clickfieldName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(fieldNama)).click();
    }

    public void inputNama(String nama) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.visibilityOf(fieldNama)).sendKeys(nama);
    }

    public void inputLatitude(String latitude) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(fieldLatitude)).sendKeys(latitude);
    }

    public void inputLongitude(String longitude) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(fieldLongitude)).sendKeys(longitude);
    }

    public void inputRadius(String radius) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(fieldRadius)).sendKeys(radius);
    }

    public void inputDescription(String description) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(fieldDescription)).sendKeys(description);
    }

    public void clicksubmitButtonAbsen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonAbsen)).click();
    }

        public void clickBatalButton() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(batalButton)).click();
        
        }

        public String getNamaFieldValueAbsen() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            return wait.until(ExpectedConditions.visibilityOf(fieldNama)).getAttribute("value");
        }
        
        public void inputFieldSearchAbsenPoint(String searchQuery) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            By searchInput = By.xpath("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputSizeSmall')])[1]");
            WebElement searchField = wait.until(
                    ExpectedConditions.elementToBeClickable(searchInput));
            searchField.click();
            searchField.clear();
            searchField.sendKeys(searchQuery);
            searchField.sendKeys(Keys.ENTER); // Tekan Enter setelah mengisi input
            }

        public String getSearchFieldValueAbsen() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            return wait.until(ExpectedConditions.visibilityOf(fieldSearchAbsenPoint)).getAttribute("value");
        }

        public void clickSearchButtonAbsenPoint() {
            try {
                Thread.sleep(2000); // Tambahkan delay 2 detik sebelum klik tombol Search
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(ExpectedConditions.elementToBeClickable(searchButtonAbsenPoint)).click();
        }

        public String getResultNameAbsen() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'result-name')]")));
            return resultElement.getText();
    }

    public void clickResetButtonAbsenPoint() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(resetButtonAbsenPoint)).click();   
    }   

    public String getSearchFieldValueAbsenPoint() {
    // Langsung ambil nilainya tanpa nunggu attribute value jadi ""
    return fieldSearchAbsenPoint.getAttribute("value");
    }
}

