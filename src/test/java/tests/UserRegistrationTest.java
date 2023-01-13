package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import static org.testng.Assert.*;

public class UserRegistrationTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;

    LoginPage loginPageObject;

    String userName = "Mahmoud230";

    String password = "12345678";


    @Test(priority = 1)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(userName, password);
        //Assert.assertTrue(registerObject.successMessage.getText().contains("Sign up successful."));
    }

    @Test(priority = 2)
    public void userCanLoginSuccessfully(){
        homeObject.openLoginPage();
        loginPageObject = new LoginPage(driver);
        loginPageObject.UserLogin(userName, password);
        //Assert.assertEquals(registerObject.logoutLink.getText(), "Log out");
    }


}
