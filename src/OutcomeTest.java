import static org.junit.Assert.*;

import org.junit.Test;


public class OutcomeTest {

	@Test
	public void test() {
		Outcome oc1 = new Outcome( "Any Craps", 8 );
		System.out.println( "oc1 = " + oc1 );
		Outcome oc2 = new Outcome( "Any Craps", 8 );
		System.out.println( "oc2 = " + oc2 );
		Outcome oc3 = new Outcome( "other Craps", 8 );
		System.out.println( "oc3 = " + oc3 );
//		System.out.println( "equal = " + (oc1 == oc2) );
		assertTrue(oc1.equals(oc2));
		assertFalse(oc1.equals(oc3));
		assertTrue(oc1.hashCode() == oc2.hashCode());
		assertFalse(oc1.hashCode() == oc3.hashCode());
		assertTrue(oc1.winAmount(60) == 480);
		assertFalse(oc1.winAmount(60) == 48);
	}

}
