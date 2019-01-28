package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ModifyPOM {
	WebDriver driver;
	JavascriptExecutor executor;
	public ModifyPOM(WebDriver driver)
	{
		this.driver=driver;
	}
   By modifySearch=By.id("modifySearchLink");
   public void modify() throws Exception
   {
	   /*WebDriverWait explicitwait= new WebDriverWait(driver, 50);
		explicitwait.until(ExpectedConditions.elementToBeClickable(modifySearch));*/
		Thread.sleep(40000);
		executor.executeScript("arguments[0].click();", driver.findElement(modifySearch));
	   System.out.println("In modify");
	   driver.findElement(modifySearch).click();
	   //executor.executeScript("arguments[0].click",modifySearch);
   }
}
