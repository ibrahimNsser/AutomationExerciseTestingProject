package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.RegisterPage;
import pages.loginPage;

public class PlaceOrderLoginBeforeCheckout extends TestBase {
    
    HomePage homeObject;
    ProductPage productObject;
    CartPage CartObject;
    RegisterPage RegisterObject;
    loginPage loginObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        productObject = new ProductPage(driver);
        CartObject = new CartPage(driver);
        RegisterObject = new RegisterPage(driver);
        loginObject = new loginPage(driver);
    }

    // ==========================================
    // Data Provider for Order Placement Details
    // ==========================================
    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutData() {
        return new Object[][] {
            { 
                "ibrahim10@gamil.com", "abc@123",   // Login Credentials
                "very good",                          // Order Comment
                "QNP", "11545464565", "312", "12", "26" // Payment Info (Card Name, Number, CVC, Month, Year)
            }
        };
    }

    // ==========================================
    // Test Case Execution
    // ==========================================
    @Test(dataProvider = "checkoutData")
    public void testPlaceOrderLoginBeforeCheckout(String email, String password, String comment, 
            String cardName, String cardNumber, String cvc, String expMonth, String expYear) {
        
        initializeObject();
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        
        // Step 1: Login
        homeObject.OpenloginPage();
        loginObject.UserCanLogin(email, password);
        
        // Step 2: Navigate to Products
        homeObject.OpenProductsPage();
        assertEquals(productObject.ProductPageTitle.getText(), "FEATURES ITEMS");
        
        // Step 3: Scroll & Add Products to Cart
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", productObject.ViewProductBtnForProductOne);
        productObject.UserCanAddProductToCart();
            
        // Step 4: Checkout Navigation
        CartObject.ProceedToCheckoutBtn.click();
       
        // Step 5: Verify Product One Details
        assertEquals(productObject.product_One.getText(), "Blue Top");
        assertEquals(productObject.Price_For_proudctOne.getText(), "Rs. 500");
        assertEquals(productObject.Quantity_for_ProductOne.getText(), "1");
        assertEquals(productObject.total_price_for_productOne.getText(), "Rs. 500");
            
        // Step 6: Verify Product Two Details
        assertEquals(productObject.product_tow.getText(), "Men Tshirt");
        assertEquals(productObject.Price_For_proudctTow.getText(), "Rs. 400");
        assertEquals(productObject.Quantity_for_ProductTow.getText(), "1");
        assertEquals(productObject.total_price_for_productTow.getText(), "Rs. 400");
            
        // Step 7: Payment and Order Confirmation
        CartObject.checkoutAndPayWithExistingAccount(comment, cardName, cardNumber, cvc, expMonth, expYear);
        assertEquals(CartObject.OrderPlacedMessage.getText(), "ORDER PLACED!");
            
        // Step 8: Clean up & Delete Account
        CartObject.ContinueBtn.click();
        RegisterObject.clickONDeleteAccountBtn();
        assertEquals(RegisterObject.AccountDeletedMassege.getText(), "ACCOUNT DELETED!");
        RegisterObject.clickONContinueBtn();
    }
    
}