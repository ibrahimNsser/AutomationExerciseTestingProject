package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class SubscriptionINCartPage extends TestBase {
    
    HomePage homeObject;
    CartPage cartobject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver); 
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        cartobject = new CartPage(driver);
    }
    
    @DataProvider(name = "SusbscribtionData")
    public Object[][] SusbscribtionData() {
        Object[][] Testdata = {
            {"fago102030@gmail.com"}
        };
        return Testdata;
    }
    
    @Test(dataProvider = "SusbscribtionData")
    public void UsercanSusbscribeWithValidEmail(String email) throws InterruptedException {
        initializeObject();
        
        // Step 1: Open Cart Page & Verify Page Title
        homeObject.OpenCartPage();
        assertEquals(cartobject.CartPageTitle.getText(), "Cart is empty!");
        
        // Step 2: Verify Subscription Section Title
        assertEquals(cartobject.SubscriptionTitle.getText(), "SUBSCRIPTION");
        
        // Step 3: Perform Subscription Action & Verify Success Message
        cartobject.UsercanSusbscribe(email);
        assertEquals(homeObject.SubscriptionSuccessMessage.getText(), "You have been successfully subscribed!");
    }
    
}