package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Excel;
//import utils.Sheet;

public class BookingFormFillingPOMForIndividualRun {

	int j=1, k=0;
	WebDriver driver;
	public BookingFormFillingPOMForIndividualRun(WebDriver driver) {
		this.driver=driver;
	}
	
	By wrongEmailIdError = By.xpath("//div[@id='loginBlockError']");
	By insuranceTickBox = By.xpath("//input[@id='insurance_box']");
	By continueBooking= By.xpath("//input[@id='itineraryBtn']");
	By sendOffersButton = By.xpath("//input[@id='subscribe_newsletter']");
	By priceChangedButton = By.xpath("//button[@id='priceChangeUpBtn']");
	By continueButton = By.id("LoginContinueBtn_1");
	
	By creditCard = By.linkText("Credit Card");
	By debitCard = By.xpath("//a[@title='Debit Card']");
	By netBanking = By.xpath("//a[@title='Net Banking']");
	By emi = By.xpath("//a[@title='Pay by Credit Card in equal monthly installments']");
	By wallet = By.xpath("//a[contains(text(),'Wallets')]");
	By upi = By.xpath("//a[@title='Pay using Unified Payments Interface']");

	
	By numberOfAdults = By.xpath("//*[contains(@id,'AdultTitle')]");
	By adultTitle = By.xpath("//div[@class='blockOptIn clearFix active']//select[@id='AdultTitle" +j+ "']");
	
	By numberOfChild = By.xpath("//*[contains(@id,'ChildTitle')]");
	By childTitle = By.xpath("//div[@class='blockOptIn clearFix active']//select[@id='ChildTitle" +j+ "']");
	
	By numberOfInfant = By.xpath("//*[contains(@id,'InfantTitle')]");
	By infantTitle = By.xpath("//div[@class='blockOptIn clearFix active']//select[@id='InfantTitle" +j+ "']");
	
	public void formFilling(int i, JavascriptExecutor executor, WebDriverWait explicitwait, String functionName) throws Exception
	{
//		explicitwait.until(ExpectedConditions.visibilityOfElementLocated(insuranceTickBox));
		
//		if (functionName.equals("bookOneWayFlight"))
//		{
			driver.findElement(insuranceTickBox ).click();
//		}
		executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(continueBooking));
		executor.executeScript("arguments[0].click();", driver.findElement(continueBooking));

		List<WebElement> adultsList = driver.findElements(numberOfAdults);
		System.out.println("Adults = " +adultsList.size());
		
		List<WebElement> childList = driver.findElements(numberOfChild);
		System.out.println("Child = " +childList.size());
		
		List<WebElement> infantList = driver.findElements(numberOfInfant);
		System.out.println("Infant = " +infantList.size() + "\n");
		
	
		
//		if (functionName.equals("bookOneWayFlight"))
//		{
			WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='username']"));
			executor.executeScript("arguments[0].value='"+Excel.Read(i, 4)+"';", emailTextBox);
			executor.executeScript("arguments[0].click();", driver.findElement(sendOffersButton));
			executor.executeScript("arguments[0].click();", driver.findElement(continueButton));
			
//			boolean errorMessage =  driver.findElement(wrongEmailIdError).isDisplayed();
//			int m=11;
//			while(errorMessage==true)
//			{
//				executor.executeScript("arguments[0].value='"+Excel.Read(i, m)+"';", emailTextBox);
//				executor.executeScript("arguments[0].click();", driver.findElement(continueButton));	
//				errorMessage =  driver.findElement(wrongEmailIdError).isDisplayed();
//				m=m+1;
//			}
//		}
		

		
		Excel.ExcelConfig("D:\\ClearTrip\\ClearTripFlight.xlsx","PassengerDetails");
		
				k=3;
				for(j=1; j<adultsList.size(); j++) {
							
					WebElement adultTitleDropdown = driver.findElement(By.name("AdultTitle"+j));
					WebElement adultFirstName = driver.findElement(By.xpath("//div[@class='blockOptIn clearFix active']//input[@id='AdultFname" +j+ "']"));
					WebElement adultLastName = driver.findElement(By.xpath("//div[@class='blockOptIn clearFix active']//input[@id='AdultLname" +j+ "']"));
					
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 1)+"';", adultTitleDropdown);	
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 2)+"';", adultFirstName);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 3)+"';", adultLastName);
					k++;
				}
				
				
				k=3;
				for(j=1; j<=childList.size(); j++) {
							
					WebElement childTitleDropdown = driver.findElement(By.name("ChildTitle"+j));
					WebElement childFirstName = driver.findElement(By.xpath("//div[@class='blockOptIn clearFix active']//input[@id='ChildFname" +j+ "']"));
					WebElement childLastName = driver.findElement(By.xpath("//div[@class='blockOptIn clearFix active']//input[@id='ChildLname" +j+ "']"));
					WebElement childDobDay = driver.findElement(By.xpath("//select[@id='ChildDobDay" +j+ "']"));
					WebElement childDobMonth = driver.findElement(By.name("ChildDobMonth"+j));
					WebElement childDobYear = driver.findElement(By.xpath("//select[@id='ChildDobYear" +j+ "']"));
					
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 5)+"';", childTitleDropdown);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 6)+"';", childFirstName);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 7)+"';", childLastName);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 8)+"';", childDobDay);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 9)+"';", childDobMonth);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 10)+"';", childDobYear);					
					k++;
				}
				
				
				k=3;
				for(j=1; j<=infantList.size(); j++) {
							
					WebElement infantTitleDropdown = driver.findElement(By.name("InfantTitle"+j));
					WebElement infantFirstName = driver.findElement(By.xpath("//div[@class='blockOptIn clearFix active']//input[@id='InfantFname" +j+ "']"));
					WebElement infantLastName = driver.findElement(By.xpath("//div[@class='blockOptIn clearFix active']//input[@id='InfantLname" +j+ "']"));
					WebElement infantDobDay = driver.findElement(By.xpath("//select[@id='InfantDobDay" +j+ "']"));
					WebElement infantDobMonth = driver.findElement(By.name("InfantDobMonth"+j));
					WebElement infantDobYear = driver.findElement(By.xpath("//select[@id='InfantDobYear" +j+ "']"));
					
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 12)+"';", infantTitleDropdown);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 13)+"';", infantFirstName);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 14)+"';", infantLastName);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 15)+"';", infantDobDay);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 16)+"';", infantDobMonth);
					executor.executeScript("arguments[0].value='"+Excel.Read(k, 17)+"';", infantDobYear);					
					k++;
				}
	
				if(functionName.equals("bookOneWayFlight"))
				{
					Excel.ExcelConfig("D:\\ClearTrip\\ClearTripFlight.xlsx","BookOneWay");
				}
				else if(functionName.equals("bookReturnFlight"))
				{
					Excel.ExcelConfig("D:\\ClearTrip\\ClearTripFlight.xlsx","BookRoundTrip");
				}
				else if(functionName.equals("bookMutiCityFlight"))
				{
					Excel.ExcelConfig("D:\\ClearTrip\\ClearTripFlight.xlsx","BookMultiCity");
				}
				
				
				WebElement mobileNumber = driver.findElement(By.id("mobileNumber"));
				executor.executeScript("arguments[0].value='"+Excel.Read(i, 5)+"';", mobileNumber);
				
				WebElement creditCardNumber = driver.findElement(By.id("creditCardNumberDisp"));
				WebElement expiryDateMonth = driver.findElement(By.name("card_expiration_month"));
				WebElement expiryDateYear = driver.findElement(By.name("card_expiration_year"));
				WebElement cardHolderName = driver.findElement(By.id("BillName"));
				WebElement cvv = driver.findElement(By.name("cvv_code"));
				WebElement conitnueToPayment = driver.findElement(By.id("travellerBtn"));
				
//				executor.executeScript("arguments[0].scrollIntoView();", conitnueToPayment);
				executor.executeScript("arguments[0].click();", conitnueToPayment);	
				
				executor.executeScript("arguments[0].value='"+Excel.Read(i, 6)+"';", creditCardNumber);
				executor.executeScript("arguments[0].value='"+Excel.Read(i, 7)+"';", expiryDateMonth);
				executor.executeScript("arguments[0].value='"+Excel.Read(i, 8)+"';", expiryDateYear);
				executor.executeScript("arguments[0].value='"+Excel.Read(i, 9)+"';", cardHolderName);
				executor.executeScript("arguments[0].value='"+Excel.Read(i, 10)+"';", cvv);
	}
	
/*	@DataProvider
	public Object[][] passengerData() throws Exception
	{
		Object data[][]=Excel.MyDataProvider("Sheet3", 17);
		return data;
	}*/
	
}