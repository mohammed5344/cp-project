
package polygym;

import java.util.ArrayList;

public class PersonalTrainer extends GymEmployee {
    private ArrayList<GymMember> assignedMembers = new ArrayList<>();
    private PersonalDetails personalDetails;
    public PersonalTrainer(PersonalDetails personalDetails) 
    {
    this.personalDetails = personalDetails;
    }
    private void assignMember(GymMember member) {
        if(member == null) {
            throw new IllegalArgumentException("invalid member");
        }
        this.assignedMembers.add(member);
    }
    
    private void removeMember(GymMember member) {
        if(member == null) {
            throw new IllegalArgumentException("invalid member");
        }
        if(!this.assignedMembers.contains(member)) {
            throw new IllegalArgumentException("member not found within the assigned members to this trainer");
        }
        
        this.assignedMembers.remove(member);
    }
    
    private ArrayList<GymMember> getAssignedMembers() {
        return this.assignedMembers;
    }
}
