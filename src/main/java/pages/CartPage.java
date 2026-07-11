package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends pagebase {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // General Page Elements & Assertions
    // ==========================================
    @FindBy(xpath = "//*[@id=\"empty_cart\"]/p/b")
    public WebElement CartPageTitle;


    // ==========================================
    // 1. Subscription Feature
    // ==========================================
    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    public WebElement SubscriptionTitle;
    
    @FindBy(id = "susbscribe_email")
    WebElement susbscribe_email_txt;
    
    @FindBy(id = "subscribe")
    WebElement susbscribe_submit_Btn;
    
    @FindBy(xpath = "//*[@id=\"success-subscribe\"]/div")
    public WebElement SubscriptionSuccessMessage;
    
    public void UsercanSusbscribe(String email) {
        susbscribe_email_txt.sendKeys(email);
        susbscribe_submit_Btn.click();
    }


    // ==========================================
    // 2. Checkout & Registration Navigation
    // ==========================================
    @FindBy(linkText = "Proceed To Checkout") 
    public WebElement ProceedToCheckoutBtn;
    
    @FindBy(linkText = "Register / Login") 
    WebElement Register_LoginBtn;
     
    public void clickProceedCheckoutAndOpenRegistration() {
        ProceedToCheckoutBtn.click();
        Register_LoginBtn.click();
    }


    // ==========================================
    // 3. Checkout, Payment & Order Confirmation
    // ==========================================
    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea") 
    WebElement TextArea;

    @FindBy(linkText = "Place Order") 
    WebElement PlaceOrderBtn;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[1]/div/input") 
    WebElement NameOnCardTxt;
    
    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[2]/div/input") 
    WebElement CardNumberTxt;
    
    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[1]/input") 
    WebElement CvCTxt;
    
    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[2]/input") 
    WebElement expiryMonth;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[3]/input") 
    WebElement expiryYear;
    
    @FindBy(id = "submit") 
    WebElement PayandConfirmOrderBtn;

    @FindBy(linkText = "Continue") 
    public WebElement ContinueBtn;
    
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b") 
    public WebElement OrderPlacedMessage;
    
    public void checkoutAndPayWithExistingAccount(String commentTxt_pramiter, String NameOnCardTxt_pramiter,
            String CardNumberTxt_pramiter, String cvcTxt_pramiter, String ExpirationMonth_pramiter, String ExpirationYear_pramiter) {
        TextArea.sendKeys(commentTxt_pramiter);
        PlaceOrderBtn.click();
        NameOnCardTxt.sendKeys(NameOnCardTxt_pramiter);
        CardNumberTxt.sendKeys(CardNumberTxt_pramiter);
        CvCTxt.sendKeys(cvcTxt_pramiter);
        expiryMonth.sendKeys(ExpirationMonth_pramiter);
        expiryYear.sendKeys(ExpirationMonth_pramiter); 
        PayandConfirmOrderBtn.click();
    }


    // ==========================================
    // 4. Delete Products Feature
    // ==========================================
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[6]/a/i")
    WebElement DeleteProduct1_X_Btn1;
    
    @FindBy(xpath = "//*[@id=\"product-2\"]/td[6]/a/i")
    WebElement DeleteProduct2_X_Btn2;
    
    @FindBy(xpath = "//*[@id=\"empty_cart\"]/p/b")
    public WebElement ConfirmationCartIsEmptyMessage;
    
    public void ClickOnDeleteProductBtn() {
        DeleteProduct1_X_Btn1.click();
        DeleteProduct2_X_Btn2.click();
    }

}