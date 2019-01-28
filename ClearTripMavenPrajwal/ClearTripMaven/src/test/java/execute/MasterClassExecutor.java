package execute;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.BookingFormFillingPOM;
import POM.BookingPagesClickingTestPOM;
import POM.FilterPOM;
import POM.LoginPOM;
import POM.MultiwayPom;
import POM.OneWaySearchPOM;
import POM.RegisterPOM;
import POM.RoundTripPom;
import utils.Base;
import utils.BaseForMasterExecute;
import utils.Excel;
import utils.KeyConfig2;

public class MasterClassExecutor extends BaseForMasterExecute {
	

		@Test(priority =1,dataProvider = "RegisterData")
		public void RegisterTest(String emailReg,String password1, String visible, String name, String lastName, String phone) throws Exception { 
			register = new RegisterPOM(driver);
			register.registerProcess(emailReg, password1,visible,name,lastName,phone);
			register.signOut();
			
		}
			
		
		@DataProvider
		public Object[][] RegisterData() throws Exception
		{
			Object data[][]=Excel.MyDataProvider("Register", 6);
			return data;
		}
		
	
	
	

		@Test(priority =2,dataProvider = "LoginData")
		public void loginTest(String username, String password) throws Exception {
			login = new LoginPOM(driver);
			login.loginProcess(username, password);
			login.signOut();

		}

		@DataProvider
		public Object[][] LoginData() throws Exception {

			Object data[][] = Excel.MyDataProvider("Login", 2);
			return data;
		}
		

 @Test(priority=3,dataProvider="oneWaySearchData")
	public void OneWaySearch(String from,String to,String date,String adults,String children,String infant,String airClass,String airline,String count) throws Exception 
	{
			
		
		
			 
			 oneway = new OneWaySearchPOM(driver);
			 oneway.enterFrom(from);
			 oneway.enterTo(to);
			 oneway.pickDate(date,count);
			 oneway.selectAdult(adults);
			 oneway.selectChildren(children);
			 oneway.selectInfant(infant);
			 oneway.MoreLink();
			 oneway.selectClass(airClass);
			 oneway.preferredAirlines(airline);
			 oneway.MoreLink();
			 oneway.searchFlights();
			 
		  }
			  	  
		  @DataProvider
		  public Object[][] oneWaySearchData() throws Exception
		  {
			Object data[][]=Excel.MyDataProvider(prop.getProperty("ExcelOneWaySearchSheet"), 9);
			return data;
			  
		  }

		  @Test(priority =4)
		  public void f() throws Exception  {
			      filter=new FilterPOM(driver);
				  filter.clickStops();
				  filter.clickTime();
				  filter.clickAirlines();
			 
			
		  }
		
		
	@Test(priority =5)
	public void oneWayBook() throws Exception 
	{
			//bookClickTest = new BookingPagesClickingTestPOM(driver);
			//formFill = new BookingFormFillingPOM(driver);
			//explicitwait = new WebDriverWait(driver, 30);
			
			Excel.ExcelConfig(prop.getProperty("ExcelFilePath"),prop.getProperty("ExcelOneWayBookSheet")); 
			
			for(int i=1;i<=Excel.ROWNUM();i++)
			{
				String A=Excel.Read(i, 0);
				System.out.println(A);
				if(A.equals("testAllClickables"))
				{
//					executor = (JavascriptExecutor)driver;
					bookClickTest.clickingTest(executor);				
				}
				else if(A.equals("explicitWait"))
				{
					KeyConfig2.explicitWait(Excel.Read(i, 1), Excel.Read(i, 3), explicitwait);
				}
				else if(A.equals("openUrl"))
				{
					KeyConfig2.openUrl(Excel.Read(i, 3));
				}
				else if(A.equals("sleep"))
				{
					String sleepTime = Excel.Read(i, 3);
					int a=Integer.parseInt(sleepTime);
					KeyConfig2.sleep(a);
				}
				else if(A.equals("bookOneWayFlight"))
				{
					String flightNumber = Excel.Read(i, 3);
					int flightIndex = Integer.parseInt(flightNumber);
//					executor = (JavascriptExecutor)driver;
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
			}
	}
		

@Test(priority =5,dataProvider="RoundTripSearchData")
public void roundTripTest(String from,String to,String date,String retdate,String adults,String children,String infant,String airClass,String airline) throws Exception {
	 
	  
	  roundTrip = new RoundTripPom(driver);
     
	 roundTrip.goToHome(prop.getProperty("DefaultURL"));
	 roundTrip.goToRoundTrip();
	 roundTrip.enterFrom(from);
	 roundTrip.enterTo(to);
	 roundTrip.enterDate(date);
	 roundTrip.enterReturnDate(retdate);
	 roundTrip.selectAdult(adults);
	 roundTrip.selectChildren(children);
	 roundTrip.selectInfant(infant);
	 roundTrip.MoreLink();
	 roundTrip.selectClass(airClass);
	 roundTrip.preferredAirlines(airline);
	 roundTrip.MoreLink();
	 roundTrip.searchFlights();
	  
	  }


@DataProvider
public Object[][] RoundTripSearchData() throws Exception
{
	Object data[][]=Excel.MyDataProvider("RoundTrip", 9);
	return data;
	  
}
	
@Test(priority =6)
public void filterRound() throws Exception  {
	      filter=new FilterPOM(driver);
		  filter.clickStops();
		  filter.clickReturnTime();
		  filter.clickAirlines();
	 
	
}
	@Test(priority =7)
	public void roundTripBook() throws Exception 
	{
//		bookClickTest = new BookingPagesClickingTestPOM(driver);
//		formFill = new BookingFormFillingPOM(driver);
//		explicitwait = new WebDriverWait(driver, 50);
		
		Excel.ExcelConfig(prop.getProperty("ExcelFilePath"),prop.getProperty("ExcelRoundTripBookSheet")); 
		
		for(int i=1;i<=Excel.ROWNUM();i++)
		{
			String A=Excel.Read(i, 0);
			
			if(A.equals("explicitWait"))
			{
				KeyConfig2.explicitWait(Excel.Read(i, 1), Excel.Read(i, 3), explicitwait);
			}
			else if(A.equals("openUrl"))
			{
				KeyConfig2.openUrl(Excel.Read(i, 3));
			}
			else if(A.equals("sleep"))
			{
				String sleepTime = Excel.Read(i, 3);
				int a=Integer.parseInt(sleepTime);
				KeyConfig2.sleep(a);
			}
			else if(A.equals("bookReturnFlight"))
			{
//				executor = (JavascriptExecutor)driver;
				driver.findElement(By.cssSelector(".colZero:nth-child(1) li:nth-child(" + Excel.Read(i, 2) +") > .listItem")).click();
				driver.findElement(By.cssSelector(".colZero:nth-child(2) > .listViewNav:nth-child(2) li:nth-child(" + Excel.Read(i, 3) +") input:nth-child(1)")).click();
				driver.findElement(By.xpath("//div[@id='ResultContainer_1_1']//button[@type='submit'][contains(text(),'Book')]")).click();
				
				Thread.sleep(3000);
				try {
					Assert.assertEquals(driver.getTitle(), "Cleartrip | Book your flight securely in simple steps");
					
				}
				catch (Exception E)
				{
///////////////////////////////////////////////////////// SCREENSHOT LOGIN TO BE PLACED HERE ////////////////////////////////////////////////////////
					System.out.println("");
				}
				
				
				formFill.formFilling(i, executor, explicitwait, A);
			}
		}
	}
	
	@Test(priority =8,dataProvider="MultiwaySearchData")
	  public void multiwaySearch(String from1,String to1,String date1,String to2,String date2,String to3,String date3,String adults,String children,String infant,String airClass) throws Exception {
		  multiway=new MultiwayPom(driver);
		      
		  multiway.goToHome(prop.getProperty("DefaultURL"));
			  multiway.goMultiTrip();
			  multiway.enterFromOne(from1);
			  multiway.enterToOne(to1);
			  multiway.enterDateOne(date1);
			  multiway.goFromTwo();
			  
			  multiway.enterToTwo(to2);
			  
			  
			  multiway.enterDateTwo(date2);
			  multiway.goFromThree();
			  
			  multiway.enterToThree(to3);
			  multiway.enterDateThree(date3);
			 
			  multiway.selectAdult(adults);
			  multiway.selectChildren(children);
			  multiway.selectInfant(infant);
			  multiway.selectClass(airClass);
			  multiway.searchFlights();
		  
	  }
	  @DataProvider
	  public Object[][] MultiwaySearchData() throws Exception
	  {
		Object data[][]=Excel.MyDataProvider("MultiCity", 11);
		return data;
		  
	  }
	  @Test(priority =9)
		public void filter() throws Exception  {
			      filter=new FilterPOM(driver);
				  filter.clickStops();
				  filter.clickTime();
				  filter.clickAirlines();
			 
			
		}
	
	@Test(priority =10)
	public void multiCityBook() throws Exception 
	{
//		bookClickTest = new BookingPagesClickingTestPOM(driver);
//		formFill = new BookingFormFillingPOM(driver);
//		explicitwait = new WebDriverWait(driver, 50);
		
		Excel.ExcelConfig(prop.getProperty("ExcelFilePath"), prop.getProperty("ExcelMultiCityBookSheet")); 
		
		for(int i=1;i<=Excel.ROWNUM();i++)
		{
			String A=Excel.Read(i, 0);
			
			if(A.equals("explicitWait"))
			{
				KeyConfig2.explicitWait(Excel.Read(i, 1), Excel.Read(i, 3), explicitwait);
			}
			else if(A.equals("openUrl"))
			{
				KeyConfig2.openUrl(Excel.Read(i, 3));
			}
			else if(A.equals("sleep"))
			{
				String sleepTime = Excel.Read(i, 3);
				int a=Integer.parseInt(sleepTime);
				KeyConfig2.sleep(a);
			}
			else if(A.equals("bookMutiCityFlight"))
			{
//				executor = (JavascriptExecutor)driver;
				driver.findElement(By.cssSelector(".colZero:nth-child(1) > .listViewNav:nth-child(2) li:nth-child(" +Excel.Read(i, 2) +") input:nth-child(1)")).click();
				driver.findElement(By.cssSelector(".colZero:nth-child(2) > .listViewNav:nth-child(2) li:nth-child(" +Excel.Read(i, 3)+ ") input:nth-child(1)")).click();
				driver.findElement(By.cssSelector(".colZero:nth-child(3) li:nth-child(" +Excel.Read(i, 4)+ ") input:nth-child(1)")).click();
				driver.findElement(By.xpath("//div[@id='ResultContainer_1_1']//button[@type='submit'][contains(text(),'Book')]")).click();
				formFill.formFilling(i, executor, explicitwait, A);
			}
		}
	}
	
}
	


