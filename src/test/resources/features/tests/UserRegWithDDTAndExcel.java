//package features.tests;
//
//import com.demoblaze.common.helpers.files.pages.AlertJS;
//import com.demoblaze.common.helpers.files.pages.HomePage;
//import com.demoblaze.common.helpers.files.pages.LoginPage;
//import com.demoblaze.common.helpers.files.pages.UserRegistrationPage;
//import data.ExcelReader;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import pages.*;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//
//
//import static org.testng.Assert.assertEquals;
//
//public class UserRegWithDDTAndExcel extends TestBase {
//
//    HomePage homePageObject;
//    UserRegistrationPage registerObject;
//    LoginPage loginPageObject;
//    AlertJS alertObject;
//
//    @BeforeMethod
//    public void setup(){
//        homePageObject = new HomePage(driver);
//        registerObject = new UserRegistrationPage(driver);
//        alertObject = new AlertJS(driver);
//        loginPageObject = new LoginPage(driver);
//    }
//
//    @DataProvider(name = "testData")
//    public Object[][] userRegisterData(Method testMethod) throws IOException {
//        String testCaseName = testMethod.getName();
//        ExcelReader ER = new ExcelReader();
//        return ER.getTestData("Registration_TD", testCaseName);
//    }
//
//
//    @Test(dataProvider = "testData", testName = "TestCase_1", description = "Test to verify that user can register successfully with correct data")
//    public void TestCase_1(String userName, String password) throws InterruptedException {
//        homePageObject.openRegistrationPage();
//        registerObject.userRegistration(userName, password);
//        assertEquals(alertObject.siteAlert(driver), "Sign up successful.");
//    }
//
//    @Test(dataProvider = "testData", testName = "TestCase_2", description = "Test that user cannot register without entering a password")
//    public void TestCase_2(String userName, String password) throws InterruptedException {
//        homePageObject.openRegistrationPage();
//        registerObject.userRegistration(userName, password);
//        assertEquals(alertObject.siteAlert(driver), "Please fill out Username and Password.");
//    }
//
//    @Test(dataProvider = "testData", testName = "TestCase_3", description = "Test that user cannot register without entering a username")
//    public void TestCase_3(String userName, String password) throws InterruptedException {
//        homePageObject.openRegistrationPage();
//        registerObject.userRegistration(userName, password);
//        assertEquals(alertObject.siteAlert(driver), "Please fill out Username and Password.");
//    }
//
//
//    @Test(dataProvider = "testData", testName = "TestCase_4", description = "Test that user cannot register with an existing username.")
//    public void TestCase_4(String userName, String password) throws InterruptedException {
//        homePageObject.openRegistrationPage();
//        registerObject.userRegistration(userName, password);
//        assertEquals(alertObject.siteAlert(driver), "This user already exist.");
//    }
//
//
//    @Test(dataProvider = "testData", testName = "TestCase_5", description = "Test that user can login successfully with correct data")
//    public void TestCase_5(String userName, String password) throws InterruptedException {
//        homePageObject.openLoginPage();
//        loginPageObject.UserLogin(userName, password);
//        Thread.sleep(2000);
//        assertEquals(homePageObject.welcomeMessage(), "Welcome " + userName);
//    }
//
//    @Test(dataProvider = "testData", testName = "TestCase_6", description = "Test that user cannot login without entering a username")
//    public void TestCase_6(String userName, String password) throws InterruptedException {
//        homePageObject.openLoginPage();
//        loginPageObject.UserLogin(userName, password);
//        Thread.sleep(2000);
//        assertEquals(alertObject.siteAlert(driver),
//                "Please fill out Username and Password.");
//    }
//
//    @Test(dataProvider = "testData", testName = "TestCase_7", description = "Test that user cannot login without entering a password")
//    public void TestCase_7(String userName, String password) throws InterruptedException {
//        homePageObject.openLoginPage();
//        loginPageObject.UserLogin(userName, password);
//        Thread.sleep(2000);
//        assertEquals(alertObject.siteAlert(driver),
//                "Please fill out Username and Password.");
//    }
//
//    @Test(dataProvider = "testData", testName = "TestCase_8", description = "Test that user cannot login with unregistered data")
//    public void TestCase_8(String userName, String password) throws InterruptedException {
//        homePageObject.openLoginPage();
//        loginPageObject.UserLogin(userName, password);
//        Thread.sleep(2000);
//        assertEquals(alertObject.siteAlert(driver),
//                "User does not exist.");
//    }
//
//    @Test(dataProvider = "testData", testName = "TestCase_9", description = "Test that user cannot login with correct username and wrong password")
//    public void TestCase_9(String userName, String password) throws InterruptedException {
//        homePageObject.openLoginPage();
//        loginPageObject.UserLogin(userName, password);
//        Thread.sleep(2000);
//        assertEquals(alertObject.siteAlert(driver),
//                "Wrong password.");
//    }
//}
