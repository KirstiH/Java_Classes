package main.java.dev.m3s.programming2.homework3;

/*
 * This Student class includes personal information and information on studies,
 * like courses and degrees
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * @author Kirsti Härö
 * @version 24.2.2023
 * Student-class
 */
public class Student extends Person{
    
    private int id;
    private int startYear = Calendar.getInstance().get(Calendar.YEAR);
    private int graduationYear;
    private int degreeCount = 3;
    private ArrayList<Degree> degrees = new ArrayList<Degree>(3);
    
    
    public Student(String lname, String fname) {
       super(lname, fname);
       this.id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
       degrees.add(new Degree());
       degrees.add(new Degree());
       degrees.add(new Degree());
    }
    
    /**
     * @return student's id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * sets the id number
     * @param id student's id number
     */
    public void setId(final int id) {
        if (id >= ConstantValues.MIN_STUDENT_ID && id <= ConstantValues.MAX_STUDENT_ID )
            this.id = id;
    }
    
    public int getstartYear() {
        return this.startYear;
    }
    
    public void setstartYear(final int startYear) {
        if (2000 < startYear && startYear <= Calendar.getInstance().get(Calendar.YEAR))
            this.startYear = startYear;
    }
    
    public int getGraduationYear() {
        return this.graduationYear;
    }
    
    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() == true) {
            if (graduationYear >= this.startYear && graduationYear <= Calendar.getInstance().get(Calendar.YEAR)) {
                this.graduationYear = graduationYear;
                return "OK";
            } return "Check graduation year";
        } return "Check amount of required credits";
    }
    
    public void setDegreeTitle(final int i, String dName) {
        if (dName != null && i >= 0 && i < this.degreeCount)
            degrees.get(i).setDegreeTitle(dName);
    }
    
    
    public boolean addCourse(final int i, StudentCourse course) {
        if (course != null && i >= 0 && i < this.degreeCount) {
            degrees.get(i).addStudentCourse(course);
            return true;
        } return false;
    }
    
    public int addCourses(final int i, ArrayList<StudentCourse> courses) {
        int counter = 0;
        if (courses != null && i >= 0 && i < this.degreeCount) {
            for (int j = 0; j < courses.size(); j++) {
                if (courses.get(j) != null) {
                    boolean added = degrees.get(i).addStudentCourse(courses.get(j));
                    if (added == true) counter++;
                }
            }
        }
        return counter;      
    }
    
    public void printCourses() {
        for (int i = 0; i < this.degreeCount; i++) {
            if (degrees.get(i) != null)
                degrees.get(i).printCourses();
        }
    }
    
    public void printDegrees() {
        for (int i = 0; i < this.degreeCount; i++) {
            if (degrees.get(i) != null)
                System.out.println(degrees.get(i).toString());
        }
    }
    
    public void setTitleOfThesis(final int i, String title) {
        if (title != null && i >= 0 && i < this.degreeCount) {
            degrees.get(i).setTitleOfThesis(title);
        }
    }
    
    
    private boolean canGraduate() {
        if (degrees.get(0).getTitleOfThesis().equals(ConstantValues.NO_TITLE) || degrees.get(1).getTitleOfThesis().equals(ConstantValues.NO_TITLE))
            return false;
        else if (degrees.get(0).getCredits() < ConstantValues.BACHELOR_CREDITS || degrees.get(0).getCreditsByType(1) < ConstantValues.BACHELOR_MANDATORY)
            return false;
        else if (degrees.get(1).getCredits() < ConstantValues.MASTER_CREDITS || degrees.get(1).getCreditsByType(1) < ConstantValues.MASTER_MANDATORY)
            return false;
        return true;     
    }
    
    public boolean hasGraduated() {
        if (this.graduationYear > 0)
            return true;
        return false;
    }
    
    public int getStudyYears() {
        if (hasGraduated() == true) {
            int years = getGraduationYear() - getstartYear();
            return years;
        }
        return Calendar.getInstance().get(Calendar.YEAR) - this.startYear;
    }
    
    private int getRandomId() {
        Random ran = new Random();
        return ran.nextInt(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
    }
    
    /**
     * helping with toString() method
     * @return the status of student's graduation
     */
    private String getStatus() {
        String status;
        if (getGraduationYear() < 2000) {
            status =  "The student has not graduated, yet.";
        }
        else status = "The student has graduated in " + graduationYear;
        return status;
    }
    
    /*
     * for toString() method, returns study duration in desired format
     */
    private String getStudyDuration() {
        int years;
        String duration;
        if (hasGraduated() == false) {
            years = Calendar.getInstance().get(Calendar.YEAR) - this.startYear;
            duration = "(Studies have lasted for " + years + " years)";
        }
        
        else {
            years = (this.graduationYear - this.startYear);
            duration = "(Studies lasted for " + years + " years)";
        }
        return duration;
    }
    
    /*
     * helps to formulate the sentence for bachelor credits in toString()-method
     */
    private String bachelorCredits() {
        String bC;
        if (degrees.get(0).getCredits() < ConstantValues.BACHELOR_CREDITS) {
            double missing = ConstantValues.BACHELOR_CREDITS - degrees.get(0).getCredits();
            bC = String.format("Missing bachelor credits %.1f (%.1f/%.1f)", missing, degrees.get(0).getCredits(), ConstantValues.BACHELOR_CREDITS);
        } else {
            bC = String.format("Total bachelor credits completed (%.1f/%.1f)", degrees.get(0).getCredits(), ConstantValues.BACHELOR_CREDITS);
        }
        return bC;
    }
    
    /*
     * helps to formulate the sentence for master credits in toString()-method
     */
    private String masterCredits() {
        String mC;
        if (degrees.get(1).getCredits() < ConstantValues.MASTER_CREDITS) {
            double missing = ConstantValues.MASTER_CREDITS - degrees.get(1).getCredits();
            mC = String.format("Missing master's credits %.1f (%.1f/%.1f)", missing, degrees.get(1).getCredits(), ConstantValues.MASTER_CREDITS);
        } else {
            mC = String.format("Total master's credits completed (%.1f/%.1f)", degrees.get(1).getCredits(), ConstantValues.MASTER_CREDITS);
        }
        return mC;
    }
    
    /*
     * helps to formulate sentence in toString() method
     */
    private double getAverage(int degree) {
        ArrayList<Double> list = new ArrayList<Double>(3);
        list.addAll(degrees.get(degree).getGPa(2));
        double average = list.get(2);
        return average;
    }
    
    /*
     * helps to formulate sentence in toString() method
     */
    private double getTotalGPA() {
        ArrayList<Double> list1 = new ArrayList<Double>(3);
        list1.addAll(degrees.get(0).getGPa(2));
        ArrayList<Double> list2 = new ArrayList<Double>(3);
        list2.addAll(degrees.get(1).getGPa(2));
        double sum1 = list1.get(0);
        double sum2 = list2.get(0);
        double totalSum = sum1 + sum2;
        double count1 = list1.get(1);
        double count2 = list2.get(1);
        double totalCount = count1 + count2;
        double average = 0;
        if (totalCount > 0) average = totalSum / totalCount;
        else average = 0;
        return average;
        
    }
    
    private String mandatoryBachelorCr() {
       String credits;
       double mandatoryCr = degrees.get(0).getCreditsByType(1);
       if (mandatoryCr < ConstantValues.BACHELOR_MANDATORY) {
           double missing = ConstantValues.BACHELOR_MANDATORY - degrees.get(0).getCreditsByType(ConstantValues.MANDATORY);
           credits = String.format("Missing bachelor credits %.1f (%.1f/%.1f)", missing, degrees.get(0).getCreditsByType(ConstantValues.MANDATORY), ConstantValues.BACHELOR_MANDATORY);
       }
       else credits = String.format("All mandatory bachelor credits completed (%.1f/%.1f)",degrees.get(0).getCreditsByType(ConstantValues.MANDATORY), ConstantValues.BACHELOR_MANDATORY);
        
       return credits;
        
    }
    
    private String mandatoryMasterCr() {
        String credits;
        double mandatoryCr = degrees.get(1).getCreditsByType(1);
        if (mandatoryCr < ConstantValues.MASTER_MANDATORY) {
            double missing = ConstantValues.MASTER_MANDATORY - degrees.get(1).getCreditsByType(ConstantValues.MANDATORY);
            credits = String.format("Missing master's credits %.1f (%.1f/%.1f)", missing, degrees.get(1).getCreditsByType(ConstantValues.MANDATORY), ConstantValues.MASTER_MANDATORY);
        }
        else credits = String.format("All mandatory master's credits completed (%.1f/%.1f)",degrees.get(1).getCreditsByType(ConstantValues.MANDATORY), ConstantValues.MASTER_MANDATORY);
         
        return credits;
         
     }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Student id: %d\n", this.id));
        sb.append(String.format("      First name: %s, Last name: %s\n", this.getFirstName(), this.getLastName()));
        sb.append(String.format("      Date of birth: \"%s\"\n", this.getBirthDate()));
        sb.append(String.format("      Status: %s\n", getStatus()));
        sb.append(String.format("      Start year: %d %s\n", this.startYear, getStudyDuration()));
        sb.append(String.format("      Total credits: %.1f (GPA = %.2f)\n", (degrees.get(0).getCredits() + degrees.get(1).getCredits()), getTotalGPA()));
        sb.append(String.format("      Bachelor credits: %.1f\n", (degrees.get(0).getCredits())));
        sb.append(String.format("             %s\n", bachelorCredits()));
        sb.append(String.format("             %s\n", mandatoryBachelorCr()));
        sb.append(String.format("             Title of BSc Thesis: \"%s\"\n", degrees.get(0).getTitleOfThesis()));
        sb.append(String.format("             GPA of Bachelor studies: %.2f\n", getAverage(0)));
        sb.append(String.format("      Master credits: %.1f\n", (degrees.get(1).getCredits())));
        sb.append(String.format("             %s\n", masterCredits()));
        sb.append(String.format("             %s\n", mandatoryMasterCr()));
        sb.append(String.format("             Title of MSc Thesis: \"%s\"\n", degrees.get(1).getTitleOfThesis()));
        sb.append(String.format("             GPA of Master studies: %.2f\n", getAverage(1)));
        
        return sb.toString();
    }

    @Override
    public String getIdString() {
        // TODO Auto-generated method stub
        return null;
    }
    
}


