package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;



import utils.BaseForMasterExecute;

public class LoginPOM {
	WebDriver driver;

	public LoginPOM(WebDriver driver) {
		this.driver = driver;
	}

	By userClick = By.id("userAccountLink");
	By signInClick = By.id("SignIn");
	 By signOutClick = By.id("global_signout");
	By userName = By.id("email");
	By passwrd = By.id("password");
	//By E_CHECK = By.id("persistent_login");
	By loginButton = By.id("signInButton");
	// By E_FRAME = By.id("modal_window");
	By closeButton = By.id("close");

	public void loginProcess(String username, String password) throws Exception {

		// driver.findElement(userClick).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(userClick));
		driver.findElement(signInClick).click();
		driver.switchTo().frame("modal_window");
		driver.findElement(userName).clear();
		driver.findElement(passwrd).clear();
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passwrd).sendKeys(password);
		driver.findElement(loginButton).click();

		Thread.sleep(8000);
        try {
		
		if (driver.findElement(By.id("email")).isDisplayed()) {
			BaseForMasterExecute.captureScreenshot("login");
		} else {
			System.out.println("ss fail");
		}
		driver.findElement(loginButton).sendKeys(Keys.F5);
        }
        catch(Exception e)
        {
        	
        }
		try {
			driver.findElement(By.linkText("Hotels"));

		} catch (Exception e) {
			driver.switchTo().defaultContent();
			driver.findElement(closeButton).click();

		}
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "userAccountLink")));
		 */
		// Assert.assertEquals(driver.getTitle(), "#1 Site for Booking Flights, Hotels,
		// Packages, Trains & Local activities.");
	}



	public void signOut() throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Thread.sleep(10000);
	//	driver.navigate().refresh();
		executor.executeScript("arguments[0].click();", driver.findElement(userClick));
		executor.executeScript("arguments[0].click();", driver.findElement(signOutClick));
		
	}

}
