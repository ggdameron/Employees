
public class HourlyEmployee extends Employee{
	
	private double wage;
	
	private double hoursWorked;
	
	public HourlyEmployee(String fn, String ln, char mi, char g, int en, boolean ft, double wg, double hw ){
		
		super(fn, ln, mi, g, en, ft);
		
		wage = wg;
		
		hoursWorked = hw;
	}
	
	public String toString(){
		
		return String.format("%sWage:%.2f\nHours Worked:%.2f\n",super.toString(), wage, hoursWorked);		
	
	}

	@Override
	public double calculateWeeklyPay() {
		
		double weeklyPay;
		
		double overtime = hoursWorked - 40;
		
		weeklyPay = hoursWorked*wage;
		
		if(hoursWorked > 40){				
			
			weeklyPay += ((overtime * wage) * 2);
			
		}
		
		return weeklyPay;
	}

	@Override
	public void annualRaise() {
		
		double raise = (wage*.05);
		
		wage += raise;
		
	}

	@Override
	public double holidayBonus() {
		
		double bonus;
		
		bonus = wage * 40;
		
		
		return bonus;
	}

	@Override
	public void resetWeek() {
		
		hoursWorked = 0;
		
	}
	
	public void miscellaneous(int hours){
		
		hoursWorked += hours;
		
	}

	@Override
	public void miscellaneous(double amount) { // Add hours function
		
		hoursWorked += amount;
		
	}
	
	

}
