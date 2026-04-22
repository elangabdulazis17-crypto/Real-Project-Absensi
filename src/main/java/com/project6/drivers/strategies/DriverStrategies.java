package com.project6.drivers.strategies;

import org.openqa.selenium.WebDriver;

public interface DriverStrategies {
 
    WebDriver setStrategy();
    WebDriver setStrategy (String browser);

}
