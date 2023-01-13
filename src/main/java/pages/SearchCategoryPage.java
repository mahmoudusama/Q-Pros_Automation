package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCategoryPage extends PageBase{

    public SearchCategoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(linkText = "Phones")
    WebElement listOfPhones;

    @FindBy(linkText = "Laptops")
    WebElement listOfLaptops;

    @FindBy(linkText = "Monitors")
    WebElement listOfMonitors;

    @FindBy(css="h4.card-title")
    WebElement selectedProduct;

    public void PhonesCategories(){
        clickButton(listOfPhones);
    }

    public void LaptopsCategories(){
        clickButton(listOfLaptops);
    }

    public void MonitorsCategories(){
        clickButton(listOfMonitors);
    }

    public void ProductSelected(String productName){
        clickButton(selectedProduct);
    }


}
