package com.project6.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements DriverStrategies {

    @Override
    public WebDriver setStrategy() {
        return setStrategy("firefox"); 
    }

    @Override
    public WebDriver setStrategy(String browser) {
        FirefoxOptions options = new FirefoxOptions();
        if (browser.equalsIgnoreCase("firefox")) {
            
        }
        return new FirefoxDriver(options); 
    }
    
}
