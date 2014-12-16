import static org.junit.Assert.*;

import org.junit.Test;


public class GameTest {

	@Test
	public void test() throws InvalidBet {
		NonRandom rdm = new NonRandom();
		Wheel wheel = new Wheel(rdm);
		BinBuilder binBuilder = new BinBuilder();
		binBuilder.buildBins(wheel);
		
		Outcome black = wheel.getOutcome("Black");
		Table table = new Table();
		
		Game game = new Game(wheel,table);
		Passenger57 player = new Passenger57(table);
		player.black = black;
		game.cycle(player);
	}

}
