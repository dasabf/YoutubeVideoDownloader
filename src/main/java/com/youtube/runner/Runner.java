package com.youtube.runner;

import com.youtube.WebDriverUtilities.DriverInstance;
import com.youtube.pages.HomePage;

public class Runner {
    private HomePage homePage;
    private DriverInstance driverInstance;

    public Runner(String downloadLocation){
        this.driverInstance = new DriverInstance(downloadLocation);
        this.homePage = new HomePage(this.driverInstance.getDriver());
    }

    public void runProcess(String url) throws InterruptedException {
         driverInstance.openHomePage();
         homePage.sendVideoLink(url);
         homePage.clickSearchLink();
         Thread.sleep(5000);
         homePage.clickDownloadLink();
         homePage.closeBrowser();
    }
}
