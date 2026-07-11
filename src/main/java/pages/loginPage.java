package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends pagebase{
	
public loginPage (WebDriver driver) {	
super(driver);
}

	@FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")
	public WebElement Emailinput;

	@FindBy(name = "password")
	public WebElement PasswordInput;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
	public WebElement loginBtn2;

	@FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2")
	public WebElement loginMessage;

	@FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p")
	public WebElement errorMassge;

	@FindBy(linkText = "Logout")
	public WebElement logoutBtn;

	public void UserCanLogin (String email , String password ) {
		Emailinput.sendKeys( email); 
		PasswordInput.sendKeys(password);
		loginBtn2.click();
		
	}
	public void UserCanLogout() {
		logoutBtn.click();
	}

	}

