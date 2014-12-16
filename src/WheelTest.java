import static org.junit.Assert.*;

import org.junit.Test;


public class WheelTest {

	@Test
	public void test() {
		Outcome oc1 = new Outcome( "1", 35 );
		Outcome oc2 = new Outcome( "2", 35 );
		Outcome oc3 = new Outcome( "red", 1 );
		
		Outcome five= new Outcome( "00-0-1-2-3", 6 );
		Outcome[] ocZero = {
		new Outcome("0", 35 ), five };
		Outcome[] ocZeroZero = {
		new Outcome("00", 35 ), five };
		Bin zero= new Bin( ocZero );
		Bin zerozero= new Bin( ocZeroZero );
		
		Outcome[] ocOne = {oc1}; 
		Outcome[] ocTwo = {oc2};
		Bin one = new Bin(ocOne);
		Bin two = new Bin(ocTwo);
		
		NonRandom rdm = new NonRandom();
		
		Wheel wheel = new Wheel(rdm);
		wheel.bins.add(0, zero);
		wheel.bins.add(1,one);
		wheel.bins.add(2,two);
		
		rdm.setSeed(1);
		Bin bin = wheel.next();
		assertTrue(bin.toString().equals("[\"1\"]"));
		
		rdm.setSeed(2);
		bin = wheel.next();
		assertTrue(bin.toString().equals("[\"2\"]"));
		
		wheel.addOutcome(1, oc3);
		
		rdm.setSeed(1);
		bin = wheel.next();
		assertTrue(bin.toString().equals("[\"1\", \"red\"]"));
		
		Outcome oc = wheel.getOutcome("red");
//		System.out.println(oc.toString());
		assertTrue(oc.toString().equals("red (1:1)"));
	}

}
