package main.java.dev.m3s.programming2.homework3;

/**
 * @author Kirsti Härö
 * @version 15.3.2023
 * Class for checking student's ID number
 */
public class PersonID {
    
    private String birthDate = ConstantValues.NO_BIRTHDATE;
    
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public String setPersonId(final String personID) {
        if (checkPersonIDNumber(personID) == false)
            return ConstantValues.INVALID_BIRTHDAY;
        else if (checkBirthdate(this.birthDate) == false) {
            this.birthDate = ConstantValues.NO_BIRTHDATE;
            return ConstantValues.INVALID_BIRTHDAY;
        } else if (checkValidCharacter(personID) == false)
            return ConstantValues.INCORRECT_CHECKMARK;
        return "Ok";
        
    }
    
    private boolean checkPersonIDNumber(final String personID) {
        if (personID.length() == 11 && (personID.charAt(6) == '-' || personID.charAt(6) == '+' || personID.charAt(6) == 'A')) {
            String day = personID.substring(0, 2);
            String month = personID.substring(2, 4);
            String year1 = personID.substring(4, 6);
            StringBuilder sb = new StringBuilder();
            if (personID.charAt(6) == '-') {
                sb.append("19");
            }else if (personID.charAt(6) == '+') {
                sb.append("18");
            } else sb.append("20");
            sb.append(year1);
            String year = sb.toString();
            this.birthDate = day + "." + month + "." + year;   
            return true;
        }
        return false;
    }
    
    private boolean checkLeapYear(int year) {
       if (year % 4 == 0) {
           if (year % 100 == 0) {
               if (year % 400 == 0) {
                   return true;
               }return false;
           }return true;    
       }return false;                
    }
    
    private boolean checkValidCharacter(final String personID) {
        String checkingIDNumbers = "0123456789ABCDEFHJKLMNPRSTUVWXY";
        String date = personID.substring(0, 6);
        String numbers = personID.substring(7, 10);
        long digit = Long.parseLong(date + numbers);
        int remainder = (int)(digit % 31L);
        char last = checkingIDNumbers.charAt(remainder);
        if (last == personID.charAt(10))
            return true;
        birthDate = ConstantValues.NO_BIRTHDATE;
        return false;
    }
    
    private boolean checkBirthdate(final String date) {
        
        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        
        if (day < 1 || day > 31) return false;
        if (month < 1 || month > 12) return false;
        
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        if (checkLeapYear(year) == true) {
            if (day > daysLeap[(month -1)])
                return false;
        } else {
            if (day > days[(month -1)])
                return false;
        }
        return true;
    }
    
    
}
