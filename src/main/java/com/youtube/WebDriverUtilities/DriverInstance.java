package com.youtube.WebDriverUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverInstance {
    private static final String CHROMEPROP = "webdriver.chrome.driver";
    private static String DRIVERLOCATION = "\\WebDriver\\chromedriver.exe";
    private static String HOMEPAGE = "https://en.savefrom.net/360/";

    private WebDriver driver;

    public DriverInstance(String downloadLocation){
        DRIVERLOCATION = System.getProperty("user.dir")+DRIVERLOCATION;
        System.out.println(CHROMEPROP);
        System.out.println(DRIVERLOCATION);
        //System.getProperty(CHROMEPROP, DRIVERLOCATION);
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("download.default_directory", downloadLocation);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.driver = driver;
    }

    public void openHomePage(){
        this.driver.get(HOMEPAGE);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
