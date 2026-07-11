package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import pages.loginPage;

public class SearchProductsAndVerifyCartAfterLogin extends TestBase {
     
    HomePage homeObject;
    ProductPage productobject;
    loginPage loginObject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        productobject = new ProductPage(driver);
        loginObject = new loginPage(driver);
    }
    
    // ==========================================
    // Data Provider for Product Search and Login
    // ==========================================
    @DataProvider(name = "searchAndLoginData")
    public Object[][] getSearchAndLoginData() {
        return new Object[][] {
            { "Blue Top", "abdelrahmanosama769@gmail.com", "a123456789" }
        };
    }
    
    // ==========================================
    // Test Case Execution
    // ==========================================
    @Test(dataProvider = "searchAndLoginData")
    public void TestSearchProductsAndVerifyCartAfterLogin(String searchData, String email, String password) {
        initializeObject();
       
        // Step 1: Navigate to Products Page & Verify Title
        homeObject.OpenProductsPage();
        assertEquals(productobject.ProductPageTitle.getText(), "ALL PRODUCTS");
       
        // Step 2: Search for the Product & Verify Results Title
        productobject.searchForExistingProduct(searchData);
        assertEquals(productobject.searchResultsTitle.getText(), "SEARCHED PRODUCTS");
       
        // Step 3: Add Product to Cart & Verify it in Cart Page
        productobject.AddOneProductToCartAndNavigateToCartPage();
        assertEquals(productobject.product_One.getText(), "Blue Top");
       
        // Step 4: Navigate to Login Page & Perform Login
        homeObject.OpenloginPage();
        loginObject.UserCanLogin(email, password);
       
        // Step 5: Re-navigate to Cart Page & Verify Product Still Exists
        homeObject.OpenCartPage();
        assertEquals(productobject.product_One.getText(), "Blue Top");
    }
    
}