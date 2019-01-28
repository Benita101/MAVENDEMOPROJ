package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.BaseForMasterExecute;



public class RegisterPOM {
	WebDriver driver;
	Select select;

	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver;
	}
	By E_USERCLICK = By.id("userAccountLink");
	By E_REGISTERCLICK = By.linkText("Register");
	By E_FRAME = By.id("modal_window");
	By E_UN1 = By.id("username1");
	By E_REGISTERBTN=By.id("registerButton");
	//By E_CLICKFORGTPASS=By.linkText("I forgot my password");
	By E_FRAME1 = By.id("modal_window");
	By E_PWD1 = By.id("password");
//	By E_TITLE = By.id("profile_title");
//	By E_NAME = By.name("first_name");
//	By E_LASTNAME = By.name("last_name");
//	By E_CODE = By.id("country_code");
//	By E_PHONE = By.id("mobile_number");
	By E_SIGNUP = By.id("signUpButton");
	By E_CLOSE=By.id("close");
	By SIGN_OUT=By.linkText("Sign out");
	By ContactUs=By.xpath("//*[@id=\"supportWidget\"]/li/div/span");
	
	public void registerProcess(String emailReg,String password1, String visible, String name, String lastName, 
		String phone) throws Exception {
		driver.findElement(E_USERCLICK).click();
		driver.findElement(E_REGISTERCLICK).click();
		driver.switchTo().frame("modal_window");
		driver.findElement(E_UN1).sendKeys(emailReg);
		driver.findElement(E_REGISTERBTN).click();
		Thread.sleep(3000);
		//driver.switchTo().frame("modal_window");
		WebElement element = driver.findElement(E_PWD1);
		WebElement E_TITLE = driver.findElement(By.id("profile_title"));
		WebElement E_NAME = driver.findElement(By.name("first_name"));
		WebElement E_LASTNAME = driver.findElement(By.name("last_name"));
		WebElement E_CODE = driver.findElement(By.id("country_code"));
		WebElement E_PHONE = driver.findElement(By.id("mobile_number"));
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='"+password1+"';", element);
		executor.executeScript("arguments[0].value='"+visible+"';", E_TITLE);
		
		executor.executeScript("arguments[0].value='"+name+"';", E_NAME);
		executor.executeScript("arguments[0].value='"+lastName+"';", E_LASTNAME);
		//executor.executeScript("arguments[0].value='"+countryCode+"';", E_CODE);
		executor.executeScript("arguments[0].value='"+phone+"';", E_PHONE);
		executor.executeScript("arguments[0].click();", driver.findElement(E_SIGNUP));
		
		Thread.sleep(8000);
	try {
		if(driver.findElement(By.name("first_name")).isDisplayed())
	      {
		BaseForMasterExecute.captureScreenshot("Register");
	      }
	}
	catch(Exception e)
	{
		System.out.println("Valid");
	}

		try {
			Thread.sleep(10000);
			driver.findElement(ContactUs);

		} catch (Exception e) {
			driver.switchTo().defaultContent();
			driver.findElement(E_CLOSE).click();
       

		}

	}
	public void signOut() throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Thread.sleep(15000);
		driver.findElement(E_USERCLICK).click();
		executor.executeScript("arguments[0].click();", driver.findElement(SIGN_OUT));
		//driver.findElement(SIGN_OUT).click();
		
	}
}
