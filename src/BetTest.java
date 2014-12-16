import static org.junit.Assert.*;

import org.junit.Test;


public class BetTest {

	@Test
	public void test() {
		Outcome oc1 = new Outcome( "Any Craps", 8 );
		Bet bet1 = new Bet(20,oc1);
		assertTrue(bet1.winAmount()==160);
	}

}
