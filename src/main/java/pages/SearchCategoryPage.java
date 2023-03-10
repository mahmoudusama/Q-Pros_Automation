package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SearchCategoryPage extends PageBase {

    private WebDriver driver;
    By categoriesNav = By.id("cat");
    By listOfPhones = By.linkText("Phones");
    By listOfLaptops = By.linkText("Laptops");
    By listOfMonitors = By.linkText("Monitors");

    public SearchCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void categoriesNavigation() {
        driver.findElement(categoriesNav);
//        clickButton(categoriesNav);
    }

    public void chooseCategory(String categoryName) {
        if (categoryName.equalsIgnoreCase("Phones")) {
            driver.findElement(listOfPhones).click();
        } else if (categoryName.equalsIgnoreCase("Laptops")) {
            driver.findElement(listOfLaptops).click();
        } else if (categoryName.equalsIgnoreCase("Monitors")) {
            driver.findElement(listOfMonitors).click();
        } else {
            assert categoryName.isEmpty() : "Choose from Phones, Laptop or Monitors categories";
        }
    }

    public void productSelected(String productName){
        driver.findElement(By.xpath("//a[normalize-space()='" + productName + "']")).click();
    }


}
