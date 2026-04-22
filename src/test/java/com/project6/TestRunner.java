package com.project6;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/com/project6/features",
            glue = "com.project6",
            plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests{
    
}
