package tests;

import data.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CategoriesNavigationTests extends TestBase {

    SearchCategoryPage searchCategoryObject;

    @BeforeMethod
    public void setup(){
        searchCategoryObject = new SearchCategoryPage(driver);
    }

    @Test(testName = "TestCase_1", description = "Test to verify that the three Categories is presented")
    public void TestCase_1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cat")));
        searchCategoryObject.categoriesNavigation();
        List<WebElement> categoryElements = driver.findElements(By.id("itemc"));
        assertEquals(categoryElements.size(), 3, "Expected 3 categories to be present");
    }


    @Test(testName = "TestCase_2", description = "Test to verify that the three categories that is presented are (Phones, Laptops and Monitors)")
    public void TestCase_2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cat")));
        List<WebElement> categoryElements = driver.findElements(By.id("itemc"));
        int index = 2;
        for (WebElement categoryElement : categoryElements) {
            String categoryName = categoryElement.getText();
            categoryElement.click();
            WebElement activeCategoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='contcont']//a[" + index + "]")));
            assertEquals(activeCategoryElement.getText(), categoryName, "Expected the active category to be " + categoryName);
            index = index + 1;
        }
    }

    @Test(testName = "TestCase_3", description = "Test to verify that the only phones products present when click on Phones category")
    public void TestCase_3 () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Phones")));
        searchCategoryObject.chooseCategory("Phones");
        List<WebElement> products = driver.findElements(By.className("col-lg-4.col-md-6.mb-4"));
        int phonesIndex = 1;
        for (WebElement product : products) {
            List<WebElement> categories = product.findElements(By.xpath("body > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(" + phonesIndex + ")"));
            boolean containsPhones = false;
            for (WebElement category : categories) {
                if (category.getText().contains("Phones")) {
                    containsPhones = true;
                    break;
                }
            }
            phonesIndex = phonesIndex + 1;
            Assert.assertTrue(containsPhones, "Product does not belong to the Phones category: " + product.getText());
        }
    }

    @Test(testName = "TestCase_4", description = "Test to verify that the only Laptops products present when click on Laptops category")
    public void TestCase_4 () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Laptops")));
        searchCategoryObject.chooseCategory("Laptops");
        List<WebElement> products = driver.findElements(By.className("col-lg-4.col-md-6.mb-4"));
        int laptopIndex = 1;
        for (WebElement product : products) {
            List<WebElement> categories = product.findElements(By.xpath("body > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(" + laptopIndex + ")"));
            boolean containsPhones = false;
            for (WebElement category : categories) {
                if (category.getText().contains("Laptops")) {
                    containsPhones = true;
                    break;
                }
            }
            laptopIndex = laptopIndex + 1;
            Assert.assertTrue(containsPhones, "Product does not belong to the Phones category: " + product.getText());
        }
    }

    @Test(testName = "TestCase_5", description = "Test to verify that the only Monitors products present when click on Monitors category")
    public void TestCase_5 () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Monitors")));
        searchCategoryObject.chooseCategory("Monitors");
        List<WebElement> products = driver.findElements(By.className("col-lg-4.col-md-6.mb-4"));
        int monitorIndex = 1;
        for (WebElement product : products) {
            List<WebElement> categories = product.findElements(By.xpath("body > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(" + monitorIndex + ")"));
            boolean containsPhones = false;
            for (WebElement category : categories) {
                if (category.getText().contains("Monitors")) {
                    containsPhones = true;
                    break;
                }
            }
            monitorIndex = monitorIndex + 1;
            Assert.assertTrue(containsPhones, "Product does not belong to the Phones category: " + product.getText());
        }
    }
}
