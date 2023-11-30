package main.java.dev.m3s.programming2.homework3;

import java.util.Calendar;

/**
 * @author Kirsti Härö
 * @version 15.3.2023
 * StudentCourse-class contains information about completing a course,
 * like grade and year of completion
 */
public class StudentCourse {
    
    private Course course;
    private int gradeNum;
    private int yearCompleted;
    
    /**
     * empty constructor
     */
    public StudentCourse() {
        
    }
    
    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
        
    }

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = new Course(course); 
    }
    
    public int getGradeNum() {
        return this.gradeNum;
    }

    protected void setGrade(int gradeNum) {
        if (checkGradeValidity(gradeNum) == true) {
            if (gradeNum == 'a' || gradeNum == 'f')
                this.gradeNum = Character.toUpperCase(gradeNum);
            else this.gradeNum = gradeNum;
        }
       
        if (yearCompleted == 0) {
            this.yearCompleted = Calendar.getInstance().get(Calendar.YEAR);
        }
    }

    private boolean checkGradeValidity(final int gradeNum) {
        if (gradeNum >= ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE && course.isNumericGrade() == true)
            return true;
        else if (course.isNumericGrade() == false && (Character.toUpperCase(gradeNum) == ConstantValues.GRADE_FAILED || Character.toUpperCase(gradeNum) == ConstantValues.GRADE_ACCEPTED))
            return true;
        return false;
    }
 
    
    public boolean isPassed() {
        if (course.isNumericGrade() == true && gradeNum > ConstantValues.MIN_GRADE && gradeNum <= ConstantValues.MAX_GRADE)
            return true;
        if (course.isNumericGrade() == false && gradeNum == ConstantValues.GRADE_ACCEPTED)
            return true;
        return false;
    }
    
    public int getYear() {
        return this.yearCompleted;
    }

    public void setYear(final int year) {
        if (year > 2000 && year <= Calendar.getInstance().get(Calendar.YEAR))
            this.yearCompleted = year;       
    }
    
    /**
     * method for helping toString()
     * @return grading in desired String-format
     */
    private String getGrading() {
        if (this.gradeNum == ConstantValues.MIN_GRADE)
            return "\"Not graded\"";
        if (gradeNum == ConstantValues.GRADE_FAILED || gradeNum == ConstantValues.GRADE_ACCEPTED) {
            char grade = (char)gradeNum;
            String number = Character.toString(grade);
            return number;
        }
        return Integer.toString(gradeNum);
    }
    
    @Override
    public String toString() {
        return String.format("[%s (%5.2f cr), \"%s\". %s, period: %d.] Year: %d, Grade: %s.]", course.getCourseCode(), course.getCredits(), course.getName(), course.getCourseTypeString(), course.getPeriod(), this.yearCompleted, getGrading());
    }
    
    
}
