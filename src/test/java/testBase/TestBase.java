package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import java.time.Duration;

//public class TestBase extends AbstractTestNGCucumberTests {
public class TestBase{
    public static WebDriver driver;

    @BeforeMethod
    @Parameters(("browser"))
    public void startDriver(@Optional("chrome") String browserName){
        if (browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.navigate().to("https://www.demoblaze.com/");
    }

    @Test
    public void testDriver() {
        // Simple test to check if the driver is running successfully
        WebElement signUpLink = driver.findElement(By.linkText("Sign up"));
        signUpLink.click();

        WebElement usernameField = driver.findElement(By.id("sign-username"));
        usernameField.sendKeys("testuser");

        WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys("password123");

        WebElement signUpButton = driver.findElement(By.className("btn-signup"));
        signUpButton.click();

        // You can add more verifications or interactions as needed
    }

    @AfterMethod
    public void stopDriver()
    {
        driver.quit();
    }

}
