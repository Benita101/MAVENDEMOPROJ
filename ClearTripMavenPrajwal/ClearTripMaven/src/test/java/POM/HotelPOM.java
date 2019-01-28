
package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HotelPOM 
{
	WebDriver driver;
	Select select;
	public HotelPOM(WebDriver driver)
	{
		this.driver=driver;	
	}
	By E_HOTELCLICK=By.linkText("Hotels");
	By E_WHERE=By.id("Tags");
	By E_CHECKIN=By.id("CheckInDate");
	By E_CHECKOUT=By.id("CheckOutDate");
	By E_TRAVELLERS=By.id("travellersOnhome");
	By E_SEARCH=By.id("SearchHotelsButton");





	By E_OFFER=By.xpath("//*[contains(text(),'Hotel with deals')]");
	By E_5STAR=By.xpath("//*[contains(text(),'5 star')]");
	By E_1STAR=By.xpath("//*[contains(text(),'1 star')]");
	By E_RATE=By.xpath("//*[contains(text(),'3.5 and Above')]");
	By E_RATE4=By.xpath("//*[contains(text(),'4 and Above')]");
	By E_AC=By.xpath("//*[contains(text(),'Air conditioning')]");
	By E_INDEPENDENT=By.xpath("//*[contains(text(),'Independent')]");
	By E_GUEST=By.xpath("//*[contains(text(),'Guest House')]");




	public void searchHotel(String where,String checkin,String checkout,String traveller) throws Exception
	{
		driver.findElement(E_HOTELCLICK).click();
		driver.findElement(E_WHERE).clear();
		driver.findElement(E_WHERE).sendKeys(where);
		Thread.sleep(3000);
		driver.findElement(E_WHERE).sendKeys(Keys.ENTER);
		driver.findElement(E_CHECKIN).click();
		driver.findElement(E_CHECKIN).sendKeys(checkin+Keys.ENTER);
		driver.findElement(E_CHECKOUT).click();
		driver.findElement(E_CHECKOUT).sendKeys(checkout+Keys.ENTER);
		select= new Select(driver.findElement((E_TRAVELLERS)));
		select.selectByVisibleText(traveller);

		driver.findElement(E_SEARCH).click();

		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Hotel with deals')]")));
	}
	public void bookHotel()

	{




		driver.findElement(E_OFFER).click();
		driver.findElement(E_5STAR).click();
		driver.findElement(E_1STAR).click();
		driver.findElement(E_RATE).click();
		driver.findElement(E_RATE4).click();
		JavascriptExecutor executor=(JavascriptExecutor)driver;

		executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		driver.findElement(E_AC).click();
		driver.findElement(E_INDEPENDENT).click();
		driver.findElement(E_GUEST).click();


	}

}

