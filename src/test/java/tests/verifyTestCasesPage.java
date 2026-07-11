package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.TestCasesPage;

public class verifyTestCasesPage extends TestBase {
    
    HomePage homeObject;
    TestCasesPage testCasesObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        testCasesObject = new TestCasesPage(driver);
    }

    @Test
    public void test_verify_navigation_to_test_cases_page() {
        initializeObject();
        
        // Step 1: Click on Test Cases button from Home Page
        homeObject.OpenTestCasesPage();
        
        // Step 2: Verify that the user is successfully redirected to Test Cases page
        assertEquals(testCasesObject.pageTitel.getText(), "TEST CASES");
    }
    
}








