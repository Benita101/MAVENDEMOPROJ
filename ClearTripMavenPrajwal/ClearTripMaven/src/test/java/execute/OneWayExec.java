package execute;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.OneWaySearchPOM;
import utils.Base;
import utils.BaseForMasterExecute;
import utils.Excel;


public class OneWayExec extends BaseForMasterExecute{
	
  @Test(dataProvider="oneWaySearchData")
  public void OneWaySearch(String from,String to,String date,String adults,String children,String infant,String airClass,String airline,String count) throws Exception {
	 
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
	Object data[][]=Excel.MyDataProvider("OneWay", 9);
	return data;
	  
  }

}
