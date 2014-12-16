import static org.junit.Assert.*;

import org.junit.Test;


public class BinBuilderTest {

	@Test
	public void test() {
		NonRandom rdm = new NonRandom();
		Wheel wheel = new Wheel(rdm);
		BinBuilder binBuilder = new BinBuilder();
		binBuilder.buildBins(wheel);
		Bin bin = wheel.bins.get(1);
		System.out.println(bin.toString());
	}
	

}
