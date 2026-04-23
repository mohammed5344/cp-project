package polygym;

import java.io.File;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class GymDriver {

    public static void main(String[] args) {

        ArrayList<GymEmployee> employees = new ArrayList<>();
        ArrayList<GymMember> members = new ArrayList<>();

        File startupFile = new File("startup.txt");

        try (Scanner scanner = new Scanner(startupFile)) {

            int numEmployees = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < numEmployees; i++) {

                String type = scanner.nextLine().trim();

                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                String address = scanner.nextLine();
                String phone = scanner.nextLine();
                double salary = Double.parseDouble(scanner.nextLine());

                PersonalDetails pd = new PersonalDetails(firstName, lastName, phone);
                pd.setAddress(address);

                // ================= EMPLOYEE =================
                if (type.equalsIgnoreCase("E")) {

                    GymEmployee emp = new GymEmployee(pd);
                    employees.add(emp);

                } // ================= PERSONAL TRAINER =================
                else if (type.equalsIgnoreCase("PT")) {

                    PersonalTrainer pt = new PersonalTrainer(pd);

                    int numMembers = Integer.parseInt(scanner.nextLine().trim());

                    for (int j = 0; j < numMembers; j++) {

                        String memberType = scanner.nextLine().trim();

                        if (!memberType.equalsIgnoreCase("staff")
                                && !memberType.equalsIgnoreCase("student")) {
                            throw new IllegalArgumentException("Invalid member type: " + memberType);
                        }

                        String mFirst = scanner.nextLine();
                        String mLast = scanner.nextLine();
                        String mAddress = scanner.nextLine();
                        String mDOBStr = scanner.nextLine();
                        String mPhone = scanner.nextLine();
                        String mGender = scanner.nextLine();

                        LocalDate dob = Helpers.parseDate(mDOBStr);

                        PersonalDetails mpd = new PersonalDetails(
                                mFirst, mLast, dob, mPhone, mGender
                        );
                        mpd.setAddress(mAddress);

                        // ================= STAFF MEMBER =================
                        if (memberType.equalsIgnoreCase("staff")) {

                            String position = scanner.nextLine();
                            String department = scanner.nextLine();

                            StaffMember staff = new StaffMember(mpd);
                            staff.setPosition(position);
                            staff.setDepartment(department);

                            members.add(staff);
                            pt.assignMember(staff);
                        } // ================= STUDENT MEMBER =================
                        else {

                            String degree = scanner.nextLine();
                            String team = scanner.nextLine(); // ALWAYS exists in file

                            StudentMember student = new StudentMember(mpd);
                            student.setDegree(degree);
                            student.setSportTeam(team);

                            members.add(student);
                            pt.assignMember(student);
                        }
                    }

                    employees.add(pt);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n===== EMPLOYEES =====");
        for (GymEmployee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("\n===== STAFF MEMBERS =====");
        for (GymMember m : members) {
            if (m instanceof StaffMember) {
                System.out.println((StaffMember) m);
            }
        }
    }
}
