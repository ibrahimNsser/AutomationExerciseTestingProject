package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class VerifyProductQuantityInCart extends TestBase {
    
    HomePage homeObject;
    ProductPage ProductObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        // assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        ProductObject = new ProductPage(driver);
    }

    @Test
    public void UserCanVerifyProductQuantityInCart() {
        initializeObject();
        
        // Step 1: Navigate to Products Page
        homeObject.OpenProductsPage();
        
        // Step 2: Scroll to the targeted product
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", ProductObject.ViewProductBtnForProductOne);
            
        // Step 3: Perform Action to adjust and verify quantity in cart
        ProductObject.VerifyProductQuantityInCart();
            
        // Step 4: Assert that the Product Quantity matches the expected value
        assertEquals(ProductObject.Quantity_for_ProductOne.getText(), "4");
    }
    
}