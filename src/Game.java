import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;


public class Game {
	Wheel wheel;
	Table table;
	Object player;
	
	Game(Wheel wheel, Table table){
		this.wheel = wheel;
		this.table = table;
	}
	
	public void cycle(Passenger57 player) throws InvalidBet{
		player.placeBets(30);
		wheel.rdm.setSeed(2);
		int binIndex = wheel.rdm.nextInt();
		Bin bin = wheel.get(binIndex);
		
		for(ListIterator<Bet> i=this.table.iterator();i.hasNext();){
			Bet bet = i.next();
			if(bin.outcomes.contains(bet.outcome)){
				player.win(bet);
			}else{
				player.lose(bet);
			}
		}
	}
	
}
