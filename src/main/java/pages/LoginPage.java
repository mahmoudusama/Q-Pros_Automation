package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    private WebDriver driver;

    By loginUserNameTxtBox = By.xpath("//input[@id='loginusername']");
    By passwordTxtBox = By.xpath("//input[@id='loginpassword']");
    By loginBtn = By.xpath("//button[contains(text(),'Log in')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void UserLogin(String userName, String password){
        driver.findElement(loginUserNameTxtBox).sendKeys(userName);
        driver.findElement(passwordTxtBox).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

}
