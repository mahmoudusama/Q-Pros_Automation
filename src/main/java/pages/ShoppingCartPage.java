package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Place Order")
    WebElement placeOrderBtn;

    @FindBy(linkText = "Delete")
    WebElement deleteOrderBtn;

    @FindBy(id = "totalp")
    WebElement totalPrice;

    public void pressPlaceOrder() {
        clickButton(placeOrderBtn);
    }

    public void chooseDeleteOrder() {
        clickButton(deleteOrderBtn);
    }


}
