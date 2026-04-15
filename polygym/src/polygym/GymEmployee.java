
package polygym;

public class GymEmployee {
    private int id;
    private int employeeCounter;
    private PersonalDetails personalDetails;
    private double salary;
    public GymEmployee(PersonalDetails personalDetails) {
        
        if(personalDetails == null) {
            throw new IllegalArgumentException("invalid personal details");
        }
        
        employeeCounter++;
        this.id = employeeCounter;
        this.personalDetails = personalDetails;
    }

    public int getId() {
        return id;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        if(salary <= 0) {
            throw new IllegalArgumentException("salary cannot be negative");
        }
        if(salary > 999999999) {
            throw new IllegalArgumentException("salary is too larg");
        }
        
        this.salary = salary;
    }
}
