import java.text.MessageFormat;

//java.text.MessageFormat;

public class Outcome implements Comparable<Outcome>{
	public String name;
	public int odds;
	
	/**
	 * Constructor
	 * */
	
	Outcome(String name, int odds){
		this.name = name;
		this.odds = odds;
	}
	
	/**
	 * Public Methods
	 * */
	
	public int winAmount(int amount){
		return amount * odds;
	}
	
	public boolean equals(Object otherObject){
		if(otherObject instanceof Outcome){
			Outcome other = (Outcome) otherObject;
			if(this.name.equals(other.name)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public int hashCode(){
		int hash=7;
		for (int i=0; i < this.name.length(); i++) {
		    hash = hash*31+this.name.charAt(i);
		}
		
		return hash;
	}
	
	public String toString(){
		Object[] values = {name,new Integer(odds)};
		String msgTempl = "{0} ({1}:1)";
		return MessageFormat.format(msgTempl, values);
	}

	@Override
	public int compareTo(Outcome other) {
		if(this.name.compareTo(other.name) < 0){
			return -1;
		}else if(this.name.compareTo(other.name) == 0){
			return 0;
		}else{
			return 1;
		}
	}
}
