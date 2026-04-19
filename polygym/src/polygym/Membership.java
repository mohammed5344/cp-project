import java.util.Date;
public class Membership {

    private int id;
    private GymMember member;
    private Date startDate;
    private Date endDate;
    private String membershipType;
    private String status;
    private boolean paymentStatus;
    private double fee;

    public Membership(GymMember member, String membershipType){
        this.member = member;
        this.membershipType = membershipType;
        startDate = new Date();
        status = "Active";
        paymentStatus = false;
        fee = 0.0;
    }

    public int getId(){
        return id;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public String getMembershipType(){
        return membershipType;
    }

    public String getStatus(){
        return status;
    }

    public boolean getPaymentStatus(){
        return paymentStatus;
    }

    public double getFee(){
        return fee;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void cancelMembership(){
        status = "Cancelled";
        endDate = new Date();
    }
}
