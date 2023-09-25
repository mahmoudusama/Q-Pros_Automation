//package features.tests;
//
//import data.loadProperties;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import com.demoblaze.common.helpers.files.pages.AlertJS;
//import com.demoblaze.common.helpers.files.pages.HomePage;
//import com.demoblaze.common.helpers.files.pages.LoginPage;
//import com.demoblaze.common.helpers.files.pages.UserRegistrationPage;
//
//import static org.testng.Assert.assertEquals;
//
//public class UserRegWithDDTAndPropertiesFile extends TestBase{
//    HomePage homePageObject;
//    UserRegistrationPage registerObject;
//    LoginPage loginPageObject;
//    AlertJS alertObject;
//    String userName = loadProperties.userData.getProperty("username");
//    String password = loadProperties.userData.getProperty("password");
//
//    @BeforeMethod
//    public void setup(){
//        homePageObject = new HomePage(driver);
//        registerObject = new UserRegistrationPage(driver);
//        alertObject = new AlertJS(driver);
//        loginPageObject = new LoginPage(driver);
//    }
//
//    @Test(priority = 1, description = "Verify that user can register successfully with a valid data")
//    public void userCanRegisterSuccessfully() throws InterruptedException {
//        homePageObject.openRegistrationPage();
//        registerObject.userRegistration(userName, password);
//        assertEquals(alertObject.siteAlert(driver), "Sign up successful.");
//        alertObject.acceptAlert(driver);
//    }
//
//    @Test(priority = 2, description = "Verify that user can login successfully with a valid data")
//    public void userCanLoginSuccessfully() throws InterruptedException {
//        homePageObject.openLoginPage();
//        loginPageObject.UserLogin(userName, password);
//        assertEquals(homePageObject.welcomeMessage(), "Welcome "+userName);
//    }
//
//
//}
