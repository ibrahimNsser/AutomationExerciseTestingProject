package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class SearchProduct extends TestBase {
    
    HomePage homeObject;
    ProductPage productobject;
    
    public void initializeObject() {
        homeObject = new HomePage(driver);
        assertEquals(homeObject.HomeBtn1.getCssValue("color"), "rgba(255, 165, 0, 1)");
        productobject = new ProductPage(driver);
    }
    
    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        Object[][] Testdata = {
            {"Blue Top"}
        };
        return Testdata;
    }

    @Test(dataProvider = "searchData")
    public void verfiyUserCanSearchForExistinProduct(String searchData) {
        initializeObject();
        
        // Step 1: Navigate to Products Page & Verify Title
        homeObject.OpenProductsPage();
        assertEquals(productobject.ProductPageTitle.getText(), "ALL PRODUCTS");
        
        // Step 2: Search for the Product & Verify Results Title
        productobject.searchForExistingProduct(searchData);
        assertEquals(productobject.searchResultsTitle.getText(), "SEARCHED PRODUCTS");
    }
    
}