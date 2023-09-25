package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;

public class AlertJS extends PageBase{

    private WebDriver driver;

    public AlertJS(WebDriver driver) {
        this.driver = driver;
    }

    public String siteAlert(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
}
