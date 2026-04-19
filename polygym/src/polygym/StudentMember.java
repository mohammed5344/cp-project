import java.util.Date;
public class StudentMember extends GymMember {

    private int studentId;
    private String major;
    private String sportTeam;

    public StudentMember(PersonalDetails personalDetails, int studentId) {
        super(personalDetails);
        this.studentId = studentId;
        this.major = null;
        this.sportTeam = "None";
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

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSportTeam(String sportTeam) {
        this.sportTeam = sportTeam;
    }
}
