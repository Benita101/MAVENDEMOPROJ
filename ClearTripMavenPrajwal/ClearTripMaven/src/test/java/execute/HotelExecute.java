package execute;
import org.testng.annotations.Test;
import utils.Base;
import utils.Excel;


public class HotelExecute extends Base{






	@Test
	public void f() throws Exception
	{
	

		Excel.ExcelConfig("D:\\ClearTrip\\ClearTripFlight.xlsx","HotelData" );
		//System.out.println("Total Rows " + Excel.lastRowNum());
		/*for( int i=0;i<=Excel.lastRowNum();i++)
		{*/
			hotel.searchHotel(Excel.Read(0, 0),Excel.Read(0, 1),Excel.Read(0, 2),Excel.Read(0, 3));
			
			hotel.bookHotel();
			
			//} 




	}
}

