import static org.junit.Assert.*;

import org.junit.Test;


public class TableTest {

	@Test
	public void test() {
		NonRandom rdm = new NonRandom();
		Wheel wheel = new Wheel(rdm);
		BinBuilder binBuilder = new BinBuilder();
		binBuilder.buildBins(wheel);

		Outcome oc1 = wheel.getOutcome("Red");
		Outcome oc2 = wheel.getOutcome("Number 1");
		Outcome oc3 = wheel.getOutcome("Dozen 0");
		
		Table table = new Table();
		
		Bet bet1 = new Bet(800,oc1);
		Bet bet2 = new Bet(300,oc2);
		Bet bet3 = new Bet(150,oc3);
		
		try {
			table.placeBet(bet1);
		} catch (InvalidBet e1) {
			
		}
		try {
			table.placeBet(bet2);
		} catch (InvalidBet e) {
			// TODO Auto-generated catch block
			System.out.println("Bet 2 Invalid Bet");
		}
		
		try {
			table.placeBet(bet3);
		} catch (InvalidBet e) {
			// TODO Auto-generated catch block
			System.out.println("Bet 3 Invalid Bet");
		}
		
	}

}
