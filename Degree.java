package main.java.dev.m3s.programming2.homework3;

import java.util.ArrayList;

/**
 * @author Kirsti Härö
 * @version 23.2.2023
 * Degree-class
 * This class can be used for both bachelor's and master's degree
 * Students courses can be added to the degree
 */

public class Degree {
    
    private static final int MAX_COURSES = 50;
    private int count;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private ArrayList <StudentCourse> myCourses = new ArrayList <StudentCourse>(MAX_COURSES);
    
    /*
     * returns all completed courses from the degree
     */
    public ArrayList<StudentCourse> getCourses() {
        return this.myCourses;
    }
    
    /*
     * adding courses to the degree
     */
    public void addStudentCourses(ArrayList<StudentCourse> courses) {
        if (courses != null)
            for (int i = 0; i < courses.size(); i++) {
                addStudentCourse(courses.get(i));
            }
    }
    
    /*
     * adding courses to the degree
     */
    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            myCourses.add(course);
            count++;
            return true;
        } 
        return false;       
    }
    
    public String getDegreeTitle() {
        return this.degreeTitle;
    }
    
    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null)
            this.degreeTitle = degreeTitle;
    }

    public String getTitleOfThesis() {
        return this.titleOfThesis;
    }
    
    public void setTitleOfThesis(String title) {
        if (title != null)
            this.titleOfThesis = title;
    }
    
    /*
     * returns credits from either bachelor's or master's degree
     */
    public double getCreditsByBase(Character base) {
        double creditsByBase = 0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i) != null) {
                if (myCourses.get(i).getCourse().getCourseBase() == base && isCourseCompleted(myCourses.get(i)) == true) {
                    creditsByBase += myCourses.get(i).getCourse().getCredits();
                }
            }
        }
        return creditsByBase;
    }
    
    public double getCreditsByType(final int courseType) {
        double creditsByType = 0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i) != null) {
                if (myCourses.get(i).getCourse().getCourseType() == courseType && isCourseCompleted(myCourses.get(i)) == true) {
                    creditsByType += myCourses.get(i).getCourse().getCredits();
                }
            }
        }
        return creditsByType;
    }
    
    public double getCredits() {
        double totalCredits = 0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (isCourseCompleted(myCourses.get(i)) == true){
               totalCredits += myCourses.get(i).getCourse().getCredits();
            }
        }
        return totalCredits;
    }
    
    private boolean isCourseCompleted(StudentCourse c) {
        if (c != null && c.isPassed() == true)
            return true;
        return false;
    }
    
    /*
     * counts and returns GPA of all completed courses
     */
    public ArrayList<Double> getGPa(int type){
        ArrayList<Double> gpa = new ArrayList<Double>(3);
        double sum = 0;
        double count1 = 0;
        double average = 0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i).getCourse().getCourseType() == type) {
                if (myCourses.get(i).getGradeNum() >= ConstantValues.MIN_GRADE && myCourses.get(i).getGradeNum() <= ConstantValues.MAX_GRADE) {
                    sum += myCourses.get(i).getGradeNum();
                    count1++;                 
                }
                
            }else {
                if (myCourses.get(i).getGradeNum() >= ConstantValues.MIN_GRADE && myCourses.get(i).getGradeNum() <= ConstantValues.MAX_GRADE) {
                    sum += myCourses.get(i).getGradeNum();
                    count1++;
                }
                
            }
            
        }
        if (count1 > 0) average = sum / count1;
        gpa.add(sum);
        gpa.add(count1);
        gpa.add(average);
        return gpa;
    }
    
    public void printCourses() {
        for (int i = 0; i < count; i++) {
            if (myCourses.get(i) != null)
                System.out.println(String.format("%s", myCourses.get(i).toString()));
        }
        System.out.println("");
    }
    
    /*
     * printing degree information and courses from the degree
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Degree [Title: \"%s\" (courses: %d)\n", this.degreeTitle, count));
        sb.append(String.format("         Thesis title: \"%s\"\n", this.titleOfThesis));
  
        if (count == 0) return sb.toString();
        
        for (int i = 0; i < count-1; i++) {
            sb.append(String.format("%10d. %s\n", (i+1), myCourses.get(i).toString()));

        }
        sb.append(String.format("%10d. %s]\n", count, myCourses.get(myCourses.size()-1).toString()));
        
        return sb.toString();     
        
    }

}