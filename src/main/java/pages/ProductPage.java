package pages;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends pagebase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // General Page Elements & Assertions
    // ==========================================
    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2")
    public WebElement ProductPageTitle;

    @FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button")
    public WebElement AddToCartBtn;

    @FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > h2")
    public WebElement ProductNameTxt;

    @FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > span")
    public WebElement priceTxt;

    @FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(3)")
    public WebElement CategoryNameTxt;

    @FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(6) > b")
    public WebElement AvailabilityTxt;

    @FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(7) > b")
    public WebElement ConditionTxt;

    @FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(8) > b")
    public WebElement BrandTxt;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div")
    public WebElement productbox1;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]")
    public WebElement productbox2;

    @FindBy(linkText = "Proceed To Checkout")
    public WebElement CartPageTitle;

    @FindBy(linkText = "Blue Top")
    public WebElement product_One;

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[3]/p")
    public WebElement Price_For_proudctOne;

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button")
    public WebElement Quantity_for_ProductOne;

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[5]/p")
    public WebElement total_price_for_productOne;

    @FindBy(linkText = "Men Tshirt")
    public WebElement product_tow;

    @FindBy(xpath = "//*[@id=\"product-2\"]/td[3]/p")
    public WebElement Price_For_proudctTow;

    @FindBy(xpath = "//*[@id=\"product-2\"]/td[4]/button")
    public WebElement Quantity_for_ProductTow;

    @FindBy(xpath = "//*[@id=\"product-2\"]/td[5]/p")
    public WebElement total_price_for_productTow;


    // ==========================================
    // 1. View Product Feature
    // ==========================================
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    public WebElement ViewProductBtn;

    public void clickOnViewProductBtn() {
        wait.until(ExpectedConditions.visibilityOf(ViewProductBtn));    
        ViewProductBtn.click();
    }


    // ==========================================
    // 2. Search Product Feature
    // ==========================================
    @FindBy(id = "search_product")
    WebElement search_product_box;

    @FindBy(id = "submit_search")
    WebElement ssubmit_search_Btn;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    public WebElement searchResultsTitle;

    public void searchForExistingProduct(String searchTxt) {
        search_product_box.sendKeys(searchTxt);
        ssubmit_search_Btn.click();
    }


    // ==========================================
    // 3. Add to Cart & Checkout Features
    // ==========================================
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    public WebElement AddToCartBtnForItem1;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    public WebElement AddToCartBtnForItem2;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    public WebElement ContinueShoppingBtn;

    @FindBy(linkText = "View Cart")
    public WebElement ViewCartBtn;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    public WebElement ViewProductBtnForProductOne;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a")
    public WebElement ViewProductBtnForProductTow;

    public void UserCanAddProductToCart() {
        Actions action = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(ViewProductBtnForProductOne));
            
        //ViewProductBtnForProductOne.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", ViewProductBtnForProductOne);
        
        wait.until(ExpectedConditions.elementToBeClickable(AddToCartBtnForItem1));
        AddToCartBtnForItem1.click();

        wait.until(ExpectedConditions.elementToBeClickable(ContinueShoppingBtn));
        ContinueShoppingBtn.click();
        
        driver.navigate().back();
        wait.until(ExpectedConditions.elementToBeClickable(ViewProductBtnForProductTow));

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", ViewProductBtnForProductTow);
        
        wait.until(ExpectedConditions.elementToBeClickable(AddToCartBtnForItem2));
        AddToCartBtnForItem2.click();

        wait.until(ExpectedConditions.elementToBeClickable(ViewCartBtn));
        ViewCartBtn.click();
    }

    public void AddOneProductToCartAndNavigateToCartPage() {
        Actions action = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(ViewProductBtnForProductOne));
            
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", ViewProductBtnForProductOne);
        
        wait.until(ExpectedConditions.elementToBeClickable(AddToCartBtnForItem1));
        AddToCartBtnForItem1.click();

        wait.until(ExpectedConditions.elementToBeClickable(ViewCartBtn));
        ViewCartBtn.click();
    }


    // ==========================================
    // 4. Product Quantity Feature
    // ==========================================
    @FindBy(id = "quantity")
    WebElement quantityTxt;

    public void VerifyProductQuantityInCart() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", ViewProductBtnForProductOne);
        
        quantityTxt.clear();
        quantityTxt.sendKeys("4");
        
        wait.until(ExpectedConditions.elementToBeClickable(AddToCartBtnForItem1));
        AddToCartBtnForItem1.click();
        
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartBtn));
        ViewCartBtn.click();
    }


    // ==========================================
    // 5. Brands Feature
    // ==========================================
    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-3 > div.left-sidebar > div.brands_products > div > ul > li:nth-child(1) > a")
    public WebElement PoloBrandBtn;

    @FindBy(xpath = "/html/body/section/div/div[1]/ol/li[2]")
    public WebElement PoloBrandProductsTitle;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[1]/div[1]/div[2]/div/ul/li[2]/a")
    public WebElement HMBrandBtn;

    @FindBy(xpath = "/html/body/section/div/div[1]/ol/li[2]")
    public WebElement HmBrandProductsTitle;

    public void clickOnPoloBrandBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(PoloBrandBtn));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", PoloBrandBtn);
    }

    public void clickOnHMBrandBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(HMBrandBtn));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", HMBrandBtn);
    }

}