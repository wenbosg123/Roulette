import static org.junit.Assert.*;

import org.junit.Test;


public class BinTest {

	@Test
	public void test() {		
		Outcome five= new Outcome( "00-0-1-2-3", 6 );
		Outcome[] ocZero = {
		new Outcome("0", 35 ), five };
		Outcome[] ocZeroZero = {
		new Outcome("00", 35 ), five };
		Bin zero= new Bin( ocZero );
		Bin zerozero= new Bin( ocZeroZero );
//		
//		assertEquals(zero.toString(),"[0, 00-0-1-2-3]");
//		assertEquals(zerozero.toString(),"[00, 00-0-1-2-3]");
	}

}
