package main.java.dev.m3s.programming2.homework3;

/*
 * This class is for teacher's course information
 */

import java.util.Calendar;

public class DesignatedCourse {
    
    private Course course;
    private boolean responsible;
    private int year;
    
    public DesignatedCourse() {
        
    }
    
    public DesignatedCourse(Course course, boolean resp, int year) {
        setCourse(course);
        this.responsible = resp;
        setYear(year);
    }
    
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        if (course != null)
            this.course = course;
    }
    
    public boolean isResponsible() {
        return this.responsible;
    }
    
    public void isResponsible(boolean responsible) {
        this.responsible = responsible;
    }
    
    public boolean getResponsible() {
        return this.responsible;
    }
    
    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
       if (year >= 2000 && year <= Calendar.getInstance().get(Calendar.YEAR) + 1)
           this.year = year;   
    }
    
    @Override
    public String toString() {
        return String.format("[course=[%s (%5.2f cr), \"%s\". %s, period: %d.], year=%d]", course.getCourseCode(), course.getCredits(), course.getName(), course.getCourseTypeString(), course.getPeriod(), this.year);
    }
    

}
