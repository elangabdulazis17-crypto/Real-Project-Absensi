package com.project6;

import org.openqa.selenium.WebDriver;

import com.project6.drivers.DriverSingleton;
import com.project6.pages.Login;
import com.project6.utills.Constans;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest 
{
    private static WebDriver driver;
    private static Login loginPage;
    
    public LoginTest() {
        driver = com.project6.drivers.DriverSingleton.getInstance("chrome").getDriver();
        loginPage = new Login(driver);
    }
    @BeforeAll
    public static void setUp() {
        DriverSingleton.getInstance(Constans.CHROME);
        driver = DriverSingleton.getDriver();
        loginPage = new Login(driver);
    }
    @AfterAll
    public static void tearDown() {
        DriverSingleton.closeObjectInstance();
    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(Constans.URL);
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        loginPage.setCredentials("admin@hadir.com", "MagangSQA_JC@123");
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.ClickLogin();
    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        String actualTittle = loginPage.getSuksesMessageText();
        String expectedTittle = "Dashboard Menu";
        assert actualTittle.equals(expectedTittle) : "Expected: " + expectedTittle + ", but got: " + actualTittle;
    }
}
