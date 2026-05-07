package com.project6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Unit {
    public Unit (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath ="//p[normalize-space()='Unit']")
    private WebElement unitMenu; 

    @FindBy (xpath= "(//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium button-add')])[1]")
    private WebElement addUnitButton; //button[@type='submit']")

    @FindBy (xpath="//input[@id='name']")
    private WebElement fieldName;

    @FindBy (xpath = "//input[@name='locationType']")
    private WebElement checkboxLocationType;

    @FindBy(xpath = "//input[@id='calendar']") 
    private WebElement fieldCalendar;

    @FindBy(xpath = "//input[@id='unitLeave']")
    private WebElement fieldUnitLeave;

    @FindBy(xpath = "//input[@id='ot_reason']")
    private WebElement fieldOTReason;

    @FindBy (xpath="//input[@id='max_day_ot']")
    private WebElement fieldMaxDayOT;

    @FindBy (xpath="//div[@id='ot_upload']")
    private WebElement fieldOTUpload;

    @FindBy (xpath="(//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium')])[3]")
    private WebElement submitAddUnitButton;

    @FindBy (xpath="//button[normalize-space()='Edit']")
    private WebElement editUnitButton;

    @FindBy (xpath="(//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textSecondary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textSecondary MuiButton-sizeMedium MuiButton-textSizeMedium')])[1]")
    private WebElement batalButtonUnit;

    @FindBy (xpath="(//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall btn-search')])[1]")
    private WebElement searchButtonUnit;

    @FindBy (xpath="(//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textWarning MuiButton-sizeSmall MuiButton-textSizeSmall MuiButton-root MuiButton-text MuiButton-textWarning MuiButton-sizeSmall MuiButton-textSizeSmall btn-reset')])[1]")
    private WebElement resetButtonUnit;

    @FindBy (xpath="(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputSizeSmall')])[1]")
    private WebElement fieldSearchUnit;

    @FindBy (xpath="(//h6[text()='IT Support'])")
    private WebElement firstSearchResultUnit;

    public Unit() {
    }

    public void clickUnitMenu() {
        unitMenu.click();
    }

    public void clickAddUnitButton() {
        addUnitButton.click();
    }

    public void setFieldName(String name) {
        fieldName.sendKeys(name);
    }

    public void clickCheckboxLocationType() {
        checkboxLocationType.click();
    }   

    public void setFieldCalendar(String calendar) {
        fieldCalendar.sendKeys(calendar);
    }

    public void setFieldUnitLeave(String unitLeave) {
        fieldUnitLeave.sendKeys(unitLeave);
    }

    public void setFieldOTReason(String otReason) {
        fieldOTReason.sendKeys(otReason);
    }

    public void setFieldMaxDayOT(String maxDayOT) {
        fieldMaxDayOT.sendKeys(maxDayOT);
    }

    public void setFieldOTUpload(String otUpload) {
        fieldOTUpload.sendKeys(otUpload);
    }

    public void clickSubmitAddUnitButton() {
        submitAddUnitButton.click();
    }

    public void clickEditUnitButton() {
        editUnitButton.click();
    }

    public void clickBatalButtonUnit() {
        batalButtonUnit.click();
    }
    
    public void clickSearchButtonUnit() {
        searchButtonUnit.click();
    }

    public void clickResetButtonUnit() {
        resetButtonUnit.click();
    }

    public void setFieldSearchUnit(String name) {
        fieldSearchUnit.sendKeys(name);
    }
    
    public String getSearchResultNameUnit() {
        return firstSearchResultUnit.getText();
    }
}

