package main.java.dev.m3s.programming2.homework3;

/*
 * Class ResponsibleTeacher extends class Employee for all personal information
 * and implements class Teacher for the required Teacher functions
 */

import java.util.ArrayList;

public class ResponsibleTeacher extends Employee implements Teacher {
    
    private ArrayList<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();
    
    public ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }

    @Override
    public String getCourses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).isResponsible() == true)
                sb.append("Responsible Teacher: " + courses.get(i).toString() + "\n");
            else sb.append("Teacher: " + courses.get(i).toString() + "\n");
        }
        return sb.toString();
    }
    
    public void setCourses(ArrayList<DesignatedCourse> courses) {
        if (courses != null)
            for (int i = 0; i < courses.size(); i++) {
                this.courses.add(courses.get(i));
            }
    }

    @Override
    protected String getEmployeeIdString() {
        return "OY_TEACHER_";
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Teacher id: %s\n", this.getIdString()));
        sb.append(String.format("      First name: %s, Last name: %s\n", this.getFirstName(), this.getLastName()));
        sb.append(String.format("      Birthdate: %s\n", this.getBirthDate()));
        sb.append(String.format("      Salary: %.2f\n", this.calculatePayment()));
        sb.append(String.format("      Teacher for courses:\n"));
        
        if (courses.size() == 0) return sb.toString();
        
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).isResponsible() == true)
                sb.append(String.format("      Responsible Teacher: %s\n", courses.get(i).toString()));
            else sb.append(String.format("      Teacher: %s\n", courses.get(i).toString()));
        }
        
        return sb.toString();
    }

}
