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

    // ================= FULL CONSTRUCTOR =================
    public PersonalDetails(String firstName, String surName, LocalDate dateOfBirth, String phone, String gender) {

        if (firstName == null || surName == null || dateOfBirth == null || phone == null || gender == null) {
            throw new IllegalArgumentException("invalid missing input");
        }

        firstName = firstName.toLowerCase().trim();
        surName = surName.toLowerCase().trim();
        phone = phone.trim();
        gender = gender.toLowerCase().trim();

        if (!validGender(gender)) throw new IllegalArgumentException("invalid gender");
        if (!validName(firstName)) throw new IllegalArgumentException("invalid first name");
        if (!validName(surName)) throw new IllegalArgumentException("invalid surname");
        if (!validatePhone(phone)) throw new IllegalArgumentException("invalid phone");
        if (dateOfBirth.isAfter(LocalDate.now())) throw new IllegalArgumentException("invalid DOB");

        this.firstName = firstName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    // ================= MINIMAL CONSTRUCTOR =================
    public PersonalDetails(String firstName, String surName, String phone) {

        if (firstName == null || surName == null || phone == null) {
            throw new IllegalArgumentException("invalid missing input");
        }

        firstName = firstName.toLowerCase().trim();
        surName = surName.toLowerCase().trim();
        phone = phone.trim();

        if (!validName(firstName)) throw new IllegalArgumentException("invalid first name");
        if (!validName(surName)) throw new IllegalArgumentException("invalid surname");
        if (!validatePhone(phone)) throw new IllegalArgumentException("invalid phone");

        this.firstName = firstName;
        this.surName = surName;
        this.phone = phone;
    }

    // ================= GETTERS =================
    public String getFirstName() { return firstName; }
    public String getSurName() { return surName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getPhone() { return phone; }

    public String getEmail() {
        return (email == null || email.isEmpty()) ? "no email set" : email;
    }

    public String getAddress() {
        return (address == null) ? "no address is set" : address;
    }

    public ArrayList<String> getMedicalHistory() {
        return medicalHistory;
    }

    public String getGender() {
        return gender;
    }

    // ================= SETTERS =================
    public void setPhone(String phone) {
        if (!validatePhone(phone)) throw new IllegalArgumentException("invalid phone");
        this.phone = phone.trim();
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("invalid email");

        email = email.trim().toLowerCase();

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("invalid email");
        }

        this.email = email;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 200) {
            throw new IllegalArgumentException("invalid address");
        }
        this.address = address.trim();
    }

    public void addMedicalReport(String report) {
        if (report == null || report.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid medical report");
        }
        medicalHistory.add(report.trim());
    }

    // ================= HELPERS =================
    private boolean validGender(String gender) {
        return gender != null &&
               (gender.equals("male") || gender.equals("female"));
    }

    private boolean validName(String name) {
        return name != null &&
               name.length() > 0 &&
               name.length() <= 25 &&
               name.matches("[a-zA-Z]+");
    }

    private boolean validatePhone(String phone) {
        return phone != null &&
               phone.length() <= 25 &&
               phone.matches("\\d[\\d+\\- ]*");
    }
}