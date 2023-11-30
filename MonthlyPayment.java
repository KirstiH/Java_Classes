package main.java.dev.m3s.programming2.homework3;

/*
 * this class is for monthly salary
 */

public class MonthlyPayment implements Payment {
    
    private double salary;
    
    public void setSalary(double salary) {
        if (salary > 0.0)
            this.salary = salary;
    }
    
    public double getSalary() {
        return this.salary;
    }

    @Override
    public double calculatePayment() {
        return this.salary;
    }

}
