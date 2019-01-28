package execute;

import org.testng.annotations.Test;

import POM.ForgotPasswordPOM;
import utils.Base;
import utils.Excel;

public class ForgotPassExecute extends Base {



	@Test
	public void f() throws Exception {
	    forgotPwd = new ForgotPasswordPOM(driver);
		Excel.ExcelConfig("D:\\ClearTrip\\ClearTripFlight.xlsx", "ForgotPassword");
		System.out.println("Total Rows " + Excel.ROWNUM());
		for(int i=0;i<= Excel.ROWNUM(); i++) {
		//forgotPassPom.forgotPassProcess(Excel.Read(i, 0));
		forgotPwd.forgotPassProcess(Excel.Read(i, 0), Excel.Read(i, 1));

	}

}
}