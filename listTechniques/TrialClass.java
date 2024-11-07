package listTechniques;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;

import myleetcode.HardBasicCalculator;

public class TrialClass {

	public static void main(String[] args) {

		class Employee
		{
			String name;
			String department;

			Employee(String name, String department)
			{
				this.name=name;
				this.department=department;
			}
			@Override
			public String toString()
			{
				return name;

			}
		}
		List<Employee> employees = new ArrayList<>();
		{
			employees.add(new Employee("Alice", "HR"));
			employees.add(new Employee("Bob", "Engineering"));
			employees.add(new Employee("Charlie", "HR"));
			employees.add(new Employee("Diana", "Engineering"));
			employees.add(new Employee("Eve", "Marketing"));
			employees.add(new Employee("Frank", "HR"));
		}

		// A map to track employees by department
		Map<String, List<Employee>> departmentMap = new HashMap<>();

		for(Employee emp:employees)
		{
			departmentMap.putIfAbsent(emp.department, new ArrayList<>());
			departmentMap.get(emp.department).add(emp);
		}

		for(Map.Entry<String, List<Employee>> entry :departmentMap.entrySet())
		{
			String departmentName = entry.getKey();
			List<Employee> nameList = entry.getValue();

			System.out.println("Department: " + departmentName);
			boolean foundPair = false;
			
			for(int i=0;i<=nameList.size();i++)
			{
				
			}
		}




	}
}
