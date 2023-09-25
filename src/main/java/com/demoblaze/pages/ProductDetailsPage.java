package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase{
    private WebDriver driver;
    By productNameSelected = By.xpath("//tbody/tr[1]/td[2]");
    By addToCartBtn = By.linkText("Add to cart");


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressOnAddtoCart(){
        driver.findElement(addToCartBtn).click();
    }

    public String checkProductName(){
        return driver.findElement(productNameSelected).getText();
    }

}
