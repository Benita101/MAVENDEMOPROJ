package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyConfig2
{
	WebDriverWait explicitwait;
	public KeyConfig2(WebDriverWait explicitwait){
		  this.explicitwait=explicitwait;
	  }
	
	static Select s;
	static WebDriver w;
	public static WebDriver openBrowser(String Location)
	{
		if(Location.contains("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",Location);
		w=new ChromeDriver();
		w.manage().window().maximize();
		}
		else if(Location.contains("gecko"))
		{
		System.setProperty("webdriver.gecko.driver",Location);
		w=new FirefoxDriver();
		w.manage().window().maximize();
		}
		return w;
	}
	
	public static void openUrl(String URL)
	{
		w.get(URL);
	}
	
	public static void enterText(String Locator,String LocatorValue,String inputdata)
	{
		if(Locator.equals("name"))
		{
			w.findElement(By.name(LocatorValue)).sendKeys(inputdata);
		}
		else if(Locator.equals("id"))
		{
			w.findElement(By.id(LocatorValue)).sendKeys(inputdata);
		}
		else if(Locator.equals("css"))
		{
			w.findElement(By.cssSelector(LocatorValue)).sendKeys(inputdata);
		}
		else if(Locator.equals("link"))
		{
			w.findElement(By.linkText(LocatorValue)).sendKeys(inputdata);
		}
		else if(Locator.equals("xpath"))
		{
			w.findElement(By.xpath(LocatorValue)).sendKeys(inputdata);
		}
		else
		{
			System.out.println("No such Attribute/Identifier found.");
		}
	}
	
	public static void click(String Locator,String LocatorValue)
	{
		if(Locator.equals("name"))
		{
			w.findElement(By.name(LocatorValue)).click();;
		}
		else if(Locator.equals("id"))
		{
			w.findElement(By.id(LocatorValue)).click();;
		}
		else if(Locator.equals("css"))
		{
			w.findElement(By.cssSelector(LocatorValue)).click();;
		}
		else if(Locator.equals("link"))
		{
			w.findElement(By.linkText(LocatorValue)).click();;
		}
		else if(Locator.equals("xpath"))
		{
			w.findElement(By.xpath(LocatorValue)).click();;
		}
		else 
		{
			System.out.println("No such Attribute/Identifier found.");
		}
		
	}

	public static void dropdownSelect(String Locator, String LocatorValue, String inputdata) 
	{		
		if(Locator.equals("name"))
		{
			 s= new Select(w.findElement(By.name(LocatorValue)));
			 s.selectByVisibleText(inputdata);
		}
		else if(Locator.equals("id"))
		{
			s= new Select(w.findElement(By.id(LocatorValue)));
			 s.selectByVisibleText(inputdata);
		}
		else if(Locator.equals("css"))
		{
			s= new Select(w.findElement(By.cssSelector(LocatorValue)));
			 s.selectByVisibleText(inputdata);
		}
		else if(Locator.equals("link"))
		{
			s= new Select(w.findElement(By.linkText(LocatorValue)));
			 s.selectByVisibleText(inputdata);
		}
		else if(Locator.equals("xpath"))
		{
			s= new Select(w.findElement(By.xpath(LocatorValue)));
			 s.selectByVisibleText(inputdata);
		}
		else 
		{
			System.out.println("No such Attribute/Identifier found.");
		}
		
	}
	
	public static void explicitWait(String Locator, String LocatorValue, WebDriverWait explicitwait) {

	
		if(Locator.equals("name"))
		{
			 explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));
		}
		else if(Locator.equals("id"))
		{
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
		}
		else if(Locator.equals("css"))
		{
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LocatorValue)));
		}
		else if(Locator.equals("link"))
		{
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LocatorValue)));
		}
		else if(Locator.equals("xpath"))
		{
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
		}
		else if(Locator.equals("class"))
		{
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.className(LocatorValue)));
		}
		else 
		{
			System.out.println("No such Attribute/Identifier found.");
		}
	}
		
		
		public static void sleep(int waitTime) throws Exception 
		{
			Thread.sleep(waitTime);
		}
		
				
		/*switch(Locator)
		{
		case "name":
			 explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));
			break;
		case "id":
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
			break;
		case "css":
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LocatorValue)));
			break;
		case "link":
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LocatorValue)));
			break;
		case "xpath":
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
			break;
			
			
		default:
			System.out.println("Invalid Locator Specified");	
		}}
	*/
	
}