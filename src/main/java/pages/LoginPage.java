package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="loginusername")
    WebElement loginUserNameTxtBox;

    @FindBy(id = "loginpassword")
    WebElement passwordTxtBox;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginBtn;

    public void UserLogin(String userName, String password){
        setTextElementText(loginUserNameTxtBox, userName);
        setTextElementText(passwordTxtBox,password);
        clickButton(loginBtn);
    }



}
