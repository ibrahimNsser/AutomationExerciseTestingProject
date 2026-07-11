package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import javax.xml.datatype.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
	WebDriver driver;
	String baseURL = "https://automationexercise.com/";
  @BeforeTest
  public void openWebsite() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(baseURL);
	
	}
	  
  @AfterTest
  public void closeWebsite() {
	  driver.quit();
  }

}
