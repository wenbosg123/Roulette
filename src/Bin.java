import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;


public class Bin{
	Set<Outcome> outcomes;
	
	/**
	 * Constructors
	 * */
	
	Bin(){
		this.outcomes = new TreeSet<Outcome>();
	}
	
	Bin(Outcome[] outcomes){
		this();
		
		for(Outcome outcome: outcomes){
			this.outcomes.add(outcome);
		}
	}
	
	Bin(Collection<Outcome> outcomes){
		this();
		for(Outcome outcome: outcomes){
			this.outcomes.add(outcome);
		}
	}
	
	/**
	 * public methods
	 * */
	
	public void add(Outcome outcome){
		this.outcomes.add(outcome);
	}
	
	public String toString(){
		Set<String> names = new TreeSet<String>();
		for(Outcome outcome: this.outcomes){
			names.add("\"" + outcome.name + "\"");
		}
		return names.toString();
	}
}
