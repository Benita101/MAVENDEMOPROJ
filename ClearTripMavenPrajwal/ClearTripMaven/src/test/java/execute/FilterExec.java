package execute;

import org.testng.annotations.Test;

import POM.FilterPOM;
import utils.Base;



public class FilterExec extends Base{
  @Test
  public void f() throws Exception  {
	      filter=new FilterPOM(driver);
		  filter.clickStops();
		  filter.clickTime();
		  filter.clickAirlines();
	
  }
}
//}
