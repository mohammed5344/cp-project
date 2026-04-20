package polygym;

public class StaffMember extends GymMember {

    private int staffId;
    private String position;
    private String department;

    public StaffMember(PersonalDetails personalDetails, int staffId){
        super(personalDetails);
        this.staffId = staffId;
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

    public void setPosition(String position){
        if (position == null){
            throw new IllegalArgumentException("invalid position");
        }
        if (position.length() > 30){
            throw new IllegalArgumentException("position cannot be more than 30 characters");
        }
        if (position.length() < 4){
            throw new IllegalArgumentException("position cannot be less than 4 characters");
        }
        this.position = position;
    }

    public void setDepartment(int buildingNum, int floor, int room) {
        if (department == null){
            throw new IllegalArgumentException("invalid department");
        }
        department = "Building " + buildingNum + ", Floor " + floor + ", Room " + room;
    }
}
