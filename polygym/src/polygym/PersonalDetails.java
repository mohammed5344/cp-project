package polygym;

import java.time.LocalDate;
import java.util.ArrayList;

public class PersonalDetails {

    private String firstName;
    private String surName;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String address;
    private ArrayList<String> medicalHistory = new ArrayList<>();
    private String gender;

    public PersonalDetails(String firstName, String surName, LocalDate dateOfBirth, String phone, String gender) {
        if (firstName == null || surName == null || dateOfBirth == null || phone == null || gender == null) {
            throw new IllegalArgumentException("invalid missing input");
        }

        firstName = firstName.toLowerCase().trim();
        surName = surName.toLowerCase().trim();
        phone = phone.toLowerCase().trim();
        gender = gender.toLowerCase().trim();

        if (!this.validGender(gender)) {
            throw new IllegalArgumentException("invalid gender input");
        }
        if (!this.validName(firstName)) {
            throw new IllegalArgumentException("invalid first name input");
        }
        if (!this.validName(surName)) {
            throw new IllegalArgumentException("invalid sur Name input");
        }
        if (!this.validatePhone(phone)) {
            throw new IllegalArgumentException("invalid phone input");
        }
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth is invalid");
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

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        if (this.email == null || this.email.length() == 0) {
            return "no email set";
        }
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

    public void addMedicalReport(String report) {
        if (report == null || report.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid medical report");
        }

        medicalHistory.add(report.trim());
    }

    public String getGender() {
        return this.gender;
    }

    public void setPhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("invalid phone input");
        }
        if (!validatePhone(phone)) {
            throw new IllegalArgumentException("invalid phone input");
        }
        this.phone = phone.trim();
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("invalid email input");
        }

        email = email.trim().toLowerCase();

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("invalid email input");
        }
        this.email = email;
    }

    public void setAddress(String city, int blockNum, int streetNum, int buildingNum, String apartment) {
        if (city == null) {
            throw new IllegalArgumentException("invalid city input");
        }
        if (apartment == null) {
            throw new IllegalArgumentException("invalid city input");
        }

        apartment = apartment.trim().toLowerCase();
        city = city.trim().toLowerCase();

        if (city.length() == 0 || city.length() > 50) {
            throw new IllegalArgumentException("invalid city input");
        }

        if (apartment.length() == 0 || apartment.length() > 50) {
            throw new IllegalArgumentException("invalid apartment input");
        }

        String addressFormat = "city: %s\nblock Number: %d\nstreet number: %d\n"
                + "building number: %d\napartment : %s\n ";

        this.address = String.format(addressFormat, city, blockNum, streetNum, buildingNum, apartment);

    }

    //helper functions
    private boolean validGender(String gender) {
        if (gender == null) {
            return false;

        }
        if (!gender.equals("male") && !gender.equals("female")) {
            return false;
        }
        return true;
    }

    // validate the name and return a boolean
    private boolean validName(String name) {
        if ((name == null) || (name.length() > 25 || name.length() == 0)) {
            return false;
        }
        if (!this.isAlphabetic(name)) {
            return false;
        }
        return true;
    }

    // a function to check string only has alphabatic charcaters
    private boolean isAlphabetic(String str) {
        return str != null && str.matches("[a-zA-Z]+");
    }

    private boolean validatePhone(String phone) {
        if (phone == null || phone.length() > 25 || phone.length() == 0) {
            return false;
        }
        if (!phone.matches("(\\+\\d{1,4})?\\d{8,12}")) {
            return false;
        }
        return true;
    }

}
