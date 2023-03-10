package pages;

import com.sun.deploy.config.Platform;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

public class ProductDetailsPage extends PageBase{
    private WebDriver driver;
    By productNameSelected = By.xpath("//tbody/tr[1]/td[2]");
    By addToCartBtn = By.linkText("Add to cart");


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressOnAddtoCart(){
        driver.findElement(addToCartBtn).click();
    }

    public String checkProductName(){
        return driver.findElement(productNameSelected).getText();
    }

}
