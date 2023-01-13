package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchCategoryPage;

public class SearchProductTest extends TestBase {

    String productName = "Samsung galaxy s6";
    SearchCategoryPage searchCategoryObject;
    ProductDetailsPage productDetailsObject;

    @Test
    public void UserCanSelectProduct()
    {
        //searchCategoryObject = new SearchCategoryPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchCategoryObject.PhonesCategories();
        searchCategoryObject.ProductSelected(productName);
        Assert.assertTrue(productDetailsObject.productNameSelected.getText().equalsIgnoreCase(productName));

    }

}
