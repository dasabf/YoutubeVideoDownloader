package com.youtube.WebDriverUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFacade {
    private static int TIMEOUT = 10000;
    WebDriver driver;

    public DriverFacade(WebDriver driver){
        this.driver = driver;
    }

    public void clickBtn(By xpath){
        WebElement element = driver.findElement(xpath);
        element.click();
    }
    public void sendKeys(By xpath, String message){
        WebElement element = driver.findElement(xpath);
        element.sendKeys(message);
    }
    public void waitForElement(By xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(TIMEOUT));
        WebElement element = driver.findElement(xpath);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void driverActionClick(By xpath){
        WebElement element = driver.findElement(xpath);
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
    public void destroyBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
