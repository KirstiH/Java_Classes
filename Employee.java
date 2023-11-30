package main.java.dev.m3s.programming2.homework3;

/*
 * this Employee class extends class Person for personal information
 * and implements class Payment for information about salary
 */

import java.util.Calendar;

public abstract class Employee extends Person implements Payment {
    
    private String empId;
    private int startYear;
    private Payment payment;
    
    public Employee(String lname, String fname) {
        super(lname, fname);
        this.startYear = Calendar.getInstance().get(Calendar.YEAR);
        int id = getRandomId(ConstantValues.MIN_EMP_ID, ConstantValues.MAX_EMP_ID);
        this.empId = getEmployeeIdString() + Integer.toString(id);
        
    }
    
    @Override
    public String getIdString() {
        return this.empId;
    }
    
    public int getStartYear() {
        return this.startYear;
    }
    
    public void setStartYear(final int startYear) {
        if (startYear > 2000 && startYear <= Calendar.getInstance().get(Calendar.YEAR))
            this.startYear = startYear;
    }
    
    public Payment getPayment() {
        return this.payment;
    }
    
    public void setPayment(Payment payment) {
        if (payment != null)
            this.payment = payment;
    }
    
    protected abstract String getEmployeeIdString();

    @Override
    public double calculatePayment() {
        if (this.payment == null) return 0.0;
        return payment.calculatePayment();
        
    }
       

}
