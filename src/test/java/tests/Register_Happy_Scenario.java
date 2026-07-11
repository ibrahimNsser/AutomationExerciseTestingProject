package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadRrgisterHappyDataExcel;
import pages.HomePage;
import pages.RegisterPage;

public class Register_Happy_Scenario extends TestBase {
    
    HomePage homeObject;
    RegisterPage RejesterObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        RejesterObject = new RegisterPage(driver);
    }
    
    @DataProvider(name = "getRejesterHappyData")
    public Object[][] getRegisterHappyData() throws IOException {
        LoadRrgisterHappyDataExcel RrgisterHappyData = new LoadRrgisterHappyDataExcel();
        return RrgisterHappyData.getExcelFileData();
    }

    @Test(dataProvider = "getRejesterHappyData")
    public void TestRegister_ValidMandatoryAndOptionalFieldsWithNewEmail(
            String name, String username, String passowrd, String day, String month, String year, 
            String firstname, String lasdname, String company, String address1, String address2, 
            String cuntry, String state, String city, String zipcode, String number, String isMandatoryAndOptionals) throws InterruptedException {
        
        boolean isMandatoryAndOptionalb = Boolean.parseBoolean(isMandatoryAndOptionals);
        initializeObject();
    
        // Step 1: Open Register Page & Verify Title
        homeObject.OpenRejesterPage();
        assertEquals(RejesterObject.RejesrPageTitle.getText(), "New User Signup!");
          
        // Step 2: Enter Initial Signup Info (Name & Email)
        RejesterObject.UseracanRejester(name, username);
        Assert.assertEquals(RejesterObject.RejesterMessage.getText(), "ENTER ACCOUNT INFORMATION");

        // Step 3: Conditional Account Registration based on Excel Flag (Mandatory vs All Fields)
        if (isMandatoryAndOptionalb) {
            RejesterObject.userCanEnterAccountInformation(passowrd, day, month, year, firstname, lasdname, company,
                     address1, address2, cuntry, state, city, zipcode, number);
           
        } else {
            RejesterObject.userCanEnterAccountInformation(passowrd, firstname, lasdname, 
                     address1, cuntry, state, city, zipcode, number);
           
        }
        
        // Step 4: Verify Account Creation Success
        assertEquals(RejesterObject.AcountCreatedSuccessMessage.getText(), "ACCOUNT CREATED!");

        // Step 5: Clean up & Delete Created Account
        RejesterObject.clickONContinueBtn();
        RejesterObject.clickONDeleteAccountBtn();
        RejesterObject.clickONContinueBtn();

        // Step 6: Verify User Redirection to Home Page via Button Color
        assertEquals(homeObject.loginAndRejesterBtn.getCssValue("color"), "rgba(105, 103, 99, 1)");
    }
 
}
