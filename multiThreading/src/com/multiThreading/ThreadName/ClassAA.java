package com.multiThreading.ThreadName;

import java.util.List;
import java.util.stream.Collectors;

public class ClassAA {
	//Employee {name,Department, salary]
	public static List<Employee> emp =List.of(new Employee("Ravi","HR",50000),
			new Employee("Ravi","HR",70000),
			new Employee("Ravi","Admin",50000),
			new Employee("Ravi","Admin",80000)
			
			
			);
	

	public static void main(String[] args) {
   List<Double> filteredList =emp.stream().filter(e->e.getDepartment().equalsIgnoreCase("HR")).map(e->e.getSalary()).collect(Collectors.toList());
   double totalSalary= 0;
		   for(Double i:filteredList) {
			   totalSalary = totalSalary+i;
		   }
		   double avgsalary = totalSalary/(filteredList.size());
		   System.out.println(avgsalary);
   
   
	}
}

