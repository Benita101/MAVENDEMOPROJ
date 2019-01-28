package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseForMasterExecute;



public class MultiwayPom {

	String date1;
	WebDriver driver;

	public MultiwayPom(WebDriver driver) {
		this.driver = driver;
	}

	By FromFieldOne = By.id("FromTag1");// 1

	By fromFieldAutoComplete = By.id("ui-id-4");

	By ToFieldOne = By.id("ToTag1");

	By toFieldAutoComplete = By.id("ui-id-5");

	By DateOne = By.xpath("//input[@id='DepartDate1']");

	By FromFieldTwo = By.xpath("//input[@id='FromTag2']"); // 2

	By fromFieldAutoCompleteTwo = By.id("ui-id-6");

	By ToFieldTwo = By.xpath("//input[@id='ToTag2']");

	By toFieldAutoCompleteTwo = By.id("ui-id-7");

	By DateTwo = By.xpath("//input[@id='DepartDate2']");

	By FromFieldThree = By.xpath("//*[@id=\"FromTag3\"]"); // 3

	By fromFieldAutoCompleteThree = By.id("ui-id-10");

	By ToFieldThree = By.xpath("//*[@id=\"ToTag3\"]");

	By toFieldAutoCompleteThree = By.id("ui-id-9");

	By DateThree = By.xpath("//*[@id=\"DepartDate3\"]");

	/* By ReturnDate=By.xpath("//input[@id='ReturnDate']"); */

	By Adults = By.xpath("//select[@id='Adults']");

	By Children = By.xpath("//select[@id='Childrens']");

	By Infant = By.xpath("//select[@id='Infants']");

	/* By MoreLinks=By.id("MoreOptionsLink"); */

	By Class = By.id("Class");

	/* By PreferredAirlines=By.id("AirlineAutocomplete"); */

	By Search = By.id("SearchBtn");

	By MTrip = By.id("MultiCity");
	
	By Month = By.xpath("//*[@class='calendar']/tbody/tr/td[@data-handler='selectDay']");
	By NextMonth = By.xpath("//div/a[@class='nextMonth ']");
	By PrevMonth = By.xpath("//div/a[@class='prevMonth']");

	public void goMultiTrip() {
		
		driver.findElement(By.id("MultiCity")).click();
	}

	public void enterFromOne(String from) throws Exception {
		driver.findElement(FromFieldOne).clear();
		driver.findElement(FromFieldOne).sendKeys(from);
		try {
			WebDriverWait explicitwait = new WebDriverWait(driver, 10);
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(fromFieldAutoComplete));
Boolean suggestion = driver.findElement(fromFieldAutoComplete).isDisplayed();
			
			if(suggestion==true)
			{
				driver.findElement(FromFieldOne).sendKeys(Keys.ENTER);
			}
							
		}catch(Exception e)
		{
			//driver.findElement(FromField).click();
		}}

	public void enterToOne(String to) throws Exception {
		driver.findElement(ToFieldOne).clear();
		driver.findElement(ToFieldOne).sendKeys(to);
		try {
			WebDriverWait explicitwait = new WebDriverWait(driver, 10);
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(toFieldAutoComplete));
Boolean suggestion = driver.findElement(fromFieldAutoComplete).isDisplayed();
			
			if(suggestion==true)
			{
				driver.findElement(ToFieldOne).sendKeys(Keys.ENTER);
			}
							
		}catch(Exception e)
		{
			//driver.findElement(FromField).click();
		}}

	public void enterDateOne(String date) throws Exception {
	//	int count=Integer.parseInt(iteration);
		driver.findElement(DateOne).click();
		System.out.println(date + "Excel Date");
		if (date.charAt(0) == '0')// retrieving day
		{
			System.out.println("first0 Excel");
			date1 = Character.toString(date.charAt(1));
			System.out.println(date1 + "Excel Day");
		} else {
			date1 = date.substring(0, 2);
			System.out.println(date1 + "Excel Day");
		}

		String datamonth;
		String month;
		if (date.charAt(3) == '0') // retrieve month d0d1-2m3m4-5y6y7
		{
			month = Character.toString(date.charAt(4));
			System.out.println("Excel Month" + month);
		} else {
			month = date.substring(3, 5);
			System.out.println("Excel Month " + month);
		}
		int monthnumber = Integer.parseInt(month);
		String monthno = Integer.toString(monthnumber - 1);
		System.out.println(monthno + "ExcelMonth attribute");

		/*if (count == 1) {// Initially current date is highlighted
			do {
				datamonth = driver.findElement(Month).getAttribute("data-month");
				System.out.println(datamonth + "currentMonth");
				System.out.println(Integer.parseInt(datamonth) + "Current datemonth html");
				if (Integer.parseInt(datamonth) > Integer.parseInt(monthno)) {

					System.out.println("Move Backwards");
					WebElement element = driver.findElement(PrevMonth);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					// driver.findElement(PrevMonth).click();
				} else if (Integer.parseInt(datamonth) == Integer.parseInt(monthno)) {

				} else {
					System.out.println("Move Forward");
					driver.findElement(NextMonth).click();
				}
			} while (!datamonth.equals(monthno));
			try {
				driver.findElement(By.xpath("//td[@class=' ']/a[text()='" + date1 + "']")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//td[@class=' weekEnd undefined']/a[text()='" + date1 + "']")).click();
			}
		}
		if (count != 1)// prev date is highlighted
		{*/
			do {
				datamonth = driver.findElement(Month).getAttribute("data-month");
				System.out.println(datamonth + "currentMonth");
				System.out.println(Integer.parseInt(datamonth) + "Current datemonth html");
				if (Integer.parseInt(datamonth) > Integer.parseInt(monthno)) {

					System.out.println("Move Backwards");
					WebElement element = driver.findElement(PrevMonth);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					// driver.findElement(PrevMonth).click();
				} else if (Integer.parseInt(datamonth) == Integer.parseInt(monthno)) {

				} else {
					System.out.println("Move Forward");
					driver.findElement(NextMonth).click();
				}
			} while (!datamonth.equals(monthno));
			try {
				driver.findElement(By.xpath("//td[@class=' ']/a[text()='" + date1 + "']")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//td[@class=' weekEnd undefined']/a[text()='" + date1 + "']")).click();
			}
		}
	//} // till first row

	public void goFromTwo() {
		driver.findElement(By.xpath("//input[@id='FromTag2']")).click();
	}

	public void enterToTwo(String to) throws Exception // enters value for to Destination 2nd time
	{
		driver.findElement(ToFieldTwo).clear();
		driver.findElement(ToFieldTwo).sendKeys(to);
		try {
			WebDriverWait explicitwait = new WebDriverWait(driver, 30);
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(toFieldAutoCompleteTwo));
			Boolean suggestion = driver.findElement(fromFieldAutoComplete).isDisplayed();
			
			if(suggestion==true)
			{
				driver.findElement(ToFieldTwo).sendKeys(Keys.ENTER);
			}
							
		}catch(Exception e)
		{
			//driver.findElement(FromField).click();
		}}

	public void enterDateTwo(String date) throws Exception {
	
		driver.findElement(DateTwo).click();
		System.out.println(date + "Excel Date");
		if (date.charAt(0) == '0')// retrieving day
		{
			System.out.println("first0 Excel");
			date1 = Character.toString(date.charAt(1));
			System.out.println(date1 + "Excel Day");
		} else {
			date1 = date.substring(0, 2);
			System.out.println(date1 + "Excel Day");
		}

		String datamonth;
		String month;
		if (date.charAt(3) == '0') // retrieve month d0d1-2m3m4-5y6y7
		{
			month = Character.toString(date.charAt(4));
			System.out.println("Excel Month" + month);
		} else {
			month = date.substring(3, 5);
			System.out.println("Excel Month " + month);
		}
		int monthnumber = Integer.parseInt(month);
		String monthno = Integer.toString(monthnumber - 1);
		System.out.println(monthno + "ExcelMonth attribute");

	/*	if (count == 1) {// Initially current date is highlighted
			do {
				datamonth = driver.findElement(Month).getAttribute("data-month");
				System.out.println(datamonth + "currentMonth");
				System.out.println(Integer.parseInt(datamonth) + "Current datemonth html");
				if (Integer.parseInt(datamonth) > Integer.parseInt(monthno)) {

					System.out.println("Move Backwards");
					WebElement element = driver.findElement(PrevMonth);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					// driver.findElement(PrevMonth).click();
				} else if (Integer.parseInt(datamonth) == Integer.parseInt(monthno)) {

				} else {
					System.out.println("Move Forward");
					driver.findElement(NextMonth).click();
				}
			} while (!datamonth.equals(monthno));
			try {
				driver.findElement(By.xpath("//td[@class=' ']/a[text()='" + date1 + "']")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//td[@class=' weekEnd undefined']/a[text()='" + date1 + "']")).click();
			}
		}
		if (count != 1)// prev date is highlighted
		{*/
			do {
				datamonth = driver.findElement(Month).getAttribute("data-month");
				System.out.println(datamonth + "currentMonth");
				System.out.println(Integer.parseInt(datamonth) + "Current datemonth html");
				if (Integer.parseInt(datamonth) > Integer.parseInt(monthno)) {

					System.out.println("Move Backwards");
					WebElement element = driver.findElement(PrevMonth);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					// driver.findElement(PrevMonth).click();
				} else if (Integer.parseInt(datamonth) == Integer.parseInt(monthno)) {

				} else {
					System.out.println("Move Forward");
					driver.findElement(NextMonth).click();
				}
			} while (!datamonth.equals(monthno));
			try {
				driver.findElement(By.xpath("//td[@class=' ']/a[text()='" + date1 + "']")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//td[@class=' ']/a[text()='" + date1 + "']")).click();
			}
		}
	//}

	// till second row

	public void goFromThree() {
		driver.findElement(By.xpath("//*[@id=\"FromTag3\"]")).click();
	}

	public void enterToThree(String to) throws Exception {
		driver.findElement(ToFieldThree).clear();
		driver.findElement(ToFieldThree).sendKeys(to);
		try {
			WebDriverWait explicitwait = new WebDriverWait(driver, 10);
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(toFieldAutoCompleteThree));
Boolean suggestion = driver.findElement(fromFieldAutoComplete).isDisplayed();
			
			if(suggestion==true)
			{
				driver.findElement(ToFieldThree).sendKeys(Keys.ENTER);
			}
							
		}catch(Exception e)
		{
			//driver.findElement(FromField).click();
		}}

	public void enterDateThree(String date) throws Exception {
		driver.findElement(DateThree).click();
		System.out.println(date + "Excel Date");
		if (date.charAt(0) == '0')// retrieving day
		{
			System.out.println("first0 Excel");
			date1 = Character.toString(date.charAt(1));
			System.out.println(date1 + "Excel Day");
		} else {
			date1 = date.substring(0, 2);
			System.out.println(date1 + "Excel Day");
		}

		String datamonth;
		String month;
		if (date.charAt(3) == '0') // retrieve month d0d1-2m3m4-5y6y7
		{
			month = Character.toString(date.charAt(4));
			System.out.println("Excel Month" + month);
		} else {
			month = date.substring(3, 5);
			System.out.println("Excel Month " + month);
		}
		int monthnumber = Integer.parseInt(month);
		String monthno = Integer.toString(monthnumber - 1);
		System.out.println(monthno + "ExcelMonth attribute");

		/*if (count == 1) {// Initially current date is highlighted
			do {
				datamonth = driver.findElement(Month).getAttribute("data-month");
				System.out.println(datamonth + "Html datamonth");
				driver.findElement(NextMonth).click();
			} while (!datamonth.equals(monthno));
			try {
				driver.findElement(By.xpath("//td[@class=' ']/a[text()='" + date1 + "']")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//td[@class=' weekEnd undefined']/a[text()='" + date1 + "']")).click();
			}
		}
		if (count != 1)// prev date is highlighted
		{*/
			do {
				datamonth = driver.findElement(Month).getAttribute("data-month");
				System.out.println(datamonth + "currentMonth");
				System.out.println(Integer.parseInt(datamonth) + "Current datemonth html");
				if (Integer.parseInt(datamonth) > Integer.parseInt(monthno)) {

					System.out.println("Move Backwards");
					WebElement element = driver.findElement(PrevMonth);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					// driver.findElement(PrevMonth).click();
				} else if (Integer.parseInt(datamonth) == Integer.parseInt(monthno)) {

				} else {
					System.out.println("Move Forward");
					driver.findElement(NextMonth).click();
				}
			} while (!datamonth.equals(monthno));
			try {
				driver.findElement(By.xpath("//td[@class=' ']/a[text()='" + date1 + "']")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//td[@class=' weekEnd undefined']/a[text()='" + date1 + "']")).click();
			}
		}
	//}
	// done till third

	public void selectAdult(String adults) {
		Select selectAdult = new Select(driver.findElement(Adults));
		selectAdult.selectByVisibleText(adults);
	}

	public void selectChildren(String children) {
		Select selectChildren = new Select(driver.findElement(Children));
		selectChildren.selectByVisibleText(children);
	}

	public void selectInfant(String infant) {
		Select selectInfant = new Select(driver.findElement(Infant));
		selectInfant.selectByVisibleText(infant);
	}

	public void selectClass(String airlineClass) {
		Select selectClass = new Select(driver.findElement(Class));
		selectClass.selectByVisibleText(airlineClass);
	}

	public void searchFlights() throws Exception {
		driver.findElement(Search).click();
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOf(driver.findElement(Search)));
	    	System.out.println("Next page");
			}
			catch(TimeoutException T)
			{
				BaseForMasterExecute.captureScreenshot("InvalidMultiwaySearch");
		    	System.out.println("refresh");
		    	driver.navigate().refresh();
			}
	}
	public void goToHome(String URL)
	{
		driver.get(URL);
	}
}
