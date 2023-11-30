package main.java.dev.m3s.programming2.homework3;

/*
 * AssistantTeacher class extends class Employee and implements interface Teacher
 */

import java.util.ArrayList;

public class AssistantTeacher extends Employee implements Teacher {
    
    private ArrayList<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    public AssistantTeacher(String lname, String fname) {
        super(lname, fname);
    }
    
    @Override
    public String getEmployeeIdString() {
        return "OY_ASSISTANT_";
    }
    
    @Override
    public String getCourses() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courses.size(); i++) {
            sb.append(courses.get(i).toString() + "\n");
        }
            
        return sb.toString();
    }
    
    public void setCourses(ArrayList<DesignatedCourse> courses) {
        if (courses != null)
            for (int i = 0; i < courses.size(); i++) {
                this.courses.add(courses.get(i));
            }
    }
    
    /*
     * Prints out teacher's information, inluding date of birth, id, name, salary and courses
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Teacher id: %s\n", this.getIdString()));
        sb.append(String.format("      First name: %s, Last name: %s\n", this.getFirstName(), this.getLastName()));
        sb.append(String.format("      Birthdate: %s\n", this.getBirthDate()));
        sb.append(String.format("      Salary: %.2f\n", this.calculatePayment()));
        sb.append(String.format("      Assistant for courses:\n"));
        
        if (courses.size() == 0) return sb.toString();
        
        for (int i = 0; i < courses.size(); i++) {
            sb.append(String.format("      %s\n", courses.get(i).toString()));
        }
        
        return sb.toString();
    }

}
