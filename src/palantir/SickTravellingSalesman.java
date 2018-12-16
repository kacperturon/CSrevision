package palantir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SickTravellingSalesman {
	
	// SICK -> (1day) RECOVERING -> (1day) HEALTHY

	public static String[] processEmployees(List<String> initialStates){
		class Employee{
			String name;
			String state;
			String[] cities;
			int currCity = 0;
			boolean officeIsSick = false;
			public Employee(String name, String state, String[] cities) {
				this.name = name;
				this.state = state;
				this.cities = cities;
			}
			public void move() {
				if(currCity>=cities.length-1) currCity = 0;
				else currCity++;
			}
			public void setOfficeSick(boolean isSick) {
				if(isSick)
					this.officeIsSick = true;
				else this.officeIsSick = false;
			}
			public void updateState() {
				if(state.equals("SICK")) state = "RECOVERING";
				else if(state.equals("RECOVERING")) state = "HEALTHY";
				else if(state.equals("HEALTHY") && officeIsSick) state ="SICK";
				
			}
		}
		class Office{
			List<Employee> employees;
			public Office() {
				employees = new ArrayList<>();
			}
			public boolean sickEmployee() {
				for(Employee e: employees) {
					if(e.state.equals("SICK")||e.state.equals("RECOVERING")) return true;
				}
				return false;
			}
		}

		
		List<String>  output = new ArrayList();

		String line ="";
		
		Map<String, Office> offices = new HashMap<>();
		List<Employee> employees = new ArrayList<>();
		//Parse data
		for(int i=1; i<initialStates.size();i++) {
			String[] split = initialStates.get(i).split(" ");
			String name = split[0], state=split[1];
			line+= name + " ";
			String currCity = split[2];
			String[] cities = new String[split.length - 2];
			for(int j=0; j<split.length-2; j++) cities[j]=split[j+2];
			Employee e = new Employee(name, state, cities);
			employees.add(e);
			Office o;
			if(offices.get(currCity) == null) {
				o = new Office();
				offices.put(currCity, o);
			}else o = offices.get(currCity);
			o.employees.add(e);
			
			for(String city : cities) {
				if(!city.equals(currCity))
					if(offices.get(city)==null) offices.put(city, new Office());
			}
		}
		
		output.add(line);
		line = "";
		
		int days = 0;
		boolean employeesHealthy = false;
		
		while(!employeesHealthy && days<366) {
			employeesHealthy = true;
			line="";
			for(Employee e: employees) {
				if(!e.state.equals("HEALTHY")) employeesHealthy = false;
				line += e.state + " ";
				offices.get(e.cities[e.currCity]).employees.remove(e);
				e.move();
				offices.get(e.cities[e.currCity]).employees.add(e);
			}
			for(Employee e: employees) {
				e.setOfficeSick(offices.get(e.cities[e.currCity]).sickEmployee());
				e.updateState();
			}
			output.add(line.trim());
			days++;
			System.out.println(employeesHealthy);
		}
		output.add(String.valueOf(days));
		return output.toArray(new String[output.size()]);
		
	}
	
	public static void main(String[] args) {
		
		List<String> initialStates = new ArrayList<>();
		initialStates.add("3");
		initialStates.add("Monica HEALTHY DC Chicago London Winchester");
		initialStates.add("Bob SICK Chicago Winchester");
		initialStates.add("Tom HEALTHY Chicago");
		
		String[] output = processEmployees(initialStates);
		for(String out : output) {
			System.out.println(out);
		}
		
		initialStates = new ArrayList<>();
		initialStates.add("1");
		initialStates.add("Tom HEALTHY DC Chicago London Winchester");
		
		output = processEmployees(initialStates);
		for(String out : output) {
			System.out.println(out);
		}
		
		
		
		
		
	}
	

}
