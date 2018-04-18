/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasic.p2.pkg001;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHONGDV
 */
public class Department {
    private String departmentName;
    private List<Employee> listOfEmployee;

    public Department(String departmentName) {
        listOfEmployee = new ArrayList<>();
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public void addEmployee(Employee employee) {
    	employee.setDept(getDepartmentName());
        listOfEmployee.add(employee);
    }
    
    public void display() {
    	System.out.println("List of employee in "+this.getDepartmentName()+" department");
    	int numberOfEmployee = listOfEmployee.size();
    	for (int i = 0; i< numberOfEmployee; i++) {
    		listOfEmployee.get(i).display();
    	}
    }
    
    public int numberOfEmployee() {
    	return listOfEmployee.size();
    }
    
}
