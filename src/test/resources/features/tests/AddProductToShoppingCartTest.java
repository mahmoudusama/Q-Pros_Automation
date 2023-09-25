//package features.tests;
//
//import com.demoblaze.common.helpers.files.pages.*;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.*;
//
//import static org.testng.Assert.*;
//
//public class AddProductToShoppingCartTest extends TestBase{
//
//    HomePage homePageObject;
//    AlertJS alertObject;
//    SearchCategoryPage searchCategoryObject;
//    ProductDetailsPage productDetailsObject;
//    ShoppingCartPage shoppingCartObject;
//    String productName = "Samsung galaxy s6";
//
//    @BeforeMethod
//    public void setup(){
//        searchCategoryObject = new SearchCategoryPage(driver);
//        productDetailsObject = new ProductDetailsPage(driver);
//        alertObject = new AlertJS(driver);
//        homePageObject = new HomePage(driver);
//        shoppingCartObject = new ShoppingCartPage(driver);
//    }
//
//    @Test(description = "Verify that the user can remove any item from Cart")
//    public void userCanRemoveItemFromCart() throws InterruptedException {
//        searchCategoryObject.chooseCategory("Phones");
//        searchCategoryObject.productSelected(productName);
//        productDetailsObject.pressOnAddtoCart();
//        Thread.sleep(1000);
//        assertEquals(alertObject.siteAlert(driver), "Product added");
//        alertObject.acceptAlert(driver);
//        homePageObject.openCartPage();
//        shoppingCartObject.chooseDeleteOrder();
//        shoppingCartObject.orderTotalPrice();
//        assert(shoppingCartObject.orderTotalPrice().isEmpty());
//    }
//}
