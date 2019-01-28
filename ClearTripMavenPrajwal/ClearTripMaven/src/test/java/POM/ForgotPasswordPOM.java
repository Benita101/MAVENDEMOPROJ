package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ForgotPasswordPOM {
	
	
	
	 WebDriver driver;
	public ForgotPasswordPOM(WebDriver driver)
	{
	this.driver=driver;	
	}
	By E_USERCLICK=By.id("userAccountLink");
	By E_SIGNINCLCK = By.id("SignIn");
	String E_Frame = "modal_window";
	By E_UN=By.id("email");
	By E_FORGOTPASSLINK=By.linkText("I forgot my password");
	By E_CHECK=By.id("persistent_login");
	By E_LoginButton=By.id("signInButton");
	By E_ResetButton=By.id("reset_submit");
	By E_CLOSE=By.id("close");
	



	/*public void forgotPassProcess(String username) throws Exception
	{   Assert.assertEquals(driver.getTitle(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	driver.findElement(E_USERCLICK).click();
	driver.findElement(E_SIGNINCLCK).click();
	Thread.sleep(10000);
	driver.switchTo().frame("modal_window");
	Thread.sleep(10000);
	driver.findElement(E_UN).clear();
	driver.findElement(E_UN).sendKeys(username);
	driver.findElement(E_FORGOTPASSLINK).click();
	driver.findElement(E_ResetButton).click();
	try {
		driver.findElement(By.linkText("India"));

	} catch (Exception e) {
		driver.switchTo().defaultContent();
		driver.findElement(E_CLOSE).click();
	}
	}*/
	
	public void forgotPassProcess(String username,String emailForReset) throws Exception
	{   Assert.assertEquals(driver.getTitle(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	driver.findElement(E_USERCLICK).click();
	driver.findElement(E_SIGNINCLCK).click();

	driver.switchTo().frame("modal_window");
	
	driver.findElement(E_UN).clear();
	driver.findElement(E_UN).sendKeys(username);
	driver.findElement(E_FORGOTPASSLINK).click();
	driver.findElement(E_UN).clear();
	driver.findElement(E_UN).sendKeys(emailForReset);
	driver.findElement(E_ResetButton).click();
	try {
		driver.findElement(By.linkText("India"));

	} catch (Exception e) {
		driver.switchTo().defaultContent();
		driver.findElement(E_CLOSE).click();
	
	}
	}
	
}
