package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Base;

public class YourTripPOM{
	WebDriver driver;
	YourTripPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By YourTrip = By.xpath("//*[contains(text(), 'Your trips')]");
	By Cancellation = By.xpath("//*[@id=\"userAccountMenu\"]/li[1]/ul/li[3]/ul/li[2]/a");
	By ChangeFlight =By.xpath("//li[contains(@class,'userAccountCol quickTools')]//ul//li[3]//a[1]");
	//By ChangePNR= By.xpath("//*[contains(text(), 'Check PNR Status')]");
	By PrintTicket= By.xpath("//li[@class='menuItem listMenuContainer userAccountMenuContainer']//ul//li[7]//a[1]");
	//By PrintHotelVoucher= By.xpath("//*[contains(text(), 'Print hotel voucher')]");
	
	public void yourTrip() throws Exception
{
		driver.findElement(YourTrip).click();
		Thread.sleep(1000);
		
}
	public void cancellation() throws Exception {
		
		WebElement element =  driver.findElement(Cancellation);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	    
		System.out.println(driver.getTitle());
	    if( driver.getTitle().equals("Cleartrip Account"))
	    {
	    	System.out.println("in else");
	    	driver.navigate().back();
	    }
	    else 
	    {
	    	element =  driver.findElement(Cancellation);
	    	executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
		    
	    }
		Thread.sleep(1000);
	}
	
	public void changeFlight() throws Exception 
	{
		//driver.findElement(ChangeFlight).click();
		

		WebElement element =  driver.findElement(ChangeFlight);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	    
		
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	    if( driver.getTitle().equals("Cleartrip Account"))
	    {
	    	System.out.println("in else");
	    	driver.navigate().back();;
	    }
	    else 
	    {
	    	element =  driver.findElement(ChangeFlight);
	    	executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
	    }
	    Thread.sleep(1000);
		
	}
	
	/*public void changePNR() throws Exception {
		//driver.findElement(ChangePNR).click();
		
		WebElement element =  driver.findElement(ChangePNR);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	    
		System.out.println(driver.getTitle());
	    if( driver.getTitle().equals("IRCTC Railway PNR Status, Passenger Researvation Inquiry | Cleartrip"))
	    {
	    	System.out.println("in else");
	    	driver.navigate().back();;
	    }
	    else 
	    {
	    element =  driver.findElement(ChangePNR);
	    	executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
		    
	    }
		
		Thread.sleep(1000);
		*/
	//}
	public void printTicket() throws Exception {
		//driver.findElement(PrintTicket).click();
		
		WebElement element =  driver.findElement(PrintTicket);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	    
		Thread.sleep(1000);
		
		  if( driver.getTitle().equals("Ticket Printer | Cleartrip"))
		    {
		    	System.out.println("in else");
		    	driver.navigate().back();;
		    }
		    else 
		    {
		    	 element =  driver.findElement(PrintTicket);
		    	executor = (JavascriptExecutor)driver;
			    executor.executeScript("arguments[0].click();", element);
			    
		    }
			
			Thread.sleep(1000);
			
		
	}
	/*public void printHotelVoucher() throws Exception {
		//driver.findElement(PrintHotelVoucher).click();
		
		WebElement element =  driver.findElement(PrintHotelVoucher);
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	    
		if( driver.getTitle().equals("Ticket Printer | Cleartrip"))
	    {
	    	System.out.println("in else");
	    	driver.navigate().back();;
	    }
	    else 
	    {
	    	element =  driver.findElement(PrintHotelVoucher);
	    	executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
		    
	    }
	
		Thread.sleep(1000);
	}*/
}
