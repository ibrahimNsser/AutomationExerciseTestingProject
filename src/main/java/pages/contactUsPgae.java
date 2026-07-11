package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactUsPgae extends pagebase {

    public contactUsPgae(WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // Contact Us Form Feature
    // ==========================================
    @FindBy(css = "#contact-us-form > div:nth-child(2) > input")
    WebElement nameInput;

    @FindBy(css = "	#contact-us-form > div:nth-child(3) > input")
    WebElement EmailInput;
    
    @FindBy(css = "	#contact-us-form > div:nth-child(4) > input")
    WebElement subjectlInput;
    
    @FindBy(css = "#message")
    WebElement messageInput;
    
    @FindBy(css = "#contact-us-form > div:nth-child(6) > input")
    WebElement upload_fileInput;
    
    @FindBy(css = "#contact-us-form > div:nth-child(7) > input")
    WebElement submitBtn;

    public void usercanSentcontactus(String name, String email, String subject, String message, String uploadfileInput) {
        nameInput.sendKeys(name);
        EmailInput.sendKeys(email);
        subjectlInput.sendKeys(subject);
        messageInput.sendKeys(message);
        upload_fileInput.sendKeys(uploadfileInput);
        submitBtn.click();
    }

}




