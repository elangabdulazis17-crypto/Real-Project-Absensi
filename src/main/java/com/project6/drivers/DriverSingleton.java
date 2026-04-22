package com.project6.drivers;

import org.openqa.selenium.WebDriver;

import com.project6.drivers.strategies.DriverStrategies;
import com.project6.drivers.strategies.DriverStrategyImplementor;
import com.project6.utills.Constans;

import java.time.Duration;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(String strategy) {
        String browser = System.getProperty("browser", strategy);
        if (browser == null || browser.isEmpty()) {
            browser = strategy;
        }
        DriverStrategies driverStrategy = new DriverStrategyImplementor().chooseStrategy(browser);
        driver = driverStrategy.setStrategy(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constans.TIMEOUT));

          if (!browser.contains("headless")) {
            driver.manage().window().maximize();
        }
    }
     public static DriverSingleton getInstance(String strategy) {
        if (instance == null) {
            instance = new DriverSingleton(strategy);
        }
        return instance;
    }
     public static WebDriver getDriver() {
        return driver;
    }

    public static void closeObjectInstance() {
        instance = null;
        driver.quit();
    }

}
