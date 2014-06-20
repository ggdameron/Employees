
public class ComissionEmployee extends Employee {
	
	private double sales;
	
	private double rate;
	
	
	public ComissionEmployee(String fn, String ln, char mi, char g, int en, boolean ft, double s, double r) {
		super(fn, ln, mi, g, en, ft);
		
		sales = s;
		
		rate = r;
		
	}
	
	public String toString(){
		
		return String.format("%sRate:%.2f\nSales:%.2f\n",super.toString(), rate, sales);	
	}

	@Override
	public double calculateWeeklyPay() {
		
		double weeklyPay = sales * rate;
		
		return weeklyPay;
	}

	@Override
	public void annualRaise() {

		rate += .2;
		
	}

	@Override
	public double holidayBonus() { //No bonus QQ
		
		return 0;
	}

	@Override
	public void resetWeek() {
		
		sales = 0;
		
	}
	
	@Override
	public void miscellaneous(double amount){ //Increase sales function
		
		if( amount > 0){
			
			sales += amount;
		}
		else{
			System.out.println("Error! Cannot increase sales by a negative number.");
		}
		
		
		
	}

}
