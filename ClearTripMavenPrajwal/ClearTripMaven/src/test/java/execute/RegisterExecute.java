package execute;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import POM.RegisterPOM;
import utils.BaseForMasterExecute;
import utils.Excel;

public class RegisterExecute extends BaseForMasterExecute {



	@Test(dataProvider = "RegisterData")
	public void RegisterTest(String emailReg,String password1, String visible, String name, String lastName, String phone) throws Exception { 
		register = new RegisterPOM(driver);
		register.registerProcess(emailReg, password1,visible,name,lastName,phone);
		
		
		
	}
	@DataProvider
	public Object[][] RegisterData() throws Exception
	{
		Excel.ExcelConfig("C:\\Users\\Administrator\\Documents\\1SEL\\Book1.xls", "register");
		
		Object data[][]=Excel.MyDataProvider("register", 6);
		return data;
	}
}
