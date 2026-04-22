package com.project6.drivers.strategies;

public class DriverStrategyImplementor {

    public DriverStrategies chooseStrategy(String strategy) {
        switch (strategy) {
            case "chrome":
                return new Chrome();
            case "firefox":
                return new Firefox();
            default:
                return null;
        }
    }
}