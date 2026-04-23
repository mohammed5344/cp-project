package polygym;

public class StudentMember extends GymMember {

    private int id;
    private String major;
    private String sportTeam;
    private int studentID;
    private static int numOfStudents = 0;
    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public StudentMember(PersonalDetails personalDetails){
        super(personalDetails);
        if(personalDetails == null) {
            throw new IllegalArgumentException("invalid personal Details");
        }
        numOfStudents++;
        this.id = numOfStudents;
    }
    
    public StudentMember(PersonalDetails personalDetails, int studentID){
        super(personalDetails);
        if(personalDetails == null) {
            throw new IllegalArgumentException("invalid personal Details");
        }
        numOfStudents++;
        if(studentID < 0 || studentID > 999999999) {
            throw new IllegalArgumentException("invalid student ID");
        }
        this.studentID = studentID;
        this.id = numOfStudents;
    }

    public int getStudentId(){
        return this.id;
    }

    public String getMajor(){
        return major;
    }

    public String getSportTeam(){
        return sportTeam;
    }

    public void setMajor(String major){
        if (major == null){
            throw new IllegalArgumentException("invalid major");
        }
        if (major.length() > 50){
            throw new IllegalArgumentException("major cannot be more than 50 characters");
        }
        if (major.length() < 4){
            throw new IllegalArgumentException("major cannot be less than 4 characters");
        }
        this.major = major;
    }

    public void setSportTeam(String sportTeam) {
        if (sportTeam == null){
            throw new IllegalArgumentException("invalid sport team");
        }
        if (sportTeam.length() > 50){
            throw new IllegalArgumentException("sport team cannot be more than 50 characters");
        }
        if (sportTeam.length() < 4){
            throw new IllegalArgumentException("sport team cannot be less than 4 characters");
        }
        this.sportTeam = sportTeam;
    }
}