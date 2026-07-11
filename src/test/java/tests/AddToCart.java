package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class AddToCart extends TestBase {

    HomePage homeObject;
    ProductPage productObject;

    public void initializeObject() {
        homeObject = new HomePage(driver);
        // assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        
        productObject = new ProductPage(driver);
    }

    @Test
    public void VerifyUserCanAddProductToCartWithCorrectDetails() {
        initializeObject();
        homeObject.OpenProductsPage();
        
        // assertEquals(productObject.ProductPageTitle.getText(), "ALL PRODUCTS");  
    
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", productObject.ViewProductBtnForProductOne);

        productObject.UserCanAddProductToCart();
        
        // Assertions for Product One
        assertEquals(productObject.product_One.getText(), "Blue Top");
        assertEquals(productObject.Price_For_proudctOne.getText(), "Rs. 500");
        assertEquals(productObject.Quantity_for_ProductOne.getText(), "1");
        assertEquals(productObject.total_price_for_productOne.getText(), "Rs. 500");
        
        // Assertions for Product Two
        assertEquals(productObject.product_tow.getText(), "Men Tshirt");
        assertEquals(productObject.Price_For_proudctTow.getText(), "Rs. 400");
        assertEquals(productObject.Quantity_for_ProductTow.getText(), "1");
        assertEquals(productObject.total_price_for_productTow.getText(), "Rs. 400");
    }
    
}