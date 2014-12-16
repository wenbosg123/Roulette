import java.util.Random;


public class NonRandom extends Random {
	long value;
	
	NonRandom(){
		this.value = 0;
	}
	
	/**
	 * Public Methods
	 * */
	
	public void setSeed(long seeds){
		this.value = seeds;
	}
	
	public int nextInt(){
		return (int)this.value;
	}
}
