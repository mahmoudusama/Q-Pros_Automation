package tests;

import data.loadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class CompleteCheckout extends TestBase{
    HomePage homePageObject;
    AlertJS alertObject;
    SearchCategoryPage searchCategoryObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    String productName = "Sony vaio i5";
    String fullName = loadProperties.userData.getProperty("fullname");
    String country = loadProperties.userData.getProperty("country");
    String city = loadProperties.userData.getProperty("city");
    String creditCard = loadProperties.userData.getProperty("creditcard");
    String month = loadProperties.userData.getProperty("month");
    String year = loadProperties.userData.getProperty("year");


    @BeforeMethod
    public void setup(){
        searchCategoryObject = new SearchCategoryPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        alertObject = new AlertJS(driver);
        homePageObject = new HomePage(driver);
        shoppingCartObject = new ShoppingCartPage(driver);
    }

    @Test(testName = "TestCase_1", description = "Verify that the user can complete a checkout for a random product")
    public void completeCheckoutTest() throws InterruptedException {
        searchCategoryObject.chooseCategory("Phones");
        searchCategoryObject.productSelected(productName);
        productDetailsObject.pressOnAddtoCart();
        Thread.sleep(1000);
        assertEquals(alertObject.siteAlert(driver), "Product added");
        alertObject.acceptAlert(driver);
        homePageObject.openCartPage();
        shoppingCartObject.pressPlaceOrder();
        shoppingCartObject.purchaseOrder(fullName, country, city, creditCard, month, year);
        assertEquals(shoppingCartObject.orderPurchasedSuccessfully(),"Thank you for your purchase!");
    }
}
