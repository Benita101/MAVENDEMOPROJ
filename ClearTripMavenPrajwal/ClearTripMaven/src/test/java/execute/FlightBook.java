package execute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Base;
import utils.Excel;
import utils.KeyConfig2;

public class FlightBook extends Base
{
	public JavascriptExecutor executor;
	
  @Test
  public void f() throws Exception
  {
	  
	 
	  
//	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	Excel.ExcelConfig("D:\\ClearTrip\\ClearTripFlight.xlsx","BookKeywords");
		
		for(int i=1;i<=Excel.ROWNUM();i++)
		{
			String A=Excel.Read(i, 0);
			if(A.equals("openBrowser"))
			{
				KeyConfig2.openBrowser(Excel.Read(i, 3));
			}
			else if(A.equals("openUrl"))
			{
				KeyConfig2.openUrl(Excel.Read(i, 3));
			}
			else if(A.equals("entetText"))
			{
				KeyConfig2.enterText(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
			}
			else if(A.equals("click"))
			{
				KeyConfig2.click(Excel.Read(i, 1), Excel.Read(i, 2));
			}
			else if(A.equals("dropdownSelect"))
			{
				KeyConfig2.dropdownSelect(Excel.Read(i, 1), Excel.Read(i, 2), Excel.Read(i, 3));
			}
			else if(A.equals("explicitWait"))
			{
				KeyConfig2.explicitWait(Excel.Read(i, 1), Excel.Read(i, 3), explicitwait);
			}
			else if(A.equals("sleep"))
			{
				String sleepTime = Excel.Read(i, 3);
				int a=Integer.parseInt(sleepTime);
				KeyConfig2.sleep(a);
			}
			else if(A.equals("testAllClickables"))
			{
				executor = (JavascriptExecutor)driver;
				bookClickTest.clickingTest(executor);				
			}
			else if(A.equals("bookOneWayFlight"))
			{
				String flightNumber = Excel.Read(i, 3);
				int flightIndex = Integer.parseInt(flightNumber);
				executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(".listItem:nth-child(" + flightIndex + ") .booking")));
				executor.executeScript("window.scrollBy(0,-200)");
					if(flightIndex==1)
					{
						executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".showTabs .booking")));
					}
					else
					{
						executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".listItem:nth-child(" + flightIndex + ") .booking")));
					}
				
				formFill.formFilling(i, executor, explicitwait, A);
				
			}
			else if(A.equals("bookReturnFlight"))
			{
				executor = (JavascriptExecutor)driver;
				driver.findElement(By.cssSelector(".colZero:nth-child(1) li:nth-child(" + Excel.Read(i, 2) +") > .listItem")).click();
				driver.findElement(By.cssSelector(".colZero:nth-child(2) > .listViewNav:nth-child(2) li:nth-child(" + Excel.Read(i, 3) +") input:nth-child(1)")).click();
				driver.findElement(By.xpath("//div[@id='ResultContainer_1_1']//button[@type='submit'][contains(text(),'Book')]")).click();
				
/*				Thread.sleep(3000);
				try {
					Assert.assertEquals(driver.getTitle(), "Cleartrip | Book your flight securely in simple steps");
					
				}
				catch (Exception E)
				{
///////////////////////////////////////////////////////// SCREENSHOT LOGIN TO BE PLACED HERE ////////////////////////////////////////////////////////
					System.out.println("");
				}*/
				
				formFill.formFilling(i, executor, explicitwait, A);
			}
			else if(A.equals("bookMutiCityFlight"))
			{
				executor = (JavascriptExecutor)driver;
				driver.findElement(By.cssSelector(".colZero:nth-child(1) > .listViewNav:nth-child(2) li:nth-child(" +Excel.Read(i, 2) +") input:nth-child(1)")).click();
				driver.findElement(By.cssSelector(".colZero:nth-child(2) > .listViewNav:nth-child(2) li:nth-child(" +Excel.Read(i, 3)+ ") input:nth-child(1)")).click();
				driver.findElement(By.cssSelector(".colZero:nth-child(3) li:nth-child(" +Excel.Read(i, 4)+ ") input:nth-child(1)")).click();
				driver.findElement(By.xpath("//div[@id='ResultContainer_1_1']//button[@type='submit'][contains(text(),'Book')]")).click();
				formFill.formFilling(i, executor, explicitwait, A);
			}
		}
  }
}
