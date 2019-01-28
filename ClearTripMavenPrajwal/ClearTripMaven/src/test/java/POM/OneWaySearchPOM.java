package POM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Base;
import utils.BaseForMasterExecute;

public class OneWaySearchPOM{
	
	WebDriver driver;
    String date1;
	public OneWaySearchPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	By FromField=By.xpath("//input[@id='FromTag']");
	By fromFieldAutoComplete = By.id("ui-id-1");
	By ToField=By.xpath("//input[@id='ToTag']");
	By toFieldAutoComplete = By.id("ui-id-2");
	By CurrentDate = By.xpath("//*[@class='ui-state-default ui-state-highlight ui-state-active ']");
	By DepartDate=By.xpath("//dl[@class='vertical']//i[@class='icon ir datePicker'][contains(text(),'Cal')]");
	By Year=By.xpath("//div/span[@class='ui-datepicker-year'][text()='2019']");
	By Month=By.xpath("//*[@class='calendar']/tbody/tr/td[@data-handler='selectDay']");
	//By Weekday=By.xpath("//td[@class=' undefined']/a[text()='"+date1+"']");
	By NextMonth=By.xpath("//div/a[@class='nextMonth ']");
	By PrevMonth=By.xpath("//div/a[@class='prevMonth']");
	//By Weekend=By.xpath("//td[@class=' weekEnd undefined']/a[text()='"+date1+"']");
	By Adults=By.xpath("//select[@id='Adults']");
	By Children=By.xpath("//select[@id='Childrens']");
	By Infant=By.xpath("//select[@id='Infants']");
	By MoreLinks=By.id("MoreOptionsLink");
	By Class=By.id("Class");
	By PreferredAirlines=By.id("AirlineAutocomplete");
	By Search=By.id("SearchBtn");
	
	/*public void searchOneWay(String from ,String to,String date,String adults,String children,String infant,String airlineClass,String airline) throws Exception
	{ 
		driver.findElement(FromField).clear();
		driver.findElement(FromField).sendKeys(from);
		 Thread.sleep(5000);
		driver.findElement(FromField).sendKeys(Keys.ENTER);
		driver.findElement(ToField).clear();
		driver.findElement(ToField).sendKeys(to);
		 Thread.sleep(5000);
		driver.findElement(ToField).sendKeys(Keys.ENTER);
		System.out.println(date);
		String datamonth;
		String month;
		if (date.charAt(3)=='0')
		{
			 month=Character.toString(date.charAt(4));
		}
		else
		{
			month=date.substring(3, 4);
		}
		System.out.println(month);	
		int monthnumber=Integer.parseInt(month);
		String monthno=Integer.toString(monthnumber-2);
		System.out.println(month);	
		
		do{
			 datamonth=driver.findElement(Month).getAttribute("data-month");
			    driver.findElement(NextMonth).click();
			    }while(!datamonth.equals(monthno));
		try {
		driver.findElement(Weekday).click();
		}
		catch(Exception e)
		{
			driver.findElement(Weekend).click();
		}
		Thread.sleep(3000);
		Select selectAdult= new Select(driver.findElement(Adults));
		selectAdult.selectByVisibleText(adults);
		Select selectChildren= new Select(driver.findElement(Children));
		selectChildren.selectByVisibleText(children);
		Select selectInfant= new Select(driver.findElement(Infant));
		selectInfant.selectByVisibleText(infant);
		Thread.sleep(3000);
		driver.findElement(MoreLinks).click();
		Select selectClass= new Select(driver.findElement(Class));
		selectClass.selectByVisibleText(airlineClass);
		System.out.println(airline);
		driver.findElement(PreferredAirlines).sendKeys("Jet");
		driver.findElement(MoreLinks).click();
		
		driver.findElement(Search).click();
	
	    if( !driver.getTitle().equals("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities"))
	    {
	    	driver.navigate().back();
	    }
	    	
		
		
	}*/
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
		driver.findElement(FromField).click();
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
	public void pickDate(String date,String iteration) throws Exception
	{
		System.out.println("HI");
		//Set<Cookie> allCookie=driver.manage().getCookies();
		//for ()
		int count=Integer.parseInt(iteration);
		driver.findElement(DepartDate).click();
        System.out.println(date+"Excel Date");
		if (date.charAt(0)=='0')//retrieving day
		{
			System.out.println("first0 Excel");
			 date1=Character.toString(date.charAt(1));
			 System.out.println(date1+"Excel Day");
		}
		else
		{
			date1=date.substring(0, 2);
			 System.out.println(date1+"Excel Day");
		}
		
		String datamonth;
		String month;
		if (date.charAt(3)=='0') //retrieve month d0d1-2m3m4-5y6y7
		{
			 month=Character.toString(date.charAt(4));
			 System.out.println("Excel Month"+month);
		}
		else
		{
			month=date.substring(3, 5);
			System.out.println("Excel Month "+month);
		}
		int monthnumber=Integer.parseInt(month);
		String monthno=Integer.toString(monthnumber-1);
		System.out.println(monthno+"ExcelMonth attribute");
		
		/*if(count==1) {//Initially current date is highlighted
		do{
			 datamonth=driver.findElement(Month).getAttribute("data-month");
			 System.out.println(datamonth+"Html datamonth");
			    driver.findElement(NextMonth).click();
			    }while(!datamonth.equals(monthno));
		try {
		driver.findElement(By.xpath("//td[@class=' undefined']/a[text()='"+date1+"']")).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//td[@class=' weekEnd undefined']/a[text()='"+date1+"']")).click();
		}}
		if(count!=1)//prev date is highlighted
		{*/
			do{
				    datamonth=driver.findElement(Month).getAttribute("data-month");
				    System.out.println(datamonth+"currentMonth");
				    System.out.println(Integer.parseInt(datamonth)+"Current datemonth html");
				    if(Integer.parseInt(datamonth)>Integer.parseInt(monthno))
				    {
				    	
				    	System.out.println("Move Backwards"); 
				    	 WebElement element =  driver.findElement(PrevMonth);
				    	JavascriptExecutor executor = (JavascriptExecutor)driver;
					    executor.executeScript("arguments[0].click();", element);
				    	//driver.findElement(PrevMonth).click();
				    }
				    else if(Integer.parseInt(datamonth)==Integer.parseInt(monthno))
				    {
				    	
				    }
				    else
				    {
				    	System.out.println("Move Forward"); 
				        driver.findElement(NextMonth).click();
				    }
				    }while(!datamonth.equals(monthno));
			try {
				driver.findElement(By.xpath("//td[@class=' undefined']/a[text()='"+date1+"']")).click();
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//td[@class=' weekEnd undefined']/a[text()='"+date1+"']")).click();
			}
		}
		
	//}
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
	public void selectClass(String airlineClass)
	{
		Select selectClass= new Select(driver.findElement(Class));
		selectClass.selectByVisibleText(airlineClass);
	}
	public void preferredAirlines(String airline)
	{
		driver.findElement(PreferredAirlines).sendKeys(airline);
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
			BaseForMasterExecute.captureScreenshot("InvalidLogin");
	    	System.out.println("refresh");
	    	driver.navigate().refresh();
		}
		
	}
	
}

//table[@class='calendar']/tr/td[text()='23'][contains(@data-month='0')][contains(data-year='2019')]

//table[@class=' undefined']/tr/td[text()='23'][contains(@data-month='0')][contains(data-year='2019')]


/*
 
For all weekdays:
	//td[@class=' undefined']
	
For only weekeneds:	 
	//td[@class=' weekEnd undefined']


For selecting a particular weekend:
//td[@class=' weekEnd undefined']/a[text()='19']
	
For selecting a particular weekday:	
	//td[@class=' undefined']/a[text()='23']	

	
For selecting a particular month:
	//div/span[@class='ui-datepicker-month'][text()='January']


For selecting a particular year:
	//div/span[@class='ui-datepicker-year'][text()='2019']
	 
	
	
	*/