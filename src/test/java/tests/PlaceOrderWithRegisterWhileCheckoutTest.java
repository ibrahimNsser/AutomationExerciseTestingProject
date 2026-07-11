package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadRrgisterHappyDataExcel;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.RegisterPage;
import pages.loginPage;

public class PlaceOrderWithRegisterWhileCheckoutTest extends TestBase {
    
    HomePage homeObject;
    ProductPage productObject;
    CartPage CartObject;
    RegisterPage RegisterObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        productObject = new ProductPage(driver);
        CartObject = new CartPage(driver);
        RegisterObject = new RegisterPage(driver);
    }

    // ==========================================
    // Data Provider for Register While Checkout
    // ==========================================
    @DataProvider(name = "registerWhileCheckoutData")
    public Object[][] getRegisterWhileCheckoutData() {
        return new Object[][] {
            {
                "ibrahim nasser", "ibrahimnaser553@gamil.com",                           // Initial Signup
                "10203040", "21", "10", "2000", "ibrahim", "nasser", "astra", "India", // Account Info 1
                "cairo", "India", "new cairo", "cairo", "1020", "1025545454",           // Account Info 2
                "very good",                                                            // Order Comment
                "QNP", "11545464565", "312", "12", "26"                                 // Payment Info
            }
        };
    }

    // ==========================================
    // Test Case Execution
    // ==========================================
    @Test(dataProvider = "registerWhileCheckoutData")
    public void testPlaceOrderWithRegisterWhileCheckout(
            String signupName, String signupEmail, String password, String day, String month, String year,
            String firstName, String lastName, String company, String address1, String address2, String country,
            String state, String city, String zipcode, String mobile, String comment,
            String cardName, String cardNumber, String cvc, String expMonth, String expYear) {
        
        initializeObject();
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        
        // Step 1: Navigate to Products & Add to Cart
        homeObject.OpenProductsPage();
        assertEquals(productObject.ProductPageTitle.getText(), "ALL PRODUCTS");
        
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", productObject.ViewProductBtnForProductOne);
        productObject.UserCanAddProductToCart();
        
        // Step 2: Click Proceed to Checkout & Navigate to Register
        CartObject.clickProceedCheckoutAndOpenRegistration();
  
        // Step 3: Register while in checkout flow
        RegisterObject.UseracanRejester(signupName, signupEmail);
        RegisterObject.userCanEnterAccountInformation(password, day, month, year, firstName, lastName, company, address1,
                 address2, country, state, city, zipcode, mobile);
        
        assertEquals(RegisterObject.AcountCreatedSuccessMessage.getText(), "ACCOUNT CREATED!");
        // assertEquals(RegisterObject.LoggedIn_As_Message.getText(),"Logged in as");
     
        // Step 4: Return to Cart & Proceed to Checkout
        homeObject.OpenCartPage();
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