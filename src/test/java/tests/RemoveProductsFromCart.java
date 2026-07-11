package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.loginPage;

public class RemoveProductsFromCart extends TestBase {
    
    HomePage homeObject;
    ProductPage productObject;
    CartPage CartObject;
    loginPage loginObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        productObject = new ProductPage(driver);
        CartObject = new CartPage(driver);
        loginObject = new loginPage(driver);
    }

    @Test
    public void testRemoveProductsFromCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        initializeObject();
        
        // Step 1: Navigate to Products Page
        homeObject.OpenProductsPage();
        // assertEquals(productObject.ProductPageTitle.getText(),"ALL PRODUCTS");
        
        // Step 2: Scroll & Add Products to Cart
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", productObject.ViewProductBtnForProductOne);
        productObject.UserCanAddProductToCart();
    
        // Step 3: Remove Products from Cart
        CartObject.ClickOnDeleteProductBtn();
        
        // Step 4: Verify Cart is Empty
        wait.until(ExpectedConditions.visibilityOf(CartObject.ConfirmationCartIsEmptyMessage));
        assertEquals(CartObject.ConfirmationCartIsEmptyMessage.getText(), "Cart is empty!");
    }
    
}
