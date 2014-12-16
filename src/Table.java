import java.util.LinkedList;
import java.util.ListIterator;


public class Table {
	int limit;
	LinkedList<Bet> bets;
	
	Table(){
		this.limit = 1000; //Dummy value
		this.bets = new LinkedList<Bet>();
	}
	
	Table(int limit){
		this();
		this.limit = limit;
	}
	
	public boolean isValid(Bet bet){
		if(bet.amountBet + this.sumOfBetsAmount() > this.limit){
			return false;
		}else{
			return true;
		}
	}
	
	public void placeBet(Bet bet) throws InvalidBet{
		if(this.isValid(bet)){
			this.bets.add(bet);
		}else{
			throw new InvalidBet();
		}
	}
	
	public ListIterator<Bet> iterator(){
		return bets.listIterator();
	}
	
	public String toString(){
		return bets.toString();
	}
	
	private int sumOfBetsAmount(){
		int result = 0;
		for(Bet bet: this.bets){
			result += bet.amountBet;
		}
		
		return result;
	}
	
	
}
