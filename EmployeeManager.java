
public class EmployeeManager {

	Employee [] employees;
	
	final int employeeMax = 100;
	
	private int currentEmployees;
	
	
	public EmployeeManager(){	
		
		
	
	employees = new Employee[employeeMax];
		
		currentEmployees = 0;
			
	}
	
	public void addEmployee(int type, String fn, String ln, char mi, char g, int en, boolean ft, double whatever ){
		
		switch(type){
		case 1: //Hourly
			{
				double hw = 0;
				
				employees[currentEmployees] = new HourlyEmployee(fn, ln, mi, g, en, ft, whatever, hw );
				
				currentEmployees += 1;
				break;
		}
			
		case 2: //Salary
		{
			employees[currentEmployees] = new SalaryEmployee(fn, ln, mi, g, en, whatever, ft);
			
			currentEmployees += 1;
			break;
			
		}
		case 3: //Commission
		{
			
			int s = 0;
			
			employees[currentEmployees] = new ComissionEmployee(fn, ln, mi, g, en, ft, s, whatever);
			
			currentEmployees += 1;
			break;
		}
		}
		
				
		
		
	}
	
	
	public void removeEmployee(int index){	//Removes employee at spot 'index' and moves the last employee in array to spot 'index'
		
		employees[index] = employees[currentEmployees-1];	
		employees[currentEmployees-1]=null;
		currentEmployees -= 1;
	}
	
	public void listAll(){
		for(int x = 0; x < currentEmployees; x++){
			if(employees[x] instanceof  Employee){

			
				System.out.println(employees[x].toString());
			}
			
		}
	}
	
	public void listHourly(){
		for(int x = 0; x < currentEmployees; x++){
			if( employees[x] instanceof Employee){
				System.out.println(employees[x].toString());
			}
		}
	}
	
	public void listSalary(){
		for(int x = 0; x < currentEmployees; x++){
			if( employees[x] instanceof SalaryEmployee){
				System.out.println(employees[x].toString());			}
		}
	}
	
	public void listCommission(){
		for(int x = 0; x < currentEmployees; x++){
			if( employees[x] instanceof ComissionEmployee){
				System.out.println(employees[x].toString());			}
		}
	}
	


	public double calculatePayout() {
		double total = 0;
		
		for(int x = 0; x < currentEmployees; x++){
			if(employees[x] instanceof  Employee){

				double pay = employees[x].calculateWeeklyPay();
			
				total += pay;
			}
			
		}
		return total;
	}


	public void removeRedundancies(){
		int empnums [] = new int[100];
		
		for(int x = 0; x < employees.length -1; x++){	//Creates an array of all employee numbers
			if(employees[x] instanceof  Employee){

			empnums[x] = employees[x].getEmployeeNumber();}
		}
		for(int y = 0; y < employees.length -1; y++){	//if employee number matches employee number in empnums call removeEmployee
			for(int x = 0; x < empnums.length -1; x++){
				if(employees[y] instanceof  Employee ){
					if(y!=x && employees[y].getEmployeeNumber() == empnums[x]){
						removeEmployee(y);
						
					}
					

				}
			}
			
		}
			
		
	}
	
	public int getIndex(int index){
		
		int arrayIndex = -1;
		
		for(int x = 0; x < employees.length; x++){
			if(employees[x] instanceof  Employee){
			if(employees[x].getEmployeeNumber() == index ){
				
				arrayIndex = x;	
			}
			}
			
		}
		
		return arrayIndex;
	}
	
	public void sortName(){
		Employee hold;
	
		for(int x = 0; x < (employees.length - 1); x++){
			for(int y = 0; y < (employees.length - x - 1); y++){
				if(employees[y] instanceof Employee && employees[y+1] instanceof  Employee)
				if(employees[y].getLastName().compareTo(employees[y+1].getLastName()) > 0  ){
					hold = employees[y];
					employees[y] = employees[y+1];
					employees[y+1] = hold;
				
				}
				if(employees[y] instanceof Employee && employees[y+1] instanceof  Employee){

				if(employees[y].getLastName().compareTo(employees[y+1].getLastName()) == 0  ){
					for(int a = 0; x < (employees.length - 1); a++){
					for(int b = 0; y < (employees.length - a - 1); b++){
						
						if(employees[b] instanceof Employee && employees[b+1] instanceof  Employee)
						if(employees[b].getFirstName().compareTo(employees[b+1].getFirstName()) > 0  ){
							hold = employees[b];
							employees[b] = employees[b+1];
							employees[b+1] = hold;
				
						}
					}
				}
			}
			}
		}
	}
	}
	public void sortNumber(){
		Employee hold;
		
		for(int x = 0; x < (employees.length - 1); x++){
			for(int y = 0; y < (employees.length - x - 1); y++){
				if(employees[y] instanceof  Employee && employees[y+1] instanceof Employee)
				if(employees[y].getEmployeeNumber() > employees[y+1].getEmployeeNumber()  ){
					hold = employees[y];
					employees[y] = employees[y+1];
					employees[y+1] = hold;
					
				}
			}
			
		}
		
		
	}
	

	public void annualRaises(){
		
		for(int x = 0; x < employees.length; x++){
			if(employees[x] instanceof  Employee){

			employees[x].annualRaise();	
			}
		}
	}
	

	public double holidayBonuses(){
		
		double total = 0;
		
		for(int x = 0; x < employees.length; x++){
			if(employees[x] instanceof  Employee){

			total += employees[x].holidayBonus();}
		}
		return total;
	}
	
	public void increaseHours(int index, double amount){
		if(employees[index] instanceof  Employee){
		employees[index].miscellaneous(amount);
		}
		
	}
	
	public void increaseSales(int index, double amount){
		if(employees[index] instanceof  Employee){
		employees[index].miscellaneous(amount);
		}
		
	}


	public void resetWeek() {
		for(int x = 0; x < employees.length; x++){
			if(employees[x] instanceof  Employee){

				employees[x].resetWeek();
			}
			}
		}	
	}
	

