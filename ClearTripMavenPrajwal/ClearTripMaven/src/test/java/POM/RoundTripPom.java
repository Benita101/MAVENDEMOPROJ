package POM;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Base;
import utils.BaseForMasterExecute;

	public class RoundTripPom{
		WebDriver driver;
		public RoundTripPom(WebDriver driver)
		{
			this.driver=driver;
		}
		
		By FromField=By.xpath("//input[@id='FromTag']");
		
		By fromFieldAutoComplete = By.id("ui-id-1");
		
		By ToField=By.xpath("//input[@id='ToTag']");
		
		By toFieldAutoComplete = By.id("ui-id-2");
		
		By Date=By.xpath("//input[@id='DepartDate']");
		
		By ReturnDate=By.xpath("//input[@id='ReturnDate']");
		
		By Adults=By.xpath("//select[@id='Adults']");

		By Children=By.xpath("//select[@id='Childrens']");
		
		By Infant=By.xpath("//select[@id='Infants']");
		
		By MoreLinks=By.id("MoreOptionsLink");
		
		By Class=By.id("Class");
		
		By PreferredAirlines=By.id("AirlineAutocomplete");
		
		By Search=By.id("SearchBtn");
		
		By RTrip=By.id("RoundTrip");
		
		public void goToHome(String URL)
		{
			driver.get(URL);
		}
		
		public void goToRoundTrip()
		{
			 driver.findElement(By.id("RoundTrip")).click();
		}
		public void enterFrom(String from) throws Exception
		{
			driver.findElement(FromField).clear();
			driver.findElement(FromField).sendKeys(from);
		    try {
			WebDriverWait explicitwait= new WebDriverWait(driver, 5);
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(fromFieldAutoComplete));
			
			Boolean suggestion = driver.findElement(fromFieldAutoComplete).isDisplayed();
			
			if(suggestion==true)
			{
				driver.findElement(FromField).sendKeys(Keys.ENTER);
			}
							
		}catch(Exception e)
		{
			//driver.findElement(FromField).click();
		}
			
			//driver.findElement(FromField).sendKeys(Keys.ENTER);
			
		}
		public void enterTo(String to) throws Exception
		{
			driver.findElement(ToField).clear();
			driver.findElement(ToField).sendKeys(to);
			try {
			WebDriverWait explicitwait= new WebDriverWait(driver, 5);
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(toFieldAutoComplete));
			Boolean suggestion = driver.findElement(toFieldAutoComplete).isDisplayed();
			
			if(suggestion==true)
			{
				driver.findElement(ToField).sendKeys(Keys.ENTER);
			}
							
			}catch(Exception e)
			{
				//driver.findElement(ToField).click();
			}
		}
			
		public void enterDate(String date) throws Exception
		{
			driver.findElement(Date).click();
			driver.findElement(Date).sendKeys(Keys.BACK_SPACE+date);
			driver.findElement(Date).click();
			Thread.sleep(3000);
		}
		public void enterReturnDate(String date) throws Exception
		{
			driver.findElement(ReturnDate).click();
			//driver.findElement(Date).clear();	
			driver.findElement(ReturnDate).sendKeys(Keys.BACK_SPACE+date);
			driver.findElement(ReturnDate).click();
			Thread.sleep(3000);
			
		}
		public void selectAdult(String adults)
		{
			Select selectAdult= new Select(driver.findElement(Adults));
			selectAdult.selectByVisibleText(adults);
		}
		public void selectChildren(String children)
		{
			Select selectChildren= new Select(driver.findElement(Children));
			selectChildren.selectByVisibleText(children);
		}
		public void selectInfant(String infant)
		{
			Select selectInfant= new Select(driver.findElement(Infant));
			selectInfant.selectByVisibleText(infant);
		}
		public void MoreLink()
		{
			driver.findElement(MoreLinks).click();
		}
		public void selectClass(String airlineClass) throws Exception
		{
			Select selectClass= new Select(driver.findElement(Class));
			selectClass.selectByVisibleText(airlineClass);
			Thread.sleep(3000);
		}
		public void preferredAirlines(String airline)
		{
			WebElement element =  driver.findElement(PreferredAirlines);
	    	JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].value='"+airline+"';", element);
		}
		
		public void searchFlights() throws Exception
		{
			driver.findElement(Search).click();
			try {
				new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(driver.findElement(Search)));
		    	System.out.println("Next page");
				}
				catch(TimeoutException T)
				{
					BaseForMasterExecute.captureScreenshot("InvalidRoundTripSearch");
			    	System.out.println("refresh");
			    	driver.navigate().refresh();
				}
			
			
			
		    /*if( driver.getTitle().equals("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities."))
		    {
		    	System.out.println("in else");
		    	driver.navigate().refresh();
		    }
		    else if(driver.getTitle().equals("Flight bookings, Cheap flights, Lowest Air tickets @Cleartrip"))
		    {
		    	driver.navigate().refresh();
		    }
		    else 
		    {
		    	System.out.println("inside if");
		    	//driver.navigate().back();
		    }*/
		    
		    }
		
		}

