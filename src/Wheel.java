import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;


public class Wheel {
	public Vector<Bin> bins = new Vector<Bin>(38);
	public Random rdm;
	public Set<Outcome> all_outcomes;
	
	/**
	 * Constructors
	 * */
	
	Wheel(){
		this.rdm = new Random();
		this.all_outcomes = new TreeSet<Outcome>();
	}
	
	Wheel(Random rdm){
		this();
		this.rdm = rdm;
	}
	
	
	/**
	 * Public Methods
	 * */
	
	public void addOutcome(int binIndex, Outcome outcome){
		Bin bin = this.get(binIndex);
		bin.add(outcome);
		this.all_outcomes.add(outcome);
	}
	
	public Bin next(){
		int binIndex = this.rdm.nextInt();
		Bin bin = this.get(binIndex);
		
		return bin;
	}
	
	public Bin get(int binIndex){
		Bin bin = this.bins.get(binIndex);
		return bin;
	}
	
	public Outcome getOutcome(String name){
		for(Iterator<Outcome> i = this.all_outcomes.iterator();i.hasNext();){
			Outcome oc = i.next();
			if(oc.name.equals(name)){
				return oc;
			}
		}
		
		return null;
	}
}
