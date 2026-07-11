package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class ViewCartBrandProducts extends TestBase {
    
    HomePage homeObject;
    ProductPage productObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        productObject = new ProductPage(driver);
    }

    @Test
    public void testViewCartBrandProducts() {
        initializeObject();
        
        // Step 1: Navigate to Products Page
        homeObject.OpenProductsPage();
        
        // Step 2: Click on Polo Brand & Verify the Page Title
        productObject.clickOnPoloBrandBtn();
        assertEquals(productObject.PoloBrandProductsTitle.getText(), "Polo");
        
        // Step 3: Click on H&M Brand & Verify the Page Title
        productObject.clickOnHMBrandBtn();
        assertEquals(productObject.HmBrandProductsTitle.getText(), "H&M");
    }
    
}