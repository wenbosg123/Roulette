
public class Passenger57 {
	Outcome black;
	Table table;
	
	Passenger57(Table table){
		this.table = table;
	}
	
	public void placeBets(int amountBet) throws InvalidBet{
		Bet bet = new Bet(amountBet,this.black);
		this.table.placeBet(bet);
	}
	
	public void win(Bet bet){
		System.out.println("bet " + bet.toString() + " win");
	}
	
	public void lose(Bet bet){
		System.out.println("bet " + bet.toString() + " lose");
	}
}
