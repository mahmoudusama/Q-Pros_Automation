package pages;

import com.sun.deploy.config.Platform;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

public class ProductDetailsPage extends PageBase{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2.name")
    public WebElement productNameSelected;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartBtn;

    public void pressOnAddtoCart(){
        clickButton(addToCartBtn);
    }



}
