package execute;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.LoginPOM;
import utils.BaseForMasterExecute;
import utils.Excel;

public class LoginExecute extends BaseForMasterExecute {


	@Test(dataProvider = "LoginData")
	public void loginTest(String username, String password) throws Exception {
		login = new LoginPOM(driver);
		login.loginProcess(username, password);

	}

	@DataProvider
	public Object[][] LoginData() throws Exception {

		Object data[][] = Excel.MyDataProvider("Login", 2);
		return data;
	}

}
