package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends pagebase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // Validation Messages & General Titles
    // ==========================================
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > h2")
    public WebElement RejesrPageTitle;
    
    @FindBy(css = "#form > div > div > div > div > h2 > b")
    public WebElement RejesterMessage;
    
    @FindBy(css = "#form > div > div > div > h2 > b")
    public WebElement AcountCreatedSuccessMessage;
    
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement LoggedIn_As_Message;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement AccountDeletedMassege;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    public WebElement errorMessage;


    // ==========================================
    // 1. Initial Signup Feature
    // ==========================================
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)")
    public WebElement nameInput;
    
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
    public WebElement emailInput;
    
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > button")
    public WebElement signupBtn;
    
    public void UseracanRejester(String name, String email) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        signupBtn.click();    
    } 


    // ==========================================
    // 2. Account Information Form (Polymorphism / Overloading)
    // ==========================================
    @FindBy(id = "id_gender1")
    WebElement MRCheeck;
    
    @FindBy(id = "id_gender2")
    WebElement MRsCheeck;
    
    @FindBy(id = "password")
    public WebElement PasswordInput;
    
    @FindBy(id = "days")
    public WebElement DaysDropdowinlist;
    
    @FindBy(id = "months")
    public WebElement monthsDropdowinlist;
    
    @FindBy(id = "years")
    public WebElement yearsDropdowinlist;
    
    @FindBy(id = "newsletter")
    WebElement newsletterCheeck;
    
    @FindBy(id = "optin")
    WebElement ReceiveCheeck;
    
    @FindBy(id = "first_name")
    public WebElement first_nameInput;
    
    @FindBy(id = "last_name")
    public WebElement last_nameInput;
    
    @FindBy(id = "company")
    public WebElement companyInput;
    
    @FindBy(id = "address1")
    public WebElement address1Input;
    
    @FindBy(id = "address2")
    public WebElement address2Input;
    
    @FindBy(id = "country")
    public WebElement countryDropdowinList;
    
    @FindBy(id = "state")
    public WebElement stateInput;
    
    @FindBy(id = "city")
    public WebElement cityInput;
    
    @FindBy(id = "zipcode")
    public WebElement zipcodeInput;
    
    @FindBy(id = "mobile_number")
    public WebElement mobile_numberInput;
    
    @FindBy(css = "#form > div > div > div > div.login-form > form > button")
    public WebElement CreateAccountBtn;
    
    // First implementation (Full Data)
    public void userCanEnterAccountInformation(
            String password, String UserSelectDays, String UserSelectmonths,
            String UserSelectYears, String Firstname, String lastname, 
            String company,
            String address1, String address2, String UserSelectCountry, String state, String city, 
            String zipcode, String mobileNumber) {
        
        MRCheeck.click();
        PasswordInput.sendKeys(password);
    
        Select Dayslist = new Select(DaysDropdowinlist);
        Dayslist.selectByValue(UserSelectDays);
        
        Select monthslist = new Select(monthsDropdowinlist);
        monthslist.selectByValue(UserSelectmonths);
        
        Select yearslist = new Select(yearsDropdowinlist);
        yearslist.selectByValue(UserSelectYears);
        
        newsletterCheeck.click();
        ReceiveCheeck.click();
        first_nameInput.sendKeys(Firstname);
        last_nameInput.sendKeys(lastname);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        
        Select countyList = new Select(countryDropdowinList);
        countyList.selectByVisibleText(UserSelectCountry);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobile_numberInput.sendKeys(mobileNumber);
        CreateAccountBtn.click();
    }

    // Second implementation (Mandatory Data Only)
    public void userCanEnterAccountInformation(String password, String FirstName,
            String lasdName, String address1, String UserSelectCountry, String state, String city, 
            String zipcode, String mobileNumber) {
        PasswordInput.sendKeys(password);
        first_nameInput.sendKeys(FirstName);
        last_nameInput.sendKeys(lasdName);
        address1Input.sendKeys(address1);
        
        Select countyList = new Select(countryDropdowinList);
        countyList.selectByVisibleText(UserSelectCountry);
       
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobile_numberInput.sendKeys(mobileNumber);
        
        wait.until(ExpectedConditions.elementToBeClickable(CreateAccountBtn));
        CreateAccountBtn.click();
    }
        
    
    // ==========================================
    // 3. Navigation & Account Deletion Actions
    // ==========================================
    @FindBy(linkText = "Continue")
    public WebElement continueBtn;

    public void clickONContinueBtn() {
     
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", continueBtn);
    }

    @FindBy(linkText = "Delete Account")
    public WebElement DeleteAccountBtn;

    public void clickONDeleteAccountBtn() {
        
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", DeleteAccountBtn);
    }

}