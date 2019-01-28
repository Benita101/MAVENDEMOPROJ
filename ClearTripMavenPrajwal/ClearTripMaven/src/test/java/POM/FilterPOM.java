package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FilterPOM {
	JavascriptExecutor executor;
	WebDriver driver;
	public FilterPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	By stopZero=By.xpath("//*[contains(text(),'0 stop')]");
	By Zero=By.xpath("//*[@id=\"ResultContainer_1_1\"]/section[2]/section/aside[1]/div/div[1]/form/div[2]/div[1]/div[2]/div/nav/ul/li[1]/label");
	By stopOne=By.xpath("//*[contains(text(),'1 stop')]");
	By One=By.xpath("//*[@id=\"ResultContainer_1_1\"]/section[2]/section/aside[1]/div/div[1]/form/div[2]/div[1]/div[2]/div/nav/ul/li[2]/label]");
	By stopTwo=By.xpath("//*[contains(text(),'2 stop')]");
	By Two=By.xpath("//*[@id=\"ResultContainer_1_1\"]/section[2]/section/aside[1]/div/div[1]/form/div[2]/div[1]/div[2]/div/nav/ul/li[3]/label");
	By earlyMrng=By.xpath("//*[contains(text(),'Early Morning')]");
	By mrng=By.xpath("//*[contains(text(),'8am - 12pm')]");
	By midDay=By.xpath("//*[contains(text(),'Mid-Day')]");
	By evening=By.xpath("//*[contains(text(),'Evening')]");
	By night=By.xpath("//*[contains(text(),'Night')]");
	By all=By.xpath("//*[contains(text(),'Show multi-airline itineraries')]");
	By airIndia=By.xpath("//*[contains(text(),'Air India')]");
	By goAir=By.xpath("//*[contains(text(),'GoAir')]");
	By showAll=By.xpath("//div[@id='ResultContainer_2_1']//a[@class='showAll weak fRight'][contains(text(),'Show all')]");
	By tripDuration=By.xpath("//div[@id='ResultContainer_2_1']//div[contains(@class,'commonFilters')]//div[7]//h5[1]");
	By layoverDuration=By.xpath("//div[@id='ResultContainer_2_1']//div[contains(@class,'commonFilters')]//div[8]//h5[1]");
	By Search=By.id("SearchBtn");
	By modify=By.xpath("//*[@id=\"modifySearchLink\"]/i");
	
	public void clickStops() throws Exception {
		
		try {
		WebDriverWait explicitwait= new WebDriverWait(driver, 50);
		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div[2]/div/div/div/h6")));
		}
		catch(Exception e){
			
		}
		System.out.println("In click stops");
		try {
		driver.findElement(stopZero).click();
		}catch(Exception e)
		{
			try {
			driver.findElement(Zero).click();
			}catch(Exception e1)
			{
			System.out.println("No 0 stop flights Found");
		}}
	
		try {
			driver.findElement(stopOne).click();
		}catch(Exception e)
		{
			try {
				driver.findElement(One).click();
				}catch(Exception e1)
				{
				System.out.println("No 1 stop flights Found");
			}
		}

	try {
		driver.findElement(stopTwo).click();
	}catch(Exception e)
	{
		try {
			driver.findElement(Two).click();
		}catch(Exception e1)
		{
		System.out.println("No 2 stop flights Found");
	}
	}

	}
	
	public void clickTime () throws Exception {
        try {
		driver.findElement(earlyMrng).click();
		
		
        }catch(Exception e)
        {
        	System.out.println("No early morning flights found");
        }
        driver.findElement(earlyMrng).click();
	 try {
		
			driver.findElement(mrng).click();
	        }catch(Exception e)
	        {
	        	System.out.println("No mrng flights found");
	        }
	 driver.findElement(mrng).click();
	 //driver.findElement(modify).click();
	 try {
		
			driver.findElement(midDay).click();
	        }catch(Exception e)
	        {
	        	System.out.println("No midDay flights found");
	        }
	 driver.findElement(midDay).click();
	 try {
			driver.findElement(evening).click();
	        }catch(Exception e)
	        {
	        	System.out.println("No evening flights found");
	        }
	 driver.findElement(evening).click();
	 try {
			driver.findElement(night).click();
	        }catch(Exception e)
	        {
	        	System.out.println("No Night flights found");
	        }

	Thread.sleep(5000);

	}
	public void clickReturnTime () throws Exception {
		
		try {
			driver.findElements(earlyMrng).get(0).click();
						
	        }catch(Exception e)
	        {
	        	System.out.println("No early morning flights found");
	        }
		driver.findElements(earlyMrng).get(0).click();
		 try {
			
				driver.findElements(mrng).get(0).click();
		        }catch(Exception e)
		        {
		        	System.out.println("No mrng flights found");
		        }
		 driver.findElements(mrng).get(0).click();
	
		 try {
			
				driver.findElements(midDay).get(0).click();
		        }catch(Exception e)
		        {
		        	System.out.println("No midDay flights found");
		        }
		 driver.findElements(midDay).get(0).click();
		 try {
				driver.findElements(evening).get(0).click();
		        }catch(Exception e)
		        {
		        	System.out.println("No evening flights found");
		        }
		 driver.findElements(evening).get(0).click();
		 try {
				driver.findElements(night).get(0).click();
		        }catch(Exception e)
		        {
		        	System.out.println("No Night flights found");
		        }
		 driver.findElements(night).get(0).click();
		
		 try {
				driver.findElements(earlyMrng).get(1).click();
							
		        }catch(Exception e)
		        {
		        	System.out.println("No early morning flights found");
		        }
			driver.findElements(earlyMrng).get(1).click();
			 try {
				
					driver.findElements(mrng).get(1).click();
			        }catch(Exception e)
			        {
			        	System.out.println("No mrng return flights found");
			        }
			 driver.findElements(mrng).get(1).click();
		
			 try {
				
					driver.findElements(midDay).get(1).click();
			        }catch(Exception e)
			        {
			        	System.out.println("No midDay return flights found");
			        }
			 driver.findElements(midDay).get(1).click();
			 try {
					driver.findElements(evening).get(1).click();
			        }catch(Exception e)
			        {
			        	System.out.println("No evening return flights found");
			        }
			 driver.findElements(evening).get(1).click();
			 try {
					driver.findElements(night).get(1).click();
			        }catch(Exception e)
			        {
			        	System.out.println("No Night return flights found");
			        }
			 driver.findElements(night).get(1).click();

		}
	
	public void clickAirlines () throws Exception {
		
	 try {
	driver.findElement(airIndia).click();
	 }
	 catch(Exception e)
	 {
		 System.out.println("Air India not found");
	
	 }
	 try {
	driver.findElement(goAir).click();
	 }
	 catch(Exception e)
	 {
		 System.out.println("goAir not found");
	 }

	//driver.findElement(By.linkText("Show all")).click();
	 
	}
	  public void searchWithoutBack() {
		  System.out.println("In search without back");
			driver.findElement(Search).click();
	  }
	 
	  
	  /*public void clickTest()
	  {
		  List<WebElement> allFiltersTest =driver.findElements(By.xpath("/html[1]/body[1]/section[3]/div[2]/section[2]/section[1]/aside[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li/label[1]"));
		  for(int p=0; p<allFiltersTest.size(); p++)
		  {
		  	allFiltersTest.get(p).click();
		  }
		  //List<WebElement> allTimeTest =driver.findElements(By.xpath("/html[1]/body[1]/section[3]/div[2]/section[2]/section[1]/aside[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li/label[1]"));

	  }*/
	  
	  
	  
	  
	  
	  
	  
	  
}
