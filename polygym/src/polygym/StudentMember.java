package polygym;

public class StudentMember extends GymMember {

    private int studentId;
    private String major;
    private String sportTeam;

    public StudentMember(PersonalDetails personalDetails, int studentId){
        super(personalDetails);
        this.studentId = studentId;
        this.major = null;
        this.sportTeam = null;
    }

    public int getStudentId(){
        return studentId;
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