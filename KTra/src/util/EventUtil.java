package util;

import model.StudentModel;
import service.implement.StudentService;
import service.implement.UserService;
import view.AuthenticateView;
import view.MainMenuView;
import view.SignInView;
import view.UserMenuView;
import view.manager.StudentManagerView;
import view.manager.UserManagerView;

import java.util.ArrayList;
import java.util.Scanner;

public class EventUtil {
    Scanner input = new Scanner(System.in);
    UserService userService = new UserService();
    StudentManagerView studentManagerView = new StudentManagerView();
    UserManagerView userManagerView = new UserManagerView();
    UserMenuView userMenuView = new UserMenuView();
    AuthenticateView authenticateView = new AuthenticateView();
    MainMenuView mainMenuView = new MainMenuView();
    SignInView signInView = new SignInView();
    MenuUtil menuUtil = new MenuUtil();
    AlertUtil alertUtil = new AlertUtil();
    StudentService studentService = new StudentService();
    StudentModel studentModel = new StudentModel();

    public void renderStudentUtil() {
        ArrayList<StudentModel> studentList = studentService.getStudent();
        try {
            int studentCount = 1;
            System.out.printf(

                    "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                            "║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║%s    ║\n" +
                            "╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n",

                    "LIST", "     ID", "        NAME", "   DOB", "   SEX", "  PHONENUMBER", "      UNIVERCITYNAME", "  GRADELEVEL"
            );
            for (StudentModel temp : studentList) {
                System.out.printf("║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║ %-15s%s\n",
                        studentCount,
                        temp.getStudentId(),
                        temp.getFullName(),
                        temp.getDoB(),
                        temp.getSex(),
                        temp.getPhoneNumber(),
                        temp.getUniversityName(),
                        temp.getGradeLevel(), "║");
                studentCount++;
            }
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addStudentUtil() {
        try {
            long studentId = (System.currentTimeMillis() / 100000);
            System.out.println("Input studentName ==> ");
            String studentName = input.nextLine();
            try {
                while (!ValidateUtil.studentNameValidateUtil(studentName)) {
                    alertUtil.alertUtil("Student-Name-Require");
                    alertUtil.alertUtil("Student-Name");
                    studentName = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Input DOB => ");
            String dob = input.nextLine();
            try {
                while (!ValidateUtil.dateOfBirthvalidateUtil(dob)) {
                    alertUtil.alertUtil("DateOfBirth-Require");
                    alertUtil.alertUtil("Date Of Birth");
                    dob = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("input Sex => ");
            String sex = input.nextLine();
            try {
                while (!ValidateUtil.sexValidateUtil(sex)) {
                    alertUtil.alertUtil("Sex-Require");
                    alertUtil.alertUtil("Sex");
                    sex = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Input phoneNumber => ");
            String phoneNumber = input.nextLine();
            try {
                while (!ValidateUtil.phoneNumberValidateUtil(phoneNumber)) {
                    alertUtil.alertUtil("Phone-Number-Require");
                    alertUtil.alertUtil("Phone-Number");
                    phoneNumber = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Input univercityName => ");
            String univercityName = input.nextLine();

            System.out.println("Input gradeLevel => ");
            System.out.println(" 1. Excellent");
            System.out.println(" 2. Very good");
            System.out.println(" 3. Good");
            System.out.println(" 4. Passable");
            System.out.println("enter the number => ");
            int choi = Integer.parseInt(input.nextLine());
            switch (choi) {
                case 1:
                    studentModel.setGradeLevel("Excellent");
                    break;
                case 2:
                    studentModel.setGradeLevel("Very good");
                    break;
                case 3:
                    studentModel.setGradeLevel("Good");
                    break;
                case 4:
                    studentModel.setGradeLevel("Passable");
                    break;
                default:
                    System.out.println("Nhập Lại : ");
            }
            StudentModel studentList = new StudentModel(studentId, studentName, dob, sex, phoneNumber, univercityName, studentModel.getGradeLevel());

            studentService.addStudent(studentList);
            studentService.studentSortByFullName();
            System.out.println(" Add Success ");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        menuUtil.menuUtil("main-menu");
    }

    public void editStudentUtil() {
        try {
            int choice1 = 0;
            while (choice1 != 2) {
                renderStudentUtil();
                menuUtil.menuUtil("Edit-menu");
                System.out.println("Input the munber : ");
                int choice = Integer.parseInt(input.nextLine());
                if (choice == 5) {
                    menuUtil.menuUtil("main-menu");
                    break;
                }
                System.out.println("■ StudentId : ");
                long studentId = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
                while (!studentService.existsStudentId(studentId)) {
                    alertUtil.alertUtil("Student-Id-Render");
                    alertUtil.alertUtil("Student-Id");
                    studentId = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
                }
                StudentModel studentModel = new StudentModel();
                studentModel.setStudentId(studentId);
                switch (choice) {
                    case 1:
                        alertUtil.alertUtil("Student-Name");
                        String studentName = input.nextLine();
                        try {
                            while (!ValidateUtil.studentNameValidateUtil(studentName)) {
                                alertUtil.alertUtil("Student-Name-Require");
                                alertUtil.alertUtil("Student-Name");
                                studentName = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        studentModel.setFullName(studentName);
                        studentService.editStudent(studentModel);
                        alertUtil.alertUtil("Student-Edit-Name-Success");
                        renderStudentUtil();
                        break;
                    case 2:
                        alertUtil.alertUtil("Date Of Birth");
                        String dob = input.nextLine();
                        try {
                            while (!ValidateUtil.dateOfBirthvalidateUtil(dob)) {
                                alertUtil.alertUtil("DateOfBirth-Require");
                                alertUtil.alertUtil("Date Of Birth");
                                dob = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        studentModel.setDoB(dob);
                        studentService.editStudent(studentModel);
                        alertUtil.alertUtil("DateOfBirth-Edit-Success");
                        renderStudentUtil();
                        break;
                    case 3:
                        alertUtil.alertUtil("Sex");
                        String sex = input.nextLine();
                        try {
                            while (!ValidateUtil.sexValidateUtil(sex)) {
                                alertUtil.alertUtil("Sex-Require");
                                alertUtil.alertUtil("Sex");
                                sex = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        studentModel.setSex(sex);
                        studentService.editStudent(studentModel);
                        alertUtil.alertUtil("Sex-Edit-Success");
                        renderStudentUtil();
                        break;
                    case 4:
                        alertUtil.alertUtil("Phone-Number");
                        String phoneNumber = input.nextLine();
                        try {
                            while (!ValidateUtil.phoneNumberValidateUtil(phoneNumber)) {
                                alertUtil.alertUtil("Phone-Number-Require");
                                alertUtil.alertUtil("Phone-Number");
                                phoneNumber = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        studentModel.setPhoneNumber(phoneNumber);
                        studentService.editStudent(studentModel);
                        alertUtil.alertUtil("Phone-Number-Edit-Success");
                        renderStudentUtil();
                        break;
                    default:
                }
                alertUtil.alertUtil("Continue");
                alertUtil.alertUtil("Continue-rep");
                int continu = Integer.parseInt(input.nextLine());
                if (continu == 2) {
                    choice1 = 2;
                    menuUtil.menuUtil("main-menu");
                }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void studentSortByFullNameUtil() {
        ArrayList<StudentModel> studentList = studentService.studentSortByFullName();
        int studentCount = 1;
        System.out.printf(

                "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║%s    ║\n" +
                        "╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n",

                "LIST", "     ID", "        NAME", "   DOB", "   SEX", "  PHONENUMBER", "      UNIVERCITYNAME", "  GRADELEVEL"
        );
        for (StudentModel temp : studentList) {
            System.out.printf("║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║ %-15s%s\n", studentCount, temp.getStudentId(), temp.getFullName(), temp.getDoB(), temp.getSex(), temp.getPhoneNumber(), temp.getUniversityName(), temp.getGradeLevel(), "║");
            studentCount++;
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
    }

    public void studentSortByPhoneNumberUtil() {
        ArrayList<StudentModel> studentList = studentService.studentSortByPhoneNumber();
        int studentCount = 1;
        System.out.printf(

                "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║%s    ║\n" +
                        "╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n",

                "LIST", "     ID", "        NAME", "   DOB", "   SEX", "  PHONENUMBER", "      UNIVERCITYNAME", "  GRADELEVEL"
        );
        for (StudentModel temp : studentList) {
            System.out.printf("║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║ %-15s%s\n", studentCount, temp.getStudentId(), temp.getFullName(), temp.getDoB(), temp.getSex(), temp.getPhoneNumber(), temp.getUniversityName(), temp.getGradeLevel(), "║");
            studentCount++;
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
    }

    public void sortUtil() {
        menuUtil.menuUtil("Sort-menu");
        while (true) {
            System.out.println("Enter the number : ");
            String choice = input.nextLine().toLowerCase().replaceAll("\\s", "");
            switch (choice) {
                case "1":
                    studentSortByFullNameUtil();
                    menuUtil.menuUtil("Sort-menu");
                    break;
                case "2":
                    studentSortByPhoneNumberUtil();
                    menuUtil.menuUtil("Sort-menu");
                    break;
                case "r":
                    returnUtil("Uses-Return");
                    break;
                case "e":
                    exitUtil("User-Manager-Exit");
                    break;
            }
        }
    }

    public void removeStudentUtil() {
        renderStudentUtil();
        alertUtil.alertUtil("Student-Id");
        long studentId = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
        while (!studentService.existsStudentId(studentId)) {
            alertUtil.alertUtil("Student-Id-Not-Exist");
            alertUtil.alertUtil("Student-Id");
            studentId = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
        }
        StudentModel studentModel = studentService.getStudentById(studentId);
        alertUtil.alertUtil("Student-Remove-Confirm");
        System.out.println("Select Option : ");
        String choice = input.nextLine().toLowerCase().replaceAll("\\s", "");
        switch (choice) {
            case "y":
                studentService.removeStudent(studentModel);
                alertUtil.alertUtil("Student-Remove-Success");
                menuUtil.menuUtil("main-menu");
                renderStudentUtil();
                break;
            case "n":
                alertUtil.alertUtil("Student-Remove-Cancel");
                menuUtil.menuUtil("main-menu");
                renderStudentUtil();
                break;
        }
    }

    public void searchStudentUtil() {
        ArrayList<StudentModel> studentList = studentService.getStudent();
        int studentCount = 1;
        System.out.println("■ Type a student name you want to search:");
        String search = input.nextLine();
        while (search.isEmpty()) {
            System.out.println("■ Student search cant not left empty, please try again!");
            System.out.print("■ Type a student name you want to search: ");
            search = input.nextLine();
        }
        System.out.println("■ Keyword search results '" + search + "' are:");
        search = search.toLowerCase();
        System.out.printf(

                "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║%s    ║\n" +
                        "╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n",

                "LIST", "     ID", "        NAME", "   DOB", "   SEX", "  PHONENUMBER", "      UNIVERCITYNAME", "  GRADELEVEL"
        );
        for (StudentModel temp : studentList) {
            if (temp.getFullName().toLowerCase().contains(search)) {
                System.out.printf("║\t%-8s║ %-15s║ %-25s║%-12s║ %-10s║ %-15s║ %-26s║ %-15s%s\n", studentCount, temp.getStudentId(), temp.getFullName(), temp.getDoB(), temp.getSex(), temp.getPhoneNumber(), temp.getUniversityName(), temp.getGradeLevel(), "║");
                studentCount++;
            }
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
//        menuUtil.menuUtil("main-menu");
    }

    public void signInUtil() {
        try {
            alertUtil.alertUtil("Sign-In-Username");
            String userName = input.nextLine().replaceAll("\\s", "");
            alertUtil.alertUtil("Sign-In-Password");
            String userPassword = input.nextLine().replaceAll("\\s", "");
            if (userService.signIn(userName, userPassword) == null) {
                if (userService.signInUser(userName, userPassword) == null) {
                    alertUtil.alertUtil("Sign-In-Wrong");
                }else {
                    alertUtil.alertUtil("Sign-In-Success");
                    userMenuView.userMenuView();}
            } else{
                alertUtil.alertUtil("Sign-In-Success");
                mainMenuView.mainMenuView();
            }
//            if (userService.signInUser(userName, userPassword) == null) {
//                alertUtil.alertUtil("Sign-In-Wrong");
//            } else {
//                alertUtil.alertUtil("Sign-In-Success");
//                userMenuView.userMenuView();
//            }
        } catch (Exception e) {
            alertUtil.alertUtil("Invalid-Input");
        }
    }

    public void returnUtil(String option) {
        if (option.equals("Authenticate-Return")) {
            alertUtil.alertUtil("Return-Success");
            authenticateView.authenticateView();
        }
        if (option.equals("Uses-Return")) {
            alertUtil.alertUtil("Return-Success");
            userManagerView.userManagerView();
        }
        if (option.equals("User-lobby")) {
            alertUtil.alertUtil("Return-Success");
            userMenuView.userMenuView();
        }
        if (option.equals("Main-menu-Return")) {
            alertUtil.alertUtil("Return-Success");
            mainMenuView.mainMenuView();
        }
        if (option.equals("Student-Manager-Return")) {
            alertUtil.alertUtil("Return-Success");
            studentManagerView.studentManagerView();
        }
        if (option.equals("Sign-Out")) {
            while (true) {
                alertUtil.alertUtil("Sign-Out-Confirm");
                System.out.println("■ Select : ");
                String select = input.nextLine().toLowerCase();
                switch (select) {
                    case "y":
                        alertUtil.alertUtil("Sign-Out-Confirm-Success");
                        authenticateView.authenticateView();
                        break;
                    case "n":
                        alertUtil.alertUtil("Sign-Out-Confirm-Cancel");
                        mainMenuView.mainMenuView();
                        break;
                    default:
                }
            }
        }
        if (option.equals("Sign-Out-User")) {
            while (true) {
                alertUtil.alertUtil("Sign-Out-Confirm");
                System.out.println("■ Select : ");
                String select = input.nextLine().toLowerCase();
                switch (select) {
                    case "y":
                        alertUtil.alertUtil("Sign-Out-Confirm-Success");
                        authenticateView.authenticateView();
                        break;
                    case "n":
                        alertUtil.alertUtil("Sign-Out-Confirm-Cancel");
                        userMenuView.userMenuView();
                        break;
                    default:
                }
            }
        }
    }

    public void exitUtil(String option) {
        alertUtil.alertUtil("Exit-Confirm");
        System.out.println("■ Select : ");
        String select = input.nextLine().toLowerCase();
        switch (select) {
            case "y":
                alertUtil.alertUtil("Exit-Confirm-Success");
                System.exit(2022);
                break;
            case "n":
                alertUtil.alertUtil("Exit-Confirm-Cancel");
                if (option.equals("Authenticate-Exit")) authenticateView.authenticateView();
                if (option.equals("Sign-In-Exit")) signInView.signInView();
                if (option.equals("Main-Menu-Exit")) mainMenuView.mainMenuView();
                if (option.equals("Student-Manager-Exit")) studentManagerView.studentManagerView();
                if (option.equals("User-Manager-Exit")) userManagerView.userManagerView();
                if (option.equals("User-Sort-Exit")) sortUtil();
                if (option.equals("User-Menu-Exit")) userMenuView.userMenuView();
                break;
            default:
        }
    }
}
