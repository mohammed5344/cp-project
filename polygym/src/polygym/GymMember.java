import java.util.Date;

public class GymMember {

    private int id;
    private PersonalDetails personalDetails;
    private PersonalDetails assignedTrainer;
    private Membership membership;
    private Date joinDate;

    public GymMember(PersonalDetails personalDetails){
        this.personalDetails = personalDetails;
        assignedTrainer = null;
        membership = null;
        joinDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void addMembership(Membership membership){
        this.membership = membership;
    }

    public void removerMember(){
        if (membership != null){
            membership.cancelMembership();
        }
    }


}
