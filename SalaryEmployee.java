
public class SalaryEmployee extends Employee {
	
	double salary;
	
	public SalaryEmployee(String fn, String ln, char mi, char g, int en, double s, boolean ft) {
		super(fn, ln, mi, g, en, ft);
		
		salary = s;
		
	}


	
	public String toString(){
				
		return String.format("%sSalary:%.2f\n",super.toString(), salary);	
	}

	@Override
	public double calculateWeeklyPay() {
		
		double pay = salary/52;
		
		return pay;
	}

	@Override
	public double holidayBonus() {
		double bonus;
		
		bonus = salary * .03;
		
		return bonus;
	}



	@Override
	public void annualRaise() {

		salary *= 1.06;
		
	}



	@Override
	public void resetWeek() { //not used
		
	}
	
	@Override
	public void miscellaneous(double amount){ //not used
		
		
		
	}
		

}
