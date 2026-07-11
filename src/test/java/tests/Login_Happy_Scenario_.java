package tests;

import org.testng.annotations.Test;

import data.LoadLoginHappyDataExcel;
import pages.HomePage;
import pages.loginPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterTest;

@SuppressWarnings("unused")
public class Login_Happy_Scenario_ extends TestBase {

    HomePage homeObject;
    loginPage loginObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver); 
        loginObject = new loginPage(driver);
    }
    
    @DataProvider(name = "lgoinData")
    public Object[][] getLoginHappyData() throws IOException {
        LoadLoginHappyDataExcel loginHappyData = new LoadLoginHappyDataExcel();
        return loginHappyData.getExcelFileData();        
    }

    @Test(dataProvider = "lgoinData")
    public void testLogin_CorrectUsernameAndMatchingPassword(String username, String password) throws InterruptedException {
        initializeObject();
        
        homeObject.OpenloginPage(); 
        assertEquals(loginObject.loginMessage.getText(), "Login to your account");
       
        loginObject.UserCanLogin(username, password);
        assertTrue(loginObject.logoutBtn.isEnabled()); 
       
        loginObject.UserCanLogout();
        assertEquals(loginObject.loginMessage.getText(), "Login to your account");
    }
 
}