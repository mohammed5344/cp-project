package polygym;

import java.time.LocalDate;
import java.util.Date;
public class GymMember {

   private int id;
   private PersonalDetails personalDetails;
   private PersonalTrainer assignedTrainer;
   private Membership membership;
   private LocalDate joinDate;

   public GymMember(PersonalDetails personalDetails){
       this.personalDetails = personalDetails;
       assignedTrainer = null;
       membership = null;
       joinDate = LocalDate.now();
   }

   public int getId(){
       return id;
   }

   public PersonalTrainer getTrainer(){
        return assignedTrainer;
    }

   public void addMembership(Membership membership){
       if (membership == null){
           throw new IllegalArgumentException("Membership cannot be null");
       }
       this.membership = membership;
   }

   public void removeTrainer(){
      if (assignedTrainer != null){
          assignedTrainer.removeMember(this);
          assignedTrainer = null;
      }
   }

   public void removeMember(){
       if (membership != null){
           membership.changeStatus(3);
        }
        removeTrainer();
   }

   public void assignTrainer(PersonalTrainer trainer){
       if (trainer == null){
           throw new IllegalArgumentException("Invalid trainer");
       }
       if (assignedTrainer != null){
           assignedTrainer.removeMember(this);
       }
       assignedTrainer = trainer;
       trainer.assignMember(this);
   }




}
