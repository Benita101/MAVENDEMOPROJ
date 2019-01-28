package execute;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.RoundTripPom;
import utils.Base;
import utils.BaseForMasterExecute;
import utils.Excel;

public class RoundTripExec extends BaseForMasterExecute{
  
  @Test(dataProvider="RoundTripSearchData")
  public void roundTripTest(String from,String to,String date,String retdate,String adults,String children,String infant,String airClass,String airline) throws Exception {
	  
	  roundTrip = new RoundTripPom(driver);

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
  }

