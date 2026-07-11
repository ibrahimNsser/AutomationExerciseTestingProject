package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
	public class pagebase {
	protected WebDriver driver;
	
	public pagebase (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
	}
	
	}
