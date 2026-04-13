package polygym;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Membership {

    //map where key => value (duration => price)
    private static final HashMap<Integer, Integer> membershipTypes = new HashMap<>(Map.of(
            1, 3,
            30, 20,
            90, 50,
            365, 120
    ));

    private static final ArrayList<String> statusList = new ArrayList<>(Arrays.asList("active", "suspended", "cancelled"));
    public static int numOfMemberships = 0;
    private int feeCounter = 0;
    private int id;
    private GymMember member;
    private LocalDate startDate;
    private LocalDate endDate;
    private int duration; // membership duration in days
    private String status; // active, cancelled or suspended
    private HashMap<Integer, HashMap> feeList = new HashMap<>();
    private double fees;

    public Membership(GymMember member, LocalDate startDate, int duration, double discount) {

        if (!validDuration(duration)) {
            throw new IllegalArgumentException("invalid Duration");
        }
        if (member == null) {
            throw new IllegalArgumentException("invalid member");
        }
        
        this.member = member;
        if (startDate == null) {
            this.startDate = LocalDate.now();
        } else {
            if (!valideStartDate(startDate)) {
                throw new IllegalArgumentException("invalid Start Date");
            }
            this.startDate = startDate;
        }
        this.duration = duration;
        this.status = statusList.get(0);

        //automatically set end date
        this.setEndDate();

        // add user
        numOfMemberships++;
        this.id = numOfMemberships;

        //add fee
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("invalid discount");
        }
        double membershipFee = membershipTypes.get(duration);
        this.fees = membershipFee - (membershipFee * discount);
    }

    private boolean validDuration(int duration) {
        return membershipTypes.containsKey(duration);
    }

    private boolean valideStartDate(LocalDate startDate) {
        return !startDate.isBefore(LocalDate.now());
    }

    private void setEndDate() {
        if (this.startDate == null) {
            throw new IllegalArgumentException("no start date set");
        }
        this.endDate = this.startDate.plusDays(this.duration);
    }

    private void addFeeItem(HashMap feeItem) {
        this.feeCounter++;
        this.feeList.put(this.feeCounter, feeItem);
    }

    public void changeStatus(int statusCode) {
        switch (statusCode) {
            case 1:
                this.status = statusList.get(0);
                break;
            case 2:
                this.status = statusList.get(1);
                break;
            case 3:
                this.status = statusList.get(2);
                break;
            default:
                throw new IllegalArgumentException("Invalid status code");
        }
    }

    public void payFees(double amount, double discount) {
        if (amount < 0) {
            throw new IllegalArgumentException("invalid amount");
        }
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("invalid discount");
        }
        if (amount > this.fees) {
            throw new IllegalArgumentException("invalid payment: amount is larger than the fees");
        }
        this.fees -= (amount - (amount * discount));
    }

    public void addFee(String description, double amount, double discount) {
        if (description == null || description.length() == 0) {
            throw new IllegalArgumentException("invalid payment: amount is larger than the fees");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("invalid amount");
        }
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("invalid discount");
        }
        HashMap<String, Double> feeItem = new HashMap<>();
        feeItem.put(description, (amount - (amount * discount)));
        this.addFeeItem(feeItem);
        this.fees += (amount - (amount * discount));
    }

    public void changeEndDate(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("invalid days count");
        }
        this.endDate = this.endDate.plusDays(days);
    }

    public int getID() {
        return this.id;
    }

    public static HashMap<Integer, Integer> getMembershipTypes() {
        return membershipTypes;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public double getFees() {
        return fees;
    }

    public GymMember getMember() {
        return this.member;
    }

    public HashMap getFeeList() {
        return this.feeList;
    }

}
