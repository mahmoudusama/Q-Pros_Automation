package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.*;
import testBase.TestBase;
import com.demoblaze.pages.*;

public class addrandomproduct extends TestBase {

    HomePage homePageObject;
    AlertJS alertObject;
    SearchCategoryPage SearchCatObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage ShoppingCartObject;

    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homePageObject = new HomePage(driver);
    }

    @When("the user goes to {string} category")
    public void the_user_goes_to_category(String categoryName) throws InterruptedException {
        SearchCatObject = new SearchCategoryPage(driver);
        SearchCatObject.chooseCategory(categoryName);
        Thread.sleep(2000);
    }

    @And("choose {string}")
    public void choose(String productName){
        SearchCatObject = new SearchCategoryPage(driver);
        SearchCatObject.productSelected(productName);
    }

    @And("Add the product to Cart")
    public void add_the_product_to_cart() throws InterruptedException {
        productDetailsObject = new ProductDetailsPage(driver);
        Thread.sleep(1000);
        productDetailsObject.pressOnAddtoCart();
        alertObject = new AlertJS(driver);
        assertEquals(alertObject.siteAlert(driver), "Product added");
        alertObject.acceptAlert(driver);
    }

    @Then("The {string} product displayed successfully in cart")
    public void theProductDisplayedSuccessfullyInCart(String productName) {
        homePageObject = new HomePage(driver);
        homePageObject.openCartPage();
        ShoppingCartObject = new ShoppingCartPage(driver);
        assertEquals(productDetailsObject.checkProductName(), productName);
    }
}
