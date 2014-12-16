import java.text.MessageFormat;


public class Bet {
	int amountBet;
	Outcome outcome;
	
	Bet(int amountBet, Outcome outcome){
		this.amountBet = amountBet;
		this.outcome = outcome;
	}
	
	public int winAmount(){
		return this.outcome.winAmount(this.amountBet);
	}
	
	public int loseAmount(){
		return this.amountBet;
	}
	
	public String toString(){
		Object[] values = {this.amountBet,this.outcome.toString()};
		String msgTempl = "{0} on {1}";
		return MessageFormat.format(msgTempl, values);
	}
}
