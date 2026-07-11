package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;

public class SubscriptionINHomePage extends TestBase {
    
    HomePage homeObject;

    public void initializeObject() {
        homeObject = new HomePage(driver); 
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
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
        
        // Step 1: Scroll down smoothly to the Subscription input field in Footer
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", homeObject.susbscribe_email_txt);
        
        // Step 2: Verify Subscription Section Title
        assertEquals(homeObject.SubscriptionTitle.getText(), "SUBSCRIPTION");
        Thread.sleep(3000);
        
        // Step 3: Perform Subscription Action & Verify Success Message
        homeObject.UsercanSusbscribe(email);
        assertEquals(homeObject.SubscriptionSuccessMessage.getText(), "You have been successfully subscribed!");
    }
    
}
