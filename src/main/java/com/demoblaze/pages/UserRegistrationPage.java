package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserRegistrationPage extends PageBase {

    private WebDriver driver;
    By signUserName = By.xpath("//input[@id='sign-username']");
    By passwordTxtBox = By.xpath("//input[@id='sign-password']");
    By signUpBtn = By.xpath("//button[normalize-space()='Sign up']");

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void userRegistration(String userName, String password)
    {
        driver.findElement(signUserName).sendKeys(userName);
        driver.findElement(passwordTxtBox).sendKeys(password);
        driver.findElement(signUpBtn).click();
    }

    public String userSingUpBtn()
    {
        return driver.findElement(signUpBtn).getText();
    }


}
