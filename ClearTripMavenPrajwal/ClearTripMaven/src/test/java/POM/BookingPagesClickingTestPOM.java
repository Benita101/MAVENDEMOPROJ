package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BookingPagesClickingTestPOM {
	
	WebDriver driver;
	public BookingPagesClickingTestPOM(WebDriver driver1) {
		driver=driver1;
	}
	
	By modifySearch = By.id("modifySearchLink");
	By showAllButton = By.linkText("Show all");
	By airlineFilter = By.linkText("Airline");
	By departFiler = By.linkText("Depart");
	By durationFiler = By.linkText("Duration");
	By priceFilter = By.linkText("Price");
	By flightIternaryFilter = By.linkText("Flight itinerary");
	By fareRulesFilter = By.linkText("Fare rules");
	By baggageInformationFilter = By.linkText("Baggage Information");
	
	
	
	public void clickingTest(JavascriptExecutor executor) throws Exception
	{
		Thread.sleep(4000);
		executor.executeScript("arguments[0].click();", driver.findElement(modifySearch));
		executor.executeScript("arguments[0].click();", driver.findElement(modifySearch));
//		driver.findElement(modifySearch).click();
//		driver.findElement(modifySearch).click();
		driver.findElement(showAllButton).click();
		driver.findElement(airlineFilter).click();
		driver.findElement(departFiler).click();
		driver.findElement(durationFiler).click();
		driver.findElement(priceFilter).click();
		driver.findElement(flightIternaryFilter).click();
		driver.findElement(fareRulesFilter).click();
		driver.findElement(baggageInformationFilter).click();
	}
	
}
