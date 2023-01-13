package pages;

import javafx.scene.input.InputMethodTextRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

    public InputMethodTextRun successMessage;

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='sign-username']")
    WebElement signUserName;

    @FindBy(xpath = "//input[@id='sign-password']")
    WebElement passwordTxtBox;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signUpBtn;
    

    public void userRegistration(String userName, String password)
    {
        setTextElementText(signUserName, userName);
        setTextElementText(passwordTxtBox, password);
        clickButton(signUpBtn);
    }

}
