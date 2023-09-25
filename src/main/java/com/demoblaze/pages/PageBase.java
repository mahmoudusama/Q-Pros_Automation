package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase {

    protected static WebDriver driver;

    // create contractor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public PageBase() {
    }

    protected static void clickButton(WebElement button){
        button.click();
    }

    protected static void setTextElementText(WebElement textElement, String value){
        textElement.sendKeys(value);
    }

}
