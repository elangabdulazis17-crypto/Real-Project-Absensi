package com.project6.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategies{
    @Override
    public WebDriver setStrategy() {
        return setStrategy("chrome");
    }

    @Override
    public WebDriver setStrategy(String browser) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("excludeSwitches",
                new java.util.ArrayList<>(java.util.Arrays.asList("enable-automation")));
        
        if (browser.contains("headless")) {
            options.addArguments("--headless=new");
        }
        return new org.openqa.selenium.chrome.ChromeDriver(options);

    }

    

}

