
package polygym;


import java.util.Date;
import java.util.ArrayList;

public class PersonalDetails {
    
    private String firstName;
    private String surName;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String address;
    private ArrayList<String> medicalHistory;
    private String gender;

    public PersonalDetails(String firstName, String surName, Date dateOfBirth, String phone, String gender) {
        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getMedicalHistory() {
        return medicalHistory;
    }

    public String getGender() {
        return gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String city,int blockNum,int streetNum,int buildingNum,String apartment) {
        String addressFormat = "city: %s\nblock Number: %d\nstreet number: %d\n"
                                + "building number: %d\napartment : %s\n ";
        this.address =String.format(addressFormat, city,blockNum,streetNum,buildingNum,apartment);
    }
    
    
   
    
    
}

