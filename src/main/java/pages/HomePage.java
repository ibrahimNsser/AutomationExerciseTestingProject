package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends pagebase {
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     
    public HomePage(WebDriver driver) { 
        super(driver);
    }

    // ==========================================
    // 1. Header Navigation & Subscription Features
    // ==========================================
    @FindBy(linkText = "Signup / Login")
    public WebElement loginAndRejesterBtn;

    @FindBy(linkText = "Contactus")
    WebElement ContactusBtn;

    @FindBy(linkText = "Test Cases")
    public WebElement TestcasesBtn;

    @FindBy(linkText = "Home")
    public WebElement HomeBtn1;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
    public WebElement ProductsBtn;

    @FindBy(linkText = "Cart")
    WebElement CartBtn;

    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    public WebElement SubscriptionTitle;

    @FindBy(id = "susbscribe_email")
    public WebElement susbscribe_email_txt;

    @FindBy(id = "subscribe")
    WebElement susbscribe_submit_Btn;

    @FindBy(xpath = "//*[@id=\"success-subscribe\"]/div")
    public WebElement SubscriptionSuccessMessage;

    public void OpenloginPage() { 
        loginAndRejesterBtn.click();
    }

    public void OpenRejesterPage() { 
        loginAndRejesterBtn.click();
    }

    public void OpenContactusPage() {
         ContactusBtn.click();
    }

    public void OpenTestCasesPage() { 
        TestcasesBtn.click();
    }

    public void OpenProductsPage() { 
        wait.until(ExpectedConditions.elementToBeClickable(ProductsBtn));    
        ProductsBtn.click();    
    }

    public void UsercanSusbscribe(String email) {
        susbscribe_email_txt.sendKeys(email);
        susbscribe_submit_Btn.click();
    }

    public void OpenCartPage() { 
        CartBtn.click();
    }


    // ==========================================
    // 2. Sidebar Category & Brands Feature
    // ==========================================
    @FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a/span/i")
    public WebElement WomenCategoryBtn;

    @FindBy(xpath = "//*[@id=\"Women\"]/div/ul/li[1]/a")
    WebElement DressBtn;

    @FindBy(xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a/span/i")
    public WebElement MenCategoryBtn;

    @FindBy(xpath = "//*[@id=\"Men\"]/div/ul/li[1]/a")
    WebElement TshirtsBtn;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
    public WebElement WomenDressProductsTitle;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
    public WebElement MenTshirtsProductsTitle;

    @FindBy(xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a/span/i") // ملحوظة: الـ Locator ده أنت مكرره لـ MenCategoryBtn وسبته زي ما هو
    public WebElement BrandsTitle;

    public void clickOnWomenDressCategory() { 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", WomenCategoryBtn);
         
        wait.until(ExpectedConditions.elementToBeClickable(DressBtn));
        js.executeScript("arguments[0].click();", DressBtn);
    }

    public void clickOnMenTshirtsCategory() { 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", MenCategoryBtn);
         
        wait.until(ExpectedConditions.elementToBeClickable(TshirtsBtn));
        js.executeScript("arguments[0].click();", TshirtsBtn);
    }

}