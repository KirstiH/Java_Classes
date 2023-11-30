package main.java.dev.m3s.programming2.homework3;

import java.util.ArrayList;

/**
 * @author Kirsti Härö
 * @version 23.2.2023
 * Main class for testing
 */
public class Main {

    /**
     * @param args not in use
     */
    public static void main(String[] args) {
        
        ResponsibleTeacher resTeacher = new ResponsibleTeacher("Mouse", "Mickey");
        resTeacher.setBirthDate("230498-045T");
        MonthlyPayment payment1 = new MonthlyPayment();
        payment1.setSalary(756.85);
        resTeacher.setPayment(payment1);
        
        AssistantTeacher assistant = new AssistantTeacher("The Dog", "Goofy");
        assistant.setBirthDate("141200A2315");
        HourBasedPayment payment = new HourBasedPayment();
        payment.setEurosPerHour(3.5);
        payment.setHours(11);
        assistant.setPayment(payment);
        
        Student student = new Student("Duck", "Donald");
  
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies ", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);
        
        DesignatedCourse desCourse = new DesignatedCourse(course3, true, 2023);
        DesignatedCourse desCourse1 = new DesignatedCourse(course4, false, 2023);
        DesignatedCourse desCourse2 = new DesignatedCourse(course10, false, 2022);
        DesignatedCourse desCourse3 = new DesignatedCourse(course11, true, 2023);
        
        ArrayList<DesignatedCourse> courseArray = new ArrayList<DesignatedCourse>();
        courseArray.add(desCourse);
        courseArray.add(desCourse1);
        courseArray.add(desCourse2);
        courseArray.add(desCourse3);
        
        resTeacher.setCourses(courseArray);
        assistant.setCourses(courseArray);
        System.out.println(resTeacher.toString());
        System.out.println(assistant.toString());
      
        StudentCourse sCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse sCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse sCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse sCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse sCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse sCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse sCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse sCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse sCourse9 = new StudentCourse(course9, 0, 2021);
        StudentCourse sCourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse sCourse11 = new StudentCourse(course11, 'f', 2022);
  
        ArrayList<StudentCourse> studentCoursesB = new ArrayList<StudentCourse>();
        studentCoursesB.add(sCourse1);
        studentCoursesB.add(sCourse2);
        studentCoursesB.add(sCourse3);
        studentCoursesB.add(sCourse4);
        studentCoursesB.add(sCourse5);
        ArrayList<StudentCourse> studentCoursesM = new ArrayList<StudentCourse>();
        studentCoursesM.add(sCourse6);
        studentCoursesM.add(sCourse7);
        studentCoursesM.add(sCourse8);
        studentCoursesM.add(sCourse9);
        studentCoursesM.add(sCourse10);
        studentCoursesM.add(sCourse11);
        student.setDegreeTitle(0, "Bachelor of Science"); 
        student.setDegreeTitle(1, "Master of Science"); 
        student.setTitleOfThesis(0, "Bachelor thesis title");
        student.setTitleOfThesis(1, "Masters thesis title");
        student.addCourses(0, studentCoursesB);
        student.addCourses(1, studentCoursesM);
        student.setstartYear(2001);
        System.out.println(student.toString());
        
        student.setBirthDate("230498-045T");
        student.setTitleOfThesis(0, "Christmas - The most wonderful time of the year");
        student.setTitleOfThesis(1, "Dreaming of a white Christmas");
        sCourse9.setGrade(3);
        student.setGraduationYear(2020);
        System.out.println(student.toString());
        
        student.printDegrees();
        student.printCourses();
    
    }
    
}

