package com.youtube.pages;

import com.youtube.WebDriverUtilities.DriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
       private By linkbox = By.xpath("//input[@id='sf_url']");
       private By searchLink = By.xpath("//button[@id='sf_submit']");
       private By downloadLink = By.xpath("//div[@class='link-box']/div");

       public WebDriver driver;
       public DriverFacade driverFacade;

       public HomePage(WebDriver driver){
           this.driver = driver;
           this.driverFacade = new DriverFacade(this.driver);
       }

       public void sendVideoLink(String url){
              driverFacade.sendKeys(linkbox, url);
       }
       public void clickSearchLink(){
              driverFacade.clickBtn(searchLink);
       }
       public void waitForDownloadLink(){
              driverFacade.waitForElement(downloadLink);
       }
       public void clickDownloadLink(){
              driverFacade.driverActionClick(downloadLink);
       }
       public void closeBrowser() throws InterruptedException {
              driverFacade.destroyBrowser();
       }
}
