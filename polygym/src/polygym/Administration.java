package polygym;
 
import java.util.ArrayList;
 
public class Administration {
    public ArrayList<GymMember> gymMembers;
    public ArrayList<GymEmployee> gymEmployees;
    private ArrayList<PersonalTrainer> gymTrainers;

    public Administration() {
        gymMembers = new ArrayList<>();
        gymEmployees = new ArrayList<>();
        gymTrainers = new ArrayList<>();
    }

    public void addGymMember(GymMember member) {
        if(member == null) {
            throw new IllegalArgumentException("invalid member");
        }
        gymMembers.add(member);
    }

    public void addEmployee(GymEmployee employee) {
        if(employee == null) {
            throw new IllegalArgumentException("invalid employee");
        }
        gymEmployees.add(employee);
    }

    public void addPersonalTrainer(PersonalTrainer trainer) {
        if(trainer == null) {
            throw new IllegalArgumentException("invalid trainer");
        }
        gymTrainers.add(trainer);
        gymEmployees.add(trainer);
    }

    public void removeGymMember(GymMember member) {
        gymMembers.remove(member);
    }

    public void removeEmployee(GymEmployee employee) {
        gymEmployees.remove(employee);
    }

    public void removePersonalTrainer(PersonalTrainer trainer) {
        gymTrainers.remove(trainer);
        gymEmployees.remove(trainer);
    }

    public ArrayList<GymMember> getMembers() {
        return gymMembers;
    }

    public ArrayList<GymEmployee> getEmployees() {
        return gymEmployees;
    }

    public ArrayList<PersonalTrainer> getTrainers() {
        return gymTrainers;
    }
}