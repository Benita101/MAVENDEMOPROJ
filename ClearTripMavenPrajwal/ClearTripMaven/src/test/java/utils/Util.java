
package utils;

import java.io.File;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Util 
{	static WebDriver w;
	/*public static WebDriver startBrowser(String Location)
	{	
		if(Location.contains("chrome") )
		{
			System.setProperty("webdriver.chrome.driver", Location);
			w=new ChromeDriver();
		}
		else if(Location.contains("gecko") )
		{
			System.setProperty("webdriver.gecko.driver", Location);
			w=new FirefoxDriver();
		}
		w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return w;
		
	}*/
	public static void captureScreenshot(String name) throws Exception
	{
		TakesScreenshot screen=(TakesScreenshot)w;
		File src=screen.getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		String screenshotName =name+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(screenshotName);
		
		FileUtils.copyFile(src, new File(".\\drivers\\"+screenshotName));
		
	}
	
	
	public static void verifyOnVisibilty(int time,By ByLocator,String ScreenName,String Message) throws Exception
	{
		try{
			new WebDriverWait(w, time).until(ExpectedConditions.visibilityOf(w.findElement(ByLocator)));
		}
		catch(TimeoutException TimeOut)
		{
			captureScreenshot(ScreenName);
			Assert.fail(Message);
		}
	}
	public static void verifyOnInVisibilty(int time,By ByLocator,String ScreenName,String Message) throws Exception
	{
		try{
			new WebDriverWait(w, time).until(ExpectedConditions.invisibilityOf(w.findElement(ByLocator)));
		}
		catch(TimeoutException TimeOut)
		{
			captureScreenshot(ScreenName);
			Assert.fail(Message);

		}
	}
	
	public static void checkAssertion(String actual,String expected,String ScreenName,String Message) throws Exception{
		try {
			Assert.assertEquals(actual, expected,Message);
		} catch(AssertionError ae){
			captureScreenshot(ScreenName);
			Assert.fail(Message);
		}
	}
	
	public static void checkAssertion(boolean actual,boolean expected,String ScreenName,String Message) throws Exception{
		try {
			Assert.assertEquals(actual, expected,Message);
		} catch(AssertionError ae){
			captureScreenshot(ScreenName);
			Assert.fail(Message);

		}
	}
	
}
