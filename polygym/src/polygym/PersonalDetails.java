import java.util.Date;
import java.util.ArrayList;
public class PersonalDetails {

    private String firstName;
    private String surName;
    private String address;
    private Date dateOfBirth;
    private String phone;
    private String gender;
    private String email;
    private ArrayList<String> medicalHistory;

    public PersonalDetails(String firstName, String surName, String address, Date dateOfBirth, String phone, String gender){
        this.firstName = firstName;
        this.surName = surName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getSurName(){
        return surName;
    }

    public String getAddress(){
        return address;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    public String getPhone(){
        return phone;
    }

    public String getGender(){
        return gender;
    }

    public String getEmail(){
        return email;
    }

    public ArrayList<String> getMedicalHistory(){
        return medicalHistory;
    }

    public void addMedicalHistory(String medicalSituation){
        medicalHistory.add(medicalSituation);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String building, String road, int blocknum, String city) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
