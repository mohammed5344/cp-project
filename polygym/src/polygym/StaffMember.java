package polygym;

public class StaffMember extends GymMember {

    private int staffId;
    private String position;
    private String department;
    private static int numOfMembers = 0;
    public StaffMember(PersonalDetails personalDetails){
        super(personalDetails);
        if(personalDetails == null) {
            throw new IllegalArgumentException("invalid personal details");
        }
        numOfMembers++;
        this.staffId = numOfMembers;
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
    
    public void setDepartment(String department) {
        if (department == null || department.length() == 0 || department.length() > 100){
            throw new IllegalArgumentException("invalid department");
        }
        this.department = department;
    }
}