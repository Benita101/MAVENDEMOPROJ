package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.BookingFormFillingPOM;
import POM.BookingPagesClickingTestPOM;
import POM.FilterPOM;
import POM.ForgotPasswordPOM;
import POM.HotelPOM;
import POM.LoginPOM;
import POM.MultiwayPom;
import POM.OneWaySearchPOM;
import POM.RegisterPOM;
import POM.RoundTripPom;
import POM.YourTripPOM;


public class BaseForMasterExecute{
	
	public static WebDriver driver;
	public WebDriverWait explicitwait;
	public RegisterPOM register;
	public LoginPOM login;
	public ForgotPasswordPOM forgotPwd;
	public BookingPagesClickingTestPOM bookClickTest;
	public BookingFormFillingPOM formFill;
	public MultiwayPom multiway;
	public OneWaySearchPOM oneway;
	public RoundTripPom roundTrip;
	public JavascriptExecutor executor;
	public FilterPOM filter;
	public HotelPOM hotel;
	public YourTripPOM yourTrip;
	public Properties prop;
	
	@BeforeTest
	public void beforeTest() throws Exception
	{
			prop = new Properties();
			prop.load(new FileInputStream(".\\constant.property"));
			System.setProperty(prop.getProperty("BrowserName"), prop.getProperty("DriverPath"));
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
//		    driver.get("https://www.cleartrip.com/flights/results?from1=CCU&to1=BOM&depart_date_1=14/04/2019&multicity=true&from2=BOM&to2=DEL&depart_date_2=28/04/2019&from3=DEL&to3=GOI&depart_date_3=23/05/2019&adults=5&childs=3&infants=3&class=Economy&intl=n&num_legs=3&sd=1548413159185");
		    driver.get(prop.getProperty("DefaultURL"));
		    
		    bookClickTest = new BookingPagesClickingTestPOM(driver);
		    formFill = new BookingFormFillingPOM(driver);
		    executor = (JavascriptExecutor)driver;
		    login = new LoginPOM(driver);
		    register = new RegisterPOM(driver);
		    explicitwait = new WebDriverWait(driver, 50);
		    roundTrip = new RoundTripPom(driver);
		    oneway = new OneWaySearchPOM(driver);
		    multiway = new MultiwayPom(driver);
		    Excel.ExcelConfig(prop.getProperty("ExcelFilePath"), prop.getProperty("ExcelRegisterSheet"));
		   
	}
	 public static void captureScreenshot(String name) throws Exception
		{
			TakesScreenshot screen=(TakesScreenshot)driver;
			File src=screen.getScreenshotAs(OutputType.FILE);
			Date d= new Date();
			String screenshotName =name+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
			System.out.println(screenshotName);
			
			FileUtils.copyFile(src, new File(".\\drivers\\"+screenshotName));
			
		}
}