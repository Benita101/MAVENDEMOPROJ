package execute;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.ModifyPOM;
import POM.OneWaySearchPOM;
import utils.Base;

public class ModifyExec extends Base{
  @Test
  public void modifyData(/*String field,String value*/) throws Exception {
	  oneway=new OneWaySearchPOM(driver);
	  modify=new ModifyPOM(driver);
	  modify.modify();
	 /* String field="DepartDate";
	  modify.modify();
	  if(field.equals("DepartDate"))
	  {
		  oneway.pickDate("30/04/19", "1");
	  }*/
	 /* if(field.equals("FromField"))
	  {
		  oneway.enterFrom(value);
	  }
	  if(field.equals("ToField"))
	  {
		  oneway.enterTo(value);
	  }
	  if(field.equals("Adult"))
	  {
		  oneway.selectAdult(value);
	  }  
	  if(field.equals("Children"))
	  {
		  oneway.selectChildren(value);
	  }  
	  if(field.equals("Infant"))
	  {
		  oneway.selectInfant(value);
	  }  */
  }
  /*@DataProvider
  public Object[][] modifySearchData() throws Exception
  {
	Object data[][]=Excel.MyDataProvider("ModifySearchField", 2);
	return data;
	  
  }*/
  
}