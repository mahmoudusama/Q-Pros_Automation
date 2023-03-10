package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends PageBase{


    private WebDriver driver;
    By registerLink = By.linkText("Sign up");
    By loginLink = By.xpath("//a[@id='login2']");
    By logoutLink = By.linkText("Log out");
    By cartLink = By.linkText("Cart");
    public By welcome = By.xpath("//a[@id='nameofuser']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRegistrationPage(){
        driver.findElement(registerLink).click();
    }

    public void openLoginPage(){
        driver.findElement(loginLink).click();
    }

    public void openLogoutPage(){
        driver.findElement(logoutLink).click();
    }

    public void openCartPage(){
        driver.findElement(cartLink).click();
    }

    public String welcomeMessage() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(welcome).getText();
    }

}
