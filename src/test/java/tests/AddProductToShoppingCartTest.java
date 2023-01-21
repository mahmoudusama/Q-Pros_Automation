package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class AddProductToShoppingCartTest extends TestBase{

    HomePage homePageObject;
    AlertJS alertObject;
    SearchCategoryPage searchCategoryObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    String productName = "Samsung galaxy s6";

    @Test(priority = 1)
    public void UserCanSelectProduct()
    {
        searchCategoryObject = new SearchCategoryPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchCategoryObject.PhonesCategories();
        searchCategoryObject.ProductSelected(productName);
        Assert.assertTrue(productDetailsObject.productNameSelected.getText().contains(productName));
    }

    @Test(priority = 2)
    public void UserCanAddProductToShoppingCart() throws InterruptedException {
        productDetailsObject = new ProductDetailsPage(driver);
        alertObject = new AlertJS(driver);
        productDetailsObject.pressOnAddtoCart();
        Thread.sleep(1000);
        assertEquals(alertObject.siteAlert(driver), "Product added");
        alertObject.acceptAlert(driver);

    }

    @Test(priority = 3)
    public void UserCanRemoveProductFromCart(){
        homePageObject = new HomePage(driver);
        homePageObject.openCartPage();
        shoppingCartObject = new ShoppingCartPage(driver);
        shoppingCartObject.chooseDeleteOrder();

    }




}
