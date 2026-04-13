
package polygym;

import java.util.ArrayList;
import java.time.LocalDate;

public class Membership {

    private static final ArrayList<Integar> membershipTypes = new ArrayList<>(Arrays.asList(1,30,90,365)); // duration in days (1 for one day try) 
    private static final ArrayList<String> status = new ArrayList<>(Arrays.asList("active", "suspended", "cancelled"));  
    private static numOfMemberships = 0;

    private int id;
    private GymMember member;
    private LocalDate startDate;
    private LocalDate endDate;
    private int duration; // membership duration in days
    private String status; // active, cancelled or suspended
    private boolean MembershipPaymentStatus; // fees can apply to additional stuff so that value include only the subscription
    private double fees;

    public Membership(GymMember member, LocalDate startDate, int duration) {
        if (member == null || startDate == null || membershipType == null) {
            throw new IllegalArgumentException("invalid missing input");
        }

        if !(validmembershipType(membershipType)) {
            throw new IllegalArgumentException("invalid membership type");
        }

        numOfMemberships++;
        this.id = numOfMemberships;
        this.member = member;
        this.startDate = startDate;
        this.duration = duration;
        this.status = "Active";

    }

    private boolean validmembershipType(int duration) {
        return membershipTypes.contains(duration);
    }

    // 1 = active,      2 = suspended     3 = cancelled
    public void changeStatus(String statusCode) {
        switch(statusCode) {
            case 1:
                this.status = status[0];
                break;
            case 2:
                this.status = status[1];
                break;
            case 3:
                this.status = status[2];
                break;
            default:
                throw new IllegalArgumentException("invalid status code");
                break;
        }
    }

    private void addFees(double fees, double discount) {
        this.fees += (fees - (fees * discount));
    }

    private void payFees(double paymentAmount) {
        if (paymentAmount > this.fees) {
            throw new IllegalArgumentException("payment Amount is more than the fees");
        }

        this.fees -= paymentAmount;
    }

    // automaticaly set end date
    private void setEndDate() {
        if ( this.startDate == null) {
            throw new IllegalArgumentException("start date not set");
        } 
        if (this.duration == null ) {
            throw new IllegalArgumentException("no duraction set");
        }
        this.endDate = this.startDate.plusDays(this.duration);
    }


}
