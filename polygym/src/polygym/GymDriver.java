package polygym;

import java.time.LocalDate;

public class GymDriver {

    public static void main(String[] args) {

        LocalDate createdAt = LocalDate.now(); // or LocalDate.of(2026, 4, 11)

        PersonalDetails p = new PersonalDetails(
                "Ahmed",
                "Ali",
                createdAt,
                "9876945",
                "holicopter"
        );
        p.setAddress("", 0, 0, 0,"holicopter");
        System.out.println(p.getAddress());
    }
}
