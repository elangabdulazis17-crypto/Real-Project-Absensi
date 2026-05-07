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

public class UserMonitoring {
    
    private WebDriver driver; 
    private WebDriverWait wait;

    public UserMonitoring (WebDriver driver) {
        this.driver = driver; 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(.,'User Monitoring')]")
    private WebElement userMonitoringMenu;

    @FindBy(xpath = "//button[contains(@class,'button-add')]")
    private WebElement addMonitorButton;
    
    @FindBy(xpath = "//input[@name='fullname']")
    private WebElement fieldFullName;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@placeholder='Pilih Unit']")
    private WebElement fieldUnit;

    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[6]")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement fieldSearchMonitoring;

    @FindBy(xpath = "(//h6[text()='Gatuso'])")
    private WebElement hasilSearchMonitoring;

    @FindBy(xpath ="(//button[contains(@class,'MuiButtonBase-root')])[6]")
    private WebElement searchMonitoringButtton;

    @FindBy(xpath = "//button[contains(text(), 'Reset')][1]")
    private WebElement resetButtonMonitoring;


    // ===== ACTIONS =====

    public void clickUserMonitoringMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userMonitoringMenu)).click();
    }

    public void clickaddMonitorButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addMonitorButton)).click();
    }   

    public void inputFullName(String fullName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.visibilityOf(fieldFullName)).sendKeys(fullName);
    }


    public void inputEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.visibilityOf(fieldEmail)).sendKeys(email);
    }

    public void inputPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.visibilityOf(fieldPassword)).sendKeys(password);
    }

    //dropdown unit
    public void selectUnit(String unit) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldUnit)).click();

        fieldUnit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        fieldUnit.sendKeys(unit);

        By option = By.xpath("//li[contains(text(),'" + unit + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void clickSearchMonitoring() {
          try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(ExpectedConditions.elementToBeClickable(searchMonitoringButtton)).click();
        }

    public void clickResetButtonMonitoring() {
        wait.until(ExpectedConditions.elementToBeClickable(resetButtonMonitoring)).click();   
    }

    public void inputSearchNameMonitoring(String searchQuery) {
        fieldSearchMonitoring.clear();
        fieldSearchMonitoring.sendKeys(searchQuery);
    }

    public String getSearchFieldValueMonitoring() {
    return fieldSearchMonitoring.getAttribute("value");
    }

    public String getSearchResultText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOf(hasilSearchMonitoring)).getText();
    }
}

