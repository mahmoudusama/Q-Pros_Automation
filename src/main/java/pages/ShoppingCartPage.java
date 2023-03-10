package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageBase {

    private WebDriver driver;

    By placeOrderBtn = By.xpath("//button[normalize-space()='Place Order']");
    By deleteOrderBtn = By.linkText("Delete");
    By getTotalPrice = By.id("totalp");

    private By buyerName = By.id("name");
    private By countryTxt = By.id("country");
    private By cityTxt = By.id("city");
    private By creditCardTxt = By.id("card");
    private By monthTxt = By.id("month");
    private By yearTxt = By.id("year");
    private By purchaseBtn = By.xpath("//button[normalize-space()='Purchase']");

    private By orderPurchasedSucess = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }

    public void chooseDeleteOrder() throws InterruptedException {
        driver.findElement(deleteOrderBtn).click();
        Thread.sleep(2000);
    }

    public void purchaseOrder(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        driver.findElement(buyerName).sendKeys(name);
        driver.findElement(countryTxt).sendKeys(country);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(creditCardTxt).sendKeys(creditCard);
        driver.findElement(monthTxt).sendKeys(month);
        driver.findElement(yearTxt).sendKeys(year);
        driver.findElement(purchaseBtn).click();
        Thread.sleep(1000);
    }

    public String orderTotalPrice()
    {
        String price = driver.findElement(getTotalPrice).getText();
        return price;
    }

    public String orderPurchasedSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(orderPurchasedSucess).getText();
    }
}
