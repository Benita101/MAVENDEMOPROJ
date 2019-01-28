package execute;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.MultiwayPom;
import utils.Base;
import utils.BaseForMasterExecute;
import utils.Excel;

public class MultiwayExc extends BaseForMasterExecute{
  @Test(dataProvider="MultiwaySearchData")
  public void multiwaySearch(String from1,String to1,String date1,String to2,String date2,String to3,String date3,String adults,String children,String infant,String airClass) throws Exception {
	  multiway=new MultiwayPom(driver);
	
	  
		  multiway.goMultiTrip();
		  multiway.enterFromOne(from1);
		  multiway.enterToOne(to1);
		  multiway.enterDateOne(date1);
		  multiway.goFromTwo();
		  
		  multiway.enterToTwo(to2);
		  
		  
		  multiway.enterDateTwo(date2);
		  multiway.goFromThree();
		  
		  multiway.enterToThree(to3);
		  multiway.enterDateThree(date3);
		 
		  multiway.selectAdult(adults);
		  multiway.selectChildren(children);
		  multiway.selectInfant(infant);
		  multiway.selectClass(airClass);
		  multiway.searchFlights();
	  
  }
  @DataProvider
  public Object[][] MultiwaySearchData() throws Exception
  {
	Object data[][]=Excel.MyDataProvider("MultiCity", 11);
	return data;
	  
  }
  }
