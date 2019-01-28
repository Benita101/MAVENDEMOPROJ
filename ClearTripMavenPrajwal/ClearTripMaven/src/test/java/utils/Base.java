package utils;
import java.io.File;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.BookingFormFillingPOM;
import POM.BookingPagesClickingTestPOM;
import POM.FilterPOM;
import POM.ForgotPasswordPOM;
import POM.HotelPOM;
import POM.LoginPOM;
import POM.ModifyPOM;
import POM.MultiwayPom;
import POM.OneWaySearchPOM;
import POM.RegisterPOM;
import POM.RoundTripPom;
import POM.YourTripPOM;


public class Base{
	
	public static WebDriver driver;
	public WebDriverWait explicitwait;
	public RegisterPOM register;
	public LoginPOM login;
	public ForgotPasswordPOM forgotPwd;
	public BookingPagesClickingTestPOM bookClickTest;
	public BookingFormFillingPOM formFill;
	public MultiwayPom multiway;
	public OneWaySearchPOM oneway;
	public YourTripPOM yourTrip;
	public RoundTripPom roundTrip;	
	public FilterPOM filter;
	public HotelPOM hotel;
	public JavascriptExecutor executor;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public Properties prop;
	public ModifyPOM modify;
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
{
			//System.setProperty("webdriver.chrome.driver", "C:\\1SEL\\chromedriver.exe");
			System.setProperty(prop.getProperty("BrowserName"), prop.getProperty("DriverPath"));
		    driver=new ChromeDriver();
		    e_driver=new EventFiringWebDriver(driver);
		    eventListener=new WebEventListener();
		    e_driver.register(eventListener);
		    driver=e_driver;
		    
		    driver.manage().window().maximize();
		//    driver.get("https://www.cleartrip.com");
		    driver.get(prop.getProperty("DefaultURL"));
		  
}
		else if(browser.equalsIgnoreCase("firefox"))
		{
					System.setProperty("webdriver.gecko.driver", "C:\\1SEL\\geckodriver.exe");
				   driver=new FirefoxDriver();
				   driver.manage().window().maximize();
				   driver.get("https://www.cleartrip.com");
		}
		
 
}
	public static void captureScreenshot(String name) throws Exception
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		System.out.println(screen);
		File src=screen.getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		String screenshotName =name+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(screenshotName);
		
		FileUtils.copyFile(src, new File(".\\drivers\\"+screenshotName));
		
	}
	
	}
