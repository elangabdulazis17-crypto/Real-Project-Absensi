package com.project6.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;

public class User {
    
    private WebDriver driver; 
    private WebDriverWait wait;

    public User (WebDriver driver) {
        this.driver = driver; 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath ="//*[text()='Management']")
    private WebElement managementMenu;

    @FindBy (xpath="//p[contains(text(),'User')]")
    private WebElement userMenu;

    @FindBy (xpath="//button[normalize-space()='Export']")
    private WebElement exportButton;

    // Gunakan locator ini secara konsisten
    @FindBy (xpath="(//button[contains(@class,'MuiIconButton-sizeLarge')])[6]")
    private WebElement titikMenu;

    @FindBy (xpath="(//li[@role='menuitem' and contains(., 'Edit')])[3]") 
    private WebElement editMenu;

    @FindBy(xpath = "//input[@name='nik']") 
    private WebElement fieldNIK;

    @FindBy (id="submit")
    private WebElement saveEditMenu;

    @FindBy (xpath="(//input[@id='search'])[1]")
    private WebElement searchField;

    @FindBy (xpath="//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy (xpath="(//h5[contains(@class,'MuiTypography-root')])[3]")
    private WebElement txtSearchName;

    @FindBy (xpath="(//button[contains(@class,'MuiButtonBase-root')])[6]")
    private WebElement filterButton;

    @FindBy (xpath= "//button[contains(.,'Batal')]")
    private WebElement batalButtonFilterUser;

    @FindBy(xpath = "//button[contains(.,'Reset')]")
    private WebElement resetButtonUser;

    // --- METHODS ---

    public void clickManagementMenu() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(managementMenu));
        managementMenu.click();
    }

    public void clickUserMenu() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userMenu));
        userMenu.click();
    }

    public void clickExportButton() {
        exportButton.click();
    }

    public void clickTitikMenu() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        
        // 1. Tunggu elemen hadir di DOM
        WebElement btnTitik = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("(//button[contains(@class,'MuiIconButton-sizeLarge')])[5]")
        ));

        // 2. Scroll ke elemen untuk memastikan tidak terhalang oleh elemen lain (seperti ikon panah)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnTitik);
        
        // 3. Klik menggunakan JS karena sering terhalang ikon panah (chevron)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnTitik);
        
        // 4. Tunggu sampai menu edit benar-benar muncul sebelum lanjut
        wait.until(ExpectedConditions.visibilityOf(editMenu));
        }

    public void clickEditMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Pastikan menu edit bisa diklik
        wait.until(ExpectedConditions.elementToBeClickable(editMenu)).click();
    }

    public void clickSaveEditMenu() {
        saveEditMenu.click();
    }

    public void clearFieldNIK() {
        fieldNIK.clear();
    }

    public void inputSearchName(String searchQuery) {
        searchField.clear();
        searchField.sendKeys(searchQuery);
    }

    public void clickButtonSearch() {
        searchButton.click();
    }

    public String getTxtSearchName() {
        return txtSearchName.getText();
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public void clickBatalButtonFilterUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        batalButtonFilterUser.click();
    }
    public void clickReset() {
    WebElement resetBtn = driver.findElement(By.xpath("//button[contains(.,'Reset')]"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", resetBtn);
    }

    public void clickResetButtonUser() {
        resetButtonUser.click();
    }

    public String getSearchFieldValue() {
        return searchField.getAttribute("value");
    }
}