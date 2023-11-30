package main.java.dev.m3s.programming2.homework3;

/**
 * @author Kirsti Härö
 * @version 15.3.2023
 * Course class contains all information about the course
 */
public class Course {
    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' ';
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;
    
    /**
     * empty constructor
     */
    public Course() {
        
    }
    
    public Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade) {
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }
    
    public Course(Course course) {
        this.name = course.name;
        this.courseCode = course.courseCode;
        this.courseBase = course.courseBase;
        this.courseType = course.courseType;
        this.period = course.period;
        this.credits = course.credits;
        this.numericGrade = course.numericGrade;       
    }
    
    public String getName() {
        return this.name;
    }
    
    
    public void setName(String courseName) {
        if (courseName == null)
            return;
        if (courseName.equals(""))
           return;
        this.name = courseName;  
    }
    
    public String getCourseTypeString() {
        if (this.courseType == ConstantValues.OPTIONAL)
            return "Optional";
        return "Mandatory";
        
    }
    
    public int getCourseType() {
        return this.courseType;
    }
    
    public void setCourseType(final int type) {
        if (type == ConstantValues.OPTIONAL || type == ConstantValues.MANDATORY)
            this.courseType = type;    
    }
    
    public String getCourseCode() {
        return this.courseCode;
    }
    
    public void setCourseCode(final int courseCode, Character courseBase) {
        Character base = Character.toUpperCase(courseBase);
        if (courseCode > 0 && courseCode < 1000000 && (base == 'A' || base == 'P' || base == 'S')) {
            this.courseCode = Integer.toString(courseCode) + base;
            this.courseBase = courseBase;
        }
    }
    
    public Character getCourseBase() {
        return this.courseBase;
    }
    
    public int getPeriod() {
        return this.period;
    }
    
    public void setPeriod(final int period) {
        if (period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD)
            this.period = period;
    }
    
    public double getCredits() {
        return this.credits;
    }

    private void setCredits(final double credits) {
        if (credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS)
            this.credits = credits;   
    }
    
    public boolean isNumericGrade() {      
        return this.numericGrade;
    }
    
    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }
    
    /*
     * prints out all course information
     */
    @Override
    public String toString() {
        return String.format("[%s (%5.2f cr), \"%s\". %s, period: %d.]", courseCode, credits, name, getCourseTypeString(), period);
                
    }

    
}

