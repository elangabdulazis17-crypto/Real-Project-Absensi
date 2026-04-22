package com.project6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (id="email")
    private WebElement emailField; //input[@id='email']


    @FindBy (id="password")
    private WebElement passwordField; //input[@id='password']

    @FindBy (xpath="//button[@type='submit']")
    private WebElement loginButton; //button[@type='submit']

    @FindBy (xpath="//div[@class='alert alert-danger']")
    private WebElement errorMessage; //div[@class='alert alert-danger']

    @FindBy (xpath="//p[text()='Dashboard Menu']")
    private WebElement suksesMessage; //div[@class='MuiBox-root css-16
    
    
    //button[text()="Submit"]
 
    //div[@class='MuiBox-root css-16mw8l2']//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf']

    //p[@class='MuiTypography-root MuiTypography-body1 css-1ar04jk']

    public void setCredentials(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        
    }
    

    public void ClickLogin() {
        loginButton.click();
    }

    public String getSuksesMessageText() {
        return suksesMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }


    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
