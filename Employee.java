import java.util.Scanner;

public abstract class Employee extends Object {

	private String firstName;
	
	private String lastName;
	
	private char middleInitial;
	
	private boolean fullTime;
	
	private char gender;
	
	private int employeeNum;
	
	public Employee(String fn, String ln, char mi, char g, int en, boolean ft ){
		
		Scanner input = new Scanner(System.in);

		
		firstName = fn;
		
		lastName = ln;
		
		middleInitial = mi;
		
		fullTime = ft;
		
		if(g != 'm' && g!= 'M' && g != 'F' && g != 'f'){
			gender = 'F';	//Defaults gender to female
		}
		else{
			
			if(g == 'm')	//if lower case m store upper case
				g = 'M';	
			
			if(g == 'f')	//if lower case f store upper case
				g = 'F';
				
			gender = g;
		}
		
		
		employeeNum = en;
		
		while(en > 99999 || en < 10000){ 				//While loop ensuring correct employee number is input
			
			System.out.print("Invalide employee number, please enter a valid value. \nEnter Employee Number: ");
			en = input.nextInt();
			employeeNum = en;
		}
		
		
	}
	
	public int getEmployeeNumber(){
		
		return employeeNum;
		
		
	}
	
	public void setEmployeeNumber(int en){
		
		employeeNum = en;
		
	}
	
	public String getFirstName(){
		
		return firstName;
		
	}
	
	
	public String getLastName(){
		
		return lastName;
	}
	
	
	public boolean equals(Employee e2){
		if(this.employeeNum == e2.employeeNum){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		
		String status = "Full Time";
		
		if(fullTime == false){
			status = "Not Full Time";
			}
		
		
		return  employeeNum + "\n" + lastName + "," + firstName + " " + middleInitial + "." + "\n" + "Gender:" + gender + "\n" + "Fulltime:" + status +"\n";
		
		}
	
	public abstract double calculateWeeklyPay();
	
	public abstract void annualRaise();
	
	public abstract double holidayBonus();
	
	public abstract void resetWeek();
	
	public abstract void miscellaneous(double amount);
	
}
