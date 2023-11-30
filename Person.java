package main.java.dev.m3s.programming2.homework3;

/*
 * Person class contains all information about the person (can be a student or a teacher)
 */

import java.util.Random;

public abstract class Person {
    
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    
    public Person(String lname, String fname) {
        if (fname != null)
            this.firstName = fname;
        if (lname != null)
            this.lastName = lname;
    }
    
    /**
     * @return student's firstname
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * sets the first name
     * @param fname first name
     */
    public void setFirstName(String fname) {
        if (fname != null)
            this.firstName = fname;
    }
    
    /**
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * sets last name
     * @param lname last name
     */
    public void setLastName(String lname) {
        if (lname != null)
            this.lastName = lname;
    }
    
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public String setBirthDate(String personId) {
        PersonID personID = new PersonID();
        if (personID.setPersonId(personId).equals("Ok")){
            this.birthDate = personID.getBirthDate();
            return personID.getBirthDate();
        } return "No change";
        
    }
    
    protected int getRandomId(final int min, final int max) {
        Random rand = new Random();
        int newId = rand.nextInt(min, max);
        return newId;
        
    }
    
    public abstract String getIdString();

}
