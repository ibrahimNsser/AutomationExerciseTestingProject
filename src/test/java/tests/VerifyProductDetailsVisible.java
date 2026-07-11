package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import pages.pagebase;

public class VerifyProductDetailsVisible extends TestBase {
    
    HomePage homeObject;
    ProductPage productobject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        
        productobject = new ProductPage(driver);
    }

    @Test
    public void testVerifyProductDetailsVisible() {
        initializeObject();
        
        // Step 1: Navigate to Products Page
        homeObject.OpenProductsPage();
        // assertEquals(productobject.ProductPageTitle.getText(),"ALL PRODUCTS");
        
        // Step 2: Scroll to Product & Click View Product Button
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", productobject.ViewProductBtn);
        productobject.clickOnViewProductBtn();
        // assertTrue(productobject.AddToCartBtn.isDisplayed());
        
        // Step 3: Verify Product Details (Name, Category, Price, Availability, Condition, Brand)
        assertEquals(productobject.ProductNameTxt.getText(), "Blue Top");
        assertEquals(productobject.CategoryNameTxt.getText(), "Category: Women > Tops");
        assertEquals(productobject.priceTxt.getText(), "Rs. 500");
        assertEquals(productobject.AvailabilityTxt.getText(), "Availability:");
        assertEquals(productobject.ConditionTxt.getText(), "Condition:"); 
        assertEquals(productobject.BrandTxt.getText(), "Brand:");
    }
    
}
