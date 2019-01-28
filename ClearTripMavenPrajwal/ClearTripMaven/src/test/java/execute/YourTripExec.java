package execute;

import org.testng.annotations.Test;

import utils.Base;

public class YourTripExec extends Base {
  @Test
  public void f() throws Exception {
	  
	  
	  yourTrip.yourTrip();
	  yourTrip.cancellation();
	  yourTrip.yourTrip();
	  yourTrip.changeFlight();
	  yourTrip.yourTrip();
	  yourTrip.printTicket();
	  
  }
}
