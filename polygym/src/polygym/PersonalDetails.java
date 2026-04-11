
package polygym;


import java.time.LocalDate;
import java.util.ArrayList;

public class PersonalDetails {
    
    private String firstName;
    private String surName;
    private LocalDate  dateOfBirth;
    private String phone;
    private String email;
    private String address;
    private ArrayList<String> medicalHistory;
    private String gender;
    

    public PersonalDetails(String firstName, String surName, LocalDate dateOfBirth, String phone, String gender) {
        if(!this.validGender(gender)){
        throw new IllegalArgumentException("invalid gender input");
        }
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
        
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSurName() {
        return this.surName;
    }

    public LocalDate  getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        if (this.address == null) {
            return "no address is set";
        }
        return this.address;
    }

    public ArrayList<String> getMedicalHistory() {
        return this.medicalHistory;
    }

    public String getGender() {
        return this.gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String city,int blockNum,int streetNum,int buildingNum,String apartment) {
        if(city == null  || city.length() == 0 || city.length() > 50){
            
           throw new IllegalArgumentException("invalid city input");
         
        }
        String addressFormat = "city: %s\nblock Number: %d\nstreet number: %d\n"
                                + "building number: %d\napartment : %s\n ";
        
        this.address =String.format(addressFormat, city,blockNum,streetNum,buildingNum,apartment);
        
    }
    private boolean validGender(String gender){
    if(gender == null){
        return false;
    
    }
    if(!gender.toLowerCase().equals("male")  && !gender.toLowerCase().equals("female") ){
        return false;
    }
    return true;
    }
    
    
   
    
    
}

