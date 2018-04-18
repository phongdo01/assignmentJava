/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasic.p2.pkg001;

import java.util.Scanner;

/**
 *
 * @author PHONGDV
 */
public class HourlyEmployee extends Employee{

    private double wage;
    private double workingHour;
    
    @Override
    public void display() {
        System.out.println("ID = "+getSsn());
        System.out.println("Name = "+getFirstName()+" "+getLastName());
        System.out.println("wage = "+this.wage);
        System.out.println("workingHour = " +this.workingHour);
        System.out.println("Hourly Employee");
        System.out.println("Department: "+ getDept());
        System.out.println("-----------------------------------------");
        //System.out.println("Type of employee: HourlyEmployee");
    }

    @Override
    public double getPaymentAmount() {
        return 0.0;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(double workingHour) {
        this.workingHour = workingHour;
    }

    public HourlyEmployee(String ssn, String firstName, String lastName) {
        super(ssn, firstName, lastName);
        Scanner scan = new Scanner(System.in);
        System.out.println("Input wage");
        this.wage = scan.nextDouble();
        System.out.println("Input the workingHour");
        this.workingHour = scan.nextDouble();
        
    }
    
}
