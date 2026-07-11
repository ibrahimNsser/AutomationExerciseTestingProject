package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.loginPage;

public class ViewCategoryProducts extends TestBase {
    
    HomePage homeObject;
    ProductPage productObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        productObject = new ProductPage(driver);
    }

    @Test
    public void TestViewCategoryProducts() {
        initializeObject();
        
        // Step 1: Scroll smoothly down to the Women Category button on Home Page
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", homeObject.WomenCategoryBtn);
        
        // Step 2: Click on Women Dress Category & Verify Page Title
        homeObject.clickOnWomenDressCategory();
        assertEquals(homeObject.WomenDressProductsTitle.getText(), "WOMEN - DRESS PRODUCTS");
        
        // Step 3: Click on Men T-shirts Category & Verify Page Title
        homeObject.clickOnMenTshirtsCategory();
        assertEquals(homeObject.MenTshirtsProductsTitle.getText(), "MEN - TSHIRTS PRODUCTS");
    }
    
}
