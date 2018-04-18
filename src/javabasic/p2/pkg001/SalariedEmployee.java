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
public class SalariedEmployee extends Employee{

    private double commissionRalte;
    private double grossSales;
    private double basicSalary;
    
    @Override
    public void display() {
        System.out.println("ID = "+getSsn());
        System.out.println("Name = "+getFirstName()+" "+getLastName());
        System.out.println("commissionRalte = "+this.commissionRalte);
        System.out.println("grossSales = "+ this.grossSales);
        System.out.println("basicSalary"+this.basicSalary);
        System.out.println("Salaried Employee");
        System.out.println("Department: "+ getDept());
        System.out.println("---------------------------------------");
    }

    @Override
    public double getPaymentAmount() {
        return 0.0;
    }

    public double getCommissionRalte() {
        return commissionRalte;
    }

    public void setCommissionRalte(double commissionRalte) {
        this.commissionRalte = commissionRalte;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public SalariedEmployee(String ssn, String firstName, String lastName) {
        super(ssn, firstName, lastName);
        Scanner scan = new Scanner(System.in);
        System.out.println("Input commissionRalte");
        this.commissionRalte = scan.nextDouble();
        System.out.println("Input grossSaley");
        this.grossSales = scan.nextDouble();
        System.out.println("Input basicSalary");
        this.basicSalary = scan.nextDouble();
    }
    
}
