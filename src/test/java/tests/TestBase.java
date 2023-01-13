package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters(("browser"))
    public void startDriver(@Optional("firefox") String browserName){
        if (browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().to("https://www.demoblaze.com/");
    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
}
