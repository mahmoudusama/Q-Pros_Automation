package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(linkText="Sign up")
    WebElement registerLink;

    @FindBy(xpath = "//a[@id='login2']")
    WebElement loginLink;

    @FindBy(linkText="Log out")
    WebElement logoutLink;

    @FindBy(xpath = "//a[@id='nameofuser']")
    public WebElement welcomeMessage;

    @FindBy(linkText="Cart")
    WebElement cartLink;


    public void openRegistrationPage(){
        clickButton(registerLink);
    }

    public void openLoginPage(){
        clickButton(loginLink);
    }

    public void openLogoutPage(){
        clickButton(logoutLink);
    }

    public void openCartPage(){
        clickButton(cartLink);
    }
}
