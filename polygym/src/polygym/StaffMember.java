import java.util.Date;

public class StaffMember extends GymMember {

    private int staffId;
    private String position;
    private String department;

    public StaffMember(PersonalDetails personalDetails, int staffId){
        super(personalDetails);
        this.staffId = staffId;
        this.position= null;
        this.position= null;
    }

    public int getStaffId(){
        return staffId;
    }

    public String getPosition(){
        return position;
    }

    public String getDepartment(){
        return department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(int buildingNum, int floor, int room){
        department = "Building " + buildingNum + ", Floor " + floor + ", Room " + room;
    }
}
