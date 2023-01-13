package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertJS extends PageBase{

    public AlertJS(WebDriver driver) {
        super(driver);
    }

    public String productAddedAlert(){
        Alert alert = driver.switchTo().alert();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage= alert.getText();
        System.out.println(alertMessage);
        return alertMessage;
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
}
