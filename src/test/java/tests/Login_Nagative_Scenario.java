package tests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.loginPage;

import static org.testng.Assert.assertEquals;

@SuppressWarnings("unused")
public class Login_Nagative_Scenario extends TestBase {
    
    HomePage homeobject;
    loginPage loginObject;
    
    public void initializeObject() {
        homeobject = new HomePage(driver); 
        loginObject = new loginPage(driver);
    }

    // ==========================================
    // Data Provider for Negative Login Scenarios
    // ==========================================
    @DataProvider(name = "loginNegativeData")
    public Object[][] getLoginNegativeData() {
        return new Object[][] {
            { "abdelrahmanosama769@gmail.com", "12057" }, // Correct Email & Wrong Password
            { "fago102030@gmail.com", "21512" }           // Incorrect Email & Password
        };
    }
    
    // ==========================================
    // Test Case Execution
    // ==========================================
    @Test(dataProvider = "loginNegativeData")
    public void testLogin_NegativeScenarios(String username, String password) {
        initializeObject();
        
        homeobject.OpenloginPage(); 
        assertEquals(loginObject.loginMessage.getText(), "Login to your account");
        
        loginObject.UserCanLogin(username, password);
        assertEquals(loginObject.errorMassge.getText(), "Your email or password is incorrect!");
    }

}