
public class BinBuilder {
	public void buildBins(Wheel wheel){
		
		for(int i=0;i<38;i++){
			Bin bin = new Bin();
			wheel.bins.add(i, bin);
		}
		
		this.generateStraightBets(wheel);
		this.generateSplitBets(wheel);
		this.generateStreetBets(wheel);
		this.generateCornerBets(wheel);
		this.generateFiveBets(wheel);
		this.generateLineBets(wheel);
		this.generateDozenBets(wheel);
		this.generateColumnBets(wheel);
		this.generateEvenMoneyBets(wheel);
		
	}
	
	private void generateFiveBets(Wheel wheel){
		String name = "00, 0, 1, 2, 3";
		Outcome five = new Outcome(name,6);
		
		wheel.addOutcome(37, five);
		wheel.addOutcome(0, five);
		wheel.addOutcome(1, five);
		wheel.addOutcome(2, five);
		wheel.addOutcome(3, five);
		
	}
	
	private void generateStraightBets(Wheel wheel){
		
		Outcome oc0 = this.createStraightBet("Number 0");
		wheel.addOutcome(0, oc0);
		
		Outcome oc00 = this.createStraightBet("Number 00");
		wheel.addOutcome(37,oc00);
		
		for(int i=1;i<=36;i++){
			String name = "Number " + i;
			Outcome outcome = this.createStraightBet(name);
			wheel.addOutcome(i, outcome);
		}
	}
	
	private void generateSplitBets(Wheel wheel){
		this.generateLeftRightSplitBets(wheel);
		this.generateUpDownSplitBets(wheel);
	}
	
	private void generateLeftRightSplitBets(Wheel wheel){
		for(int row=0;row<=11;row++){
			int firstColNumber = 3 * row + 1;
			int secondColNumber = 3 * row + 2;
			int thirdColNumber = 3 * row + 3;
			
			String name_c1c2 = String.valueOf(firstColNumber) + ", " + String.valueOf(secondColNumber);
			String name_c2c3 = String.valueOf(secondColNumber) + ", " + String.valueOf(thirdColNumber);
			Outcome oc_c1c2 = this.createSplitBets(name_c1c2);
			Outcome oc_c2c3 = this.createSplitBets(name_c2c3);
			wheel.addOutcome(firstColNumber, oc_c1c2);
			wheel.addOutcome(secondColNumber, oc_c1c2);
			wheel.addOutcome(secondColNumber, oc_c2c3);
			wheel.addOutcome(thirdColNumber, oc_c2c3);
		}
	}
	
	private void generateUpDownSplitBets(Wheel wheel){
		for(int row=0;row<=10;row++){
			int firstColNumber = 3 * row + 1;
			int secondColNumber = 3 * row + 2;
			int thirdColNumber = 3 * row + 3;
			
			int numberBelowFCN = firstColNumber + 3;
			int numberBelowSCN = secondColNumber + 3;
			int numberBelowTCN = thirdColNumber + 3;
			
			String nameOfFirstUpDown = String.valueOf(firstColNumber) + ", " + String.valueOf(numberBelowFCN);
			String nameOfSecondUpDown = String.valueOf(secondColNumber) + ", " + String.valueOf(numberBelowSCN);
			String nameOfThirdUpDown = String.valueOf(thirdColNumber) + ", " + String.valueOf(numberBelowTCN);
			
			Outcome ocOfFirstUpDown = this.createSplitBets(nameOfFirstUpDown);
			Outcome ocOfSecondUpDown = this.createSplitBets(nameOfSecondUpDown);
			Outcome ocOfThirdUpDown = this.createSplitBets(nameOfThirdUpDown);
			
			wheel.addOutcome(firstColNumber, ocOfFirstUpDown);
			wheel.addOutcome(numberBelowFCN, ocOfFirstUpDown);
			wheel.addOutcome(secondColNumber, ocOfSecondUpDown);
			wheel.addOutcome(numberBelowSCN, ocOfSecondUpDown);
			wheel.addOutcome(thirdColNumber, ocOfThirdUpDown);
			wheel.addOutcome(numberBelowTCN, ocOfThirdUpDown);
		}
	}
	
	private Outcome createSplitBets(String name){
		Outcome outcome = new Outcome(name,17);
		return outcome;
	}
	
	private void generateStreetBets(Wheel wheel){
		for(int row=0;row<=11;row++){
			int n = 3 * row + 1;
			this.generateStreetBet(wheel,n);
		}
	}
	
	private void generateStreetBet(Wheel wheel, int n){
		int nPlus1 = n + 1;
		int nPlus2 = n + 2;
		
		String streetBetName = "" + n + ", " + nPlus1 + ", " + nPlus2;
		Outcome streetBet = this.createStreetBet(streetBetName);
		
		wheel.addOutcome(n, streetBet);
		wheel.addOutcome(nPlus1, streetBet);
		wheel.addOutcome(nPlus2, streetBet);
	}
	
	private Outcome createStreetBet(String name){
		Outcome outcome = new Outcome(name, 11);
		return outcome;
	}
	
	private void generateCornerBets(Wheel wheel){
		for(int row=0;row<=10;row++){
			int first = 3 * row + 1;
			int second = 3 * row + 2;
			this.generateCornerBet(wheel, first);
			this.generateCornerBet(wheel, second);
		}
	}
	
	private void generateCornerBet(Wheel wheel, int n){
		int nPlus1 = n + 1;
		int nPlus3 = n + 3;
		int nPlus4 = n + 4;
		
		String cornerBetName = "" + n + ", " + nPlus1 + ", " + nPlus3 + ", " + nPlus4;
		Outcome cornerBet = this.createCornerBet(cornerBetName);
		
		wheel.addOutcome(n, cornerBet);
		wheel.addOutcome(nPlus1, cornerBet);
		wheel.addOutcome(nPlus3, cornerBet);
		wheel.addOutcome(nPlus4, cornerBet);
	}
	
	private Outcome createCornerBet(String name){
		return new Outcome(name, 8);
	}
	
	private void generateLineBets(Wheel wheel){
		for(int row=0;row<=10;row++){
			this.generateLineBet(wheel,row);
		}
	}
	
	private void generateLineBet(Wheel wheel, int row){
		int n = 3 * row + 1;
		int nPlus1 = n + 1;
		int nPlus2 = n + 2;
		int nPlus3 = n + 3;
		int nPlus4 = n + 4;
		int nPlus5 = n + 5;
		
		String name = n + ", " + nPlus1 + ", " + nPlus2 + ", " + nPlus3 + ", " + nPlus4 + ", " + nPlus5;
		Outcome lineBet = this.createLineBet(name);
		
		wheel.addOutcome(n, lineBet);
		wheel.addOutcome(nPlus1, lineBet);
		wheel.addOutcome(nPlus2, lineBet);
		wheel.addOutcome(nPlus3, lineBet);
		wheel.addOutcome(nPlus4, lineBet);
		wheel.addOutcome(nPlus5, lineBet);
		
	}
	
	private Outcome createLineBet(String name){
		return new Outcome(name,5);
	}
	
	private void generateDozenBets(Wheel wheel){
		for(int dozen=0;dozen<=2;dozen++){
			this.generateDozenBet(wheel, dozen);
		}
	}
	
	private void generateDozenBet(Wheel wheel, int dozen){
		String name = "Dozen " + dozen;
		Outcome dozenBet = this.createDozenBet(name);
		for(int i=1;i<=12;i++){
			int n = dozen * 12 + i;
			wheel.addOutcome(n, dozenBet);
		}
	}
	
	private Outcome createDozenBet(String name){
		return new Outcome(name,2);
	}
	
	private void generateColumnBets(Wheel wheel){
		for(int col=1;col<=2;col++){
			this.generateColumnBet(wheel, col);
		}
	}
	
	private void generateColumnBet(Wheel wheel, int col){
		String name = "Column " + col;
		Outcome columnBet = this.createColumnBet(name);
		for(int row=0;row<=11;row++){
			int n = 3 * row + col;
			wheel.addOutcome(n, columnBet);
		}
	}
	
	private Outcome createColumnBet(String name){
		return new Outcome(name,2);
	}
	
	
	
	private void generateEvenMoneyBets(Wheel wheel){
		this.generateRedBlackBets(wheel);
		this.generateEvenOddBets(wheel);
		this.generateHighLowBets(wheel);
	}
	
	private void generateRedBlackBets(Wheel wheel){
		String redName = "Red";
		Outcome redBet = this.createEvenMoneyBet(redName);
		
		String blackName = "Black";
		Outcome blackBet = this.createEvenMoneyBet(blackName);
		
		for(int i=1;i<=36;i++){
			switch(i){
				case 1: 
				case 3:
				case 5:
				case  7:
				case  9:
				case  12:
				case  14:
				case  16:
				case  18:
				case  19:
				case  21:
				case  23:
				case  25:
				case  27:
				case  30:
				case  32:
				case  34:
				case  36:wheel.addOutcome(i, redBet);break;
				default:wheel.addOutcome(i, blackBet);break;
			}
		}
	}
	
	private void generateEvenOddBets(Wheel wheel){
		String evenName = "Even";
		Outcome evenBet = this.createEvenMoneyBet(evenName);
		
		String oddName = "Odd";
		Outcome oddBet = this.createEvenMoneyBet(oddName);
		
		for(int i=1;i<=36;i++){
			if(i%2 == 0){
				wheel.addOutcome(i, evenBet);
			}else{
				wheel.addOutcome(i, oddBet);
			}
		}
	}
	
	private void generateHighLowBets(Wheel wheel){
		String highName = "High";
		Outcome highBet = this.createEvenMoneyBet(highName);
		
		String lowName = "Low";
		Outcome lowBet = this.createEvenMoneyBet(lowName);
		
		for(int i=1;i<=36;i++){
			if(i<=18){
				wheel.addOutcome(i,lowBet);
			}else{
				wheel.addOutcome(i, highBet);
			}
		}
	}
	
	private Outcome createEvenMoneyBet(String name){
		return new Outcome(name,1);
	}
	
	
	private Outcome createStraightBet(String name){
		Outcome outcome = new Outcome(name,1);
		return outcome;
	}
}
