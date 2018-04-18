/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasic.p2.pkg001;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PHONGDV
 */

public class DepartmentManage {
	private List<Department> listOfDept;
	private List<Employee> listOfEmployee;
	
	//--------------------------------------------
    public static void main(String[] args) {
        new DepartmentManage();
    }
    //-----------------------------------------
    public DepartmentManage() {
    	listOfDept = new ArrayList<Department>();
    	listOfEmployee = new ArrayList<Employee>();
    	createDept();
    	Scanner scan = new Scanner(System.in);
    	int choice;
    	do {
    		showOption();
    		System.out.println("What's your choice");
    		choice = scan.nextInt();
    		switch (choice) {
    		case 1: showOption();break;
    		case 2: createEmployee();break;
    		case 3: process();break;
    		}
    	} while (choice != 0);
    	System.out.println("Good bye!");
    }
    //-----------------------------------------
    public void showOption() {
    	System.out.println("1. Show Opption");
    	System.out.println("2. Create Employee");
    	System.out.println("3. Search employee");
    	System.out.println("0. Exit");
    	System.out.println("----------------------");
    }
    
    //----------------------------------------
    public void createDept() {
    	Department marketingDept = new Department("Marketing");
        Department rdDept = new Department("R&D");
        Department itDept = new Department("IT");
        listOfDept.add(marketingDept);
        listOfDept.add(rdDept);
        listOfDept.add(itDept);
    }
    //--------------------------------------
    public void createEmployee() {
    	int numberOfEmployee;
        String ssnEmployee;
        String firstNameEmployee;
        String lastNameEmployee;
        Employee employee = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number of employee: ");
        numberOfEmployee = scan.nextInt();
        for (int i = 0; i<numberOfEmployee; i++) {
        	scan.nextLine();
        	System.out.println("Create information of employee "+ (listOfEmployee.size()+1));
            System.out.print("ssn of employee?");
            ssnEmployee = scan.nextLine();
            //System.out.println(ssnEmployee);
            System.out.println("first name of employee? ");
            firstNameEmployee = scan.nextLine();
            //System.out.println(firstNameEmployee);
            System.out.println("last name of employee? ");
            lastNameEmployee = scan.nextLine();
            System.out.println("Type of Employee");
            System.out.println("1. Salried Employee");
            System.out.println("2. Hourly Employee");
            int typeOfEmployee = Integer.parseInt(scan.nextLine());
            while (typeOfEmployee!=1 && typeOfEmployee!=2) {
                System.out.println("Type of Employee must be 1 or 2");
                typeOfEmployee = Integer.parseInt(scan.nextLine());
            }
            if (typeOfEmployee==1) {
                employee = new SalariedEmployee(ssnEmployee, firstNameEmployee, lastNameEmployee);
            } else if (typeOfEmployee==2) {
                employee = new HourlyEmployee(ssnEmployee, firstNameEmployee, lastNameEmployee);     
            }
            listOfEmployee.add(employee);
            System.out.println("Which department is employee in?");
            System.out.println("1. Marketing");
            System.out.println("2. R&D");
            System.out.println("3. IT");
            int typeOfDept = Integer.parseInt(scan.nextLine());
            
            while (typeOfDept<1 || typeOfDept>3) {
                System.out.println("Type of department must be 1 or 2 or 3");
                typeOfDept = Integer.parseInt(scan.nextLine());
            }
            if (typeOfDept==1) {
                listOfDept.get(0).addEmployee(employee);
            } else if (typeOfDept==2) {
                listOfDept.get(1).addEmployee(employee);
            } else {
                listOfDept.get(2).addEmployee(employee);
            }
        }
    }
    //-------------------------------------------
    public void displayAllEmployee() {
    	System.out.println("Display information of employee in ArrayList");
        int numberOfEmployee = listOfEmployee.size();
        for (int i=0; i<numberOfEmployee; i++) {
        	listOfEmployee.get(i).display();
        	System.out.println("\n");
        }
    }
    //----------------------------------------------
    public void displayAllEmployeeOfDept() {
    	System.out.println("Type name of Dept");
    	String nameOfDept = new Scanner(System.in).nextLine();
    	if (nameOfDept.equals("Marketing")) {
    		listOfDept.get(0).display();
    	} else if (nameOfDept.equals("R&D")) {
    		listOfDept.get(1).display();
    	} else if (nameOfDept.equals("IT")){
    		listOfDept.get(2).display();
    	} else {
    		System.out.println("There is no department that's name is "+nameOfDept);
    	}
    }
    //----------------------------------------------
    public void displayEmployFollowName() {
    	System.out.println("Name of Employee: ");
    	String nameOfEmp;
    	nameOfEmp = new Scanner(System.in).nextLine();
    	for (Employee emp: listOfEmployee) {
    		if (emp.getFirstName().equals(nameOfEmp)) {
    			emp.display();
    		}
    	}
    }
 
    //-------------------------------------------
    public void displayNumberEmpOfDept() {
    	System.out.println(listOfDept.get(0).getDepartmentName()+":"+listOfDept.get(0).numberOfEmployee());
    	System.out.println(listOfDept.get(1).getDepartmentName()+":"+listOfDept.get(1).numberOfEmployee());
    	System.out.println(listOfDept.get(2).getDepartmentName()+":"+listOfDept.get(2).numberOfEmployee());
    }
    //-------------------------------------------
    public void process() {
    	System.out.println("choose a search");
        System.out.println("1. Search for employees by enter the name of a specific department, display the list of " + 
        		"employees by type to the screen");
        System.out.println("2. Enter the employee's name, display detailed information about the employee");
        System.out.println("3. Display the list of departments and the number of employees for each");
    	int selected = new Scanner(System.in).nextInt();
    	while (selected != 1 && selected != 2 && selected != 3) {
        	System.out.println("selection must be 1 or 2 or 3");
        	selected = Integer.parseInt(new Scanner(System.in).nextLine());
        }
    	if (selected==1) {
    		displayAllEmployeeOfDept();
    	} else if (selected == 2) {
    		displayEmployFollowName();
    	} else {
    		displayNumberEmpOfDept();
    	}
    }
    
    
}
