package util;

import model.UserModel;
import model.enumerate.RoleModel;
import service.implement.UserService;
import view.AuthenticateView;
import view.MainMenuView;
import view.SignInView;

import java.util.List;
import java.util.Scanner;

import static view.account.AdminLogIn.adminLogInView;
import static view.account.UsersLogIn.usersLogInView;

public class UsersEventUtil {
    AlertUtil alertUtil = new AlertUtil();
    static Scanner input = new Scanner(System.in);
    UserService userService = new UserService();
    MenuUtil menuUtil = new MenuUtil();
    static AuthenticateView authenticateView = new AuthenticateView();
    MainMenuView mainMenuView = new MainMenuView();
    static SignInView signInView = new SignInView();

    public UsersEventUtil() {
    }

    public void addAdmin() {
        try {
            alertUtil.alertUtil("User-Name");
            String username = input.nextLine();
            try {
                do {
                    if (!ValidateUtil.isUsernameValid(username)) {
                        alertUtil.alertUtil("Users-Name-Require");
                        alertUtil.alertUtil("User-Name");
                        username = input.nextLine();
                    }
                    if (userService.existsUserName(username)) {
                        alertUtil.alertUtil("UserName-Already-Exist");
                        alertUtil.alertUtil("User-Name");
                        username = input.nextLine();
                    }
                    break;
                } while (true);
                while (!ValidateUtil.isUsernameValid(username)) {
                    alertUtil.alertUtil("Users-Name-Require");
                    alertUtil.alertUtil("User-Name");
                    username = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("PassWord");
            String password = input.nextLine();
            try {
                while (!ValidateUtil.isPasswordValid(password)) {
                    alertUtil.alertUtil("PassWord-Require");
                    alertUtil.alertUtil("PassWord");
                    password = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("FullName");
            String fullName = input.nextLine();
            try {
                while (!ValidateUtil.isNameValid(fullName)) {
                    alertUtil.alertUtil("FullName-Require");
                    alertUtil.alertUtil("FullName");
                    fullName = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("Phone-Number");
            String phone = input.nextLine();
            try {
                do {
                    if (!ValidateUtil.phoneNumberValidateUtil(phone)) {
                        alertUtil.alertUtil("Phone-Number-Require");
                        alertUtil.alertUtil("Phone-Number");
                        phone = input.nextLine();
                    }
                    if (userService.existsUserPhoneNumber(phone)) {
                        alertUtil.alertUtil("Phone-Number-Already-Exist");
                        alertUtil.alertUtil("Phone-Number");
                        phone = input.nextLine();
                    }
                    break;
                } while (true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("Address");
            String address = input.nextLine();
            alertUtil.alertUtil("Email");
            String email = input.nextLine();
            try {
                do {
                    if (!ValidateUtil.isEmailValid(email)) {
                        alertUtil.alertUtil("Email-Require");
                        alertUtil.alertUtil("Email");
                        email = input.nextLine();
                    }
                    if (userService.existsUserEmail(email)) {
                        alertUtil.alertUtil("Email-Already-Exist");
                        alertUtil.alertUtil("Email");
                        email = input.nextLine();
                    }
                    break;
                } while (true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UserModel newUser = new UserModel(username, password, fullName, address, email, phone, RoleModel.STAFF);
            setRole(newUser);
            userService.addUser(newUser);
            alertUtil.alertUtil("Add-Success");
        } catch (Exception e) {
            System.out.println("Nhập sai. vui lòng nhập lại!");
        }
    }

    public void addUsers() {
        try {
            alertUtil.alertUtil("User-Name");
            String username = input.nextLine();
            try {
                do {
                    if (!ValidateUtil.isUsernameValid(username)) {
                        alertUtil.alertUtil("Users-Name-Require");
                        alertUtil.alertUtil("User-Name");
                        username = input.nextLine();
                    }
                    if (userService.existsUserName(username)) {
                        alertUtil.alertUtil("UserName-Already-Exist");
                        alertUtil.alertUtil("User-Name");
                        username = input.nextLine();
                    }
                    break;
                } while (true);
                while (!ValidateUtil.isUsernameValid(username)) {
                    alertUtil.alertUtil("Users-Name-Require");
                    alertUtil.alertUtil("User-Name");
                    username = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("PassWord");
            String password = input.nextLine();
            try {
                while (!ValidateUtil.isPasswordValid(password)) {
                    alertUtil.alertUtil("PassWord-Require");
                    alertUtil.alertUtil("PassWord");
                    password = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("FullName");
            String fullName = input.nextLine();
            try {
                while (!ValidateUtil.isNameValid(fullName)) {
                    alertUtil.alertUtil("FullName-Require");
                    alertUtil.alertUtil("FullName");
                    fullName = input.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("Phone-Number");
            String phone = input.nextLine();
            try {
                do {
                    if (!ValidateUtil.phoneNumberValidateUtil(phone)) {
                        alertUtil.alertUtil("Phone-Number-Require");
                        alertUtil.alertUtil("Phone-Number");
                        phone = input.nextLine();
                    }
                    if (userService.existsUserPhoneNumber(phone)) {
                        alertUtil.alertUtil("Phone-Number-Already-Exist");
                        alertUtil.alertUtil("Phone-Number");
                        phone = input.nextLine();
                    }
                    break;
                } while (true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            alertUtil.alertUtil("Address");
            String address = input.nextLine();
            alertUtil.alertUtil("Email");
            String email = input.nextLine();
            try {
                do {
                    if (!ValidateUtil.isEmailValid(email)) {
                        alertUtil.alertUtil("Email-Require");
                        alertUtil.alertUtil("Email");
                        email = input.nextLine();
                    }
                    if (userService.existsUserEmail(email)) {
                        alertUtil.alertUtil("Email-Already-Exist");
                        alertUtil.alertUtil("Email");
                        email = input.nextLine();
                    }
                    break;
                } while (true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UserModel newUser = new UserModel(username, password, fullName, address, email, phone, RoleModel.STAFF);
            setUsersRole(newUser);
            userService.addUser(newUser);
            alertUtil.alertUtil("Add-Success");
        } catch (Exception e) {
            System.out.println("Nhập sai. vui lòng nhập lại!");
        }
    }

    public void setRole(UserModel user) {
        menuUtil.menuUtil("Set-Role");
        alertUtil.alertUtil("Select");
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                user.setUserRole(RoleModel.ADMIN);
                break;
            case 2:
                user.setUserRole(RoleModel.STAFF);
                break;
            default:
                System.out.println("Nhập không đúng! Vui lòng nhập lại");
                setRole(user);
        }
    }

    public void setUsersRole(UserModel userModel) {
        userModel.setUserRole(RoleModel.STAFF);
    }

    public void showUsers() {
        List<UserModel> users = userService.getUser();
        int userListCount = 1;
        System.out.printf(
                "╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                                    DANH SÁCH NGƯỜI DÙNG                                                                          ║\n" +
                        "╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
                        "║ %-6s║ %-10s║ %-25s║ %-15s║ %-25s║ %-15s║ %-15s║ %-25s║ %-25s║\n" +
                        "╠══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n",
                "LIST", "    ID", "           NAME", "   Địa chỉ", "          Email", " PHONENUMBER", " Người dùng", "        Ngày tạo", "     Ngày cập nhật"
        );
        for (UserModel user : users) {
            System.out.printf("║ %-6s║ %-10s║ %-25s║ %-15s║ %-25s║ %-15s║ %-15s║ %-25s║ %-25s║ \n",
                    userListCount,
                    user.getUserId(),
                    user.getUserFullName(),
                    user.getUserAddress(),
                    user.getUserEmail(),
                    user.getUserPhoneNumber(),
                    user.getUserRole(),
                    FormatUtil.dateFormatUtil(user.getUserCreateDate()),
                    user.getUserUpdateDate() == null ? "" : FormatUtil.dateFormatUtil(user.getUserUpdateDate()));
            userListCount++;
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
    }

    public void deleteUsers() {
        try {
            showUsers();
            alertUtil.alertUtil("Delete-Id");
            long id = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
            while (!userService.existsUserId(id)) {
                alertUtil.alertUtil("Account-Id-Not-Exist");
                alertUtil.alertUtil("Account-Id");
                id = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
            }
            UserModel userNew = userService.getUserById(id);
            alertUtil.alertUtil("Account-Remove-Confirm");
            System.out.println("Select Option : ");
            String choice = input.nextLine().toLowerCase().replaceAll("\\s", "");
            switch (choice) {
                case "y":
                    userService.removeUser(userNew);
                    alertUtil.alertUtil("Account-Remove-Success");
                    adminLogInView();
                    break;
                case "n":
                    alertUtil.alertUtil("Student-Remove-Cancel");
                    adminLogInView();
                    break;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        menuUtil.menuUtil("Delete-Show");
        isRetryDelete();
    }

    public void updateUser() {
        try {
            while (true) {
                showUsers();
                System.out.println("■ Id : ");
                long id = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
                while (!userService.existsUserId(id)) {
                    alertUtil.alertUtil("Student-Id-Render");
                    alertUtil.alertUtil("Student-Id");
                    id = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
                }
                menuUtil.menuUtil("Staff-Edit");
                alertUtil.alertUtil("Select");
                UserModel newUser = new UserModel();
                newUser.setUserId(id);
                String option = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (option) {
                    case "1":
                        alertUtil.alertUtil("FullName");
                        String name = input.nextLine();
                        try {
                            while (!ValidateUtil.isNameValid(name)) {
                                alertUtil.alertUtil("FullName-Require");
                                alertUtil.alertUtil("FullName");
                                name = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        newUser.setUserFullName(name);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("FullName-Edit-Success");
                        break;
                    case "2":
                        alertUtil.alertUtil("Phone-Number");
                        String phone = input.nextLine();
                        try {
                            do {
                                if (!ValidateUtil.phoneNumberValidateUtil(phone)) {
                                    alertUtil.alertUtil("Phone-Number-Require");
                                    alertUtil.alertUtil("Phone-Number");
                                    phone = input.nextLine();
                                }
                                if (userService.existsUserPhoneNumber(phone)) {
                                    alertUtil.alertUtil("Phone-Number-Already-Exist");
                                    alertUtil.alertUtil("Phone-Number");
                                    phone = input.nextLine();
                                }
                                break;
                            } while (true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        newUser.setUserPhoneNumber(phone);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("Phone-Number-Edit-Success");
                        break;
                    case "3":
                        alertUtil.alertUtil("Address");
                        String address = input.nextLine();
                        newUser.setUserAddress(address);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("Address-Edit-Success");
                        break;
                    case "4":
                        alertUtil.alertUtil("Email");
                        String email = input.nextLine();
                        try {
                            do {
                                if (!ValidateUtil.isEmailValid(email)) {
                                    alertUtil.alertUtil("Email-Require");
                                    alertUtil.alertUtil("Email");
                                    email = input.nextLine();
                                }
                                if (userService.existsUserEmail(email)) {
                                    alertUtil.alertUtil("Email-Already-Exist");
                                    alertUtil.alertUtil("Email");
                                    email = input.nextLine();
                                }
                                break;
                            } while (true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        newUser.setUserEmail(email);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("Email-Edit-Success");
                        break;
                    case "r":
                        returnUtil("Staff-Return");
                        break;
                    case "e":
                        exitUtil("Staff-Menu-Exit");
                        break;
                    default:
                }

            }
        } catch (Exception e) {
            System.out.println("Nhập sai! vui lòng nhập lại");
        }
        menuUtil.menuUtil("Add-Update");
        isRetry();
    }

    public void updateAdmin() {
        try {
            while (true) {
                showUsers();
                System.out.println("■ Id : ");
                long id = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
                while (!userService.existsUserId(id)) {
                    alertUtil.alertUtil("Student-Id-Render");
                    alertUtil.alertUtil("Student-Id");
                    id = Long.parseLong(input.nextLine().replaceAll("\\s", ""));
                }
                menuUtil.menuUtil("Staff-Edit");
                alertUtil.alertUtil("Select");
                UserModel newUser = new UserModel();
                newUser.setUserId(id);
                String option = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (option) {
                    case "1":
                        alertUtil.alertUtil("FullName");
                        String name = input.nextLine();
                        try {
                            while (!ValidateUtil.isNameValid(name)) {
                                alertUtil.alertUtil("FullName-Require");
                                alertUtil.alertUtil("FullName");
                                name = input.nextLine();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        newUser.setUserFullName(name);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("FullName-Edit-Success");
                        break;
                    case "2":
                        alertUtil.alertUtil("Phone-Number");
                        String phone = input.nextLine();
                        try {
                            do {
                                if (!ValidateUtil.phoneNumberValidateUtil(phone)) {
                                    alertUtil.alertUtil("Phone-Number-Require");
                                    alertUtil.alertUtil("Phone-Number");
                                    phone = input.nextLine();
                                }
                                if (userService.existsUserPhoneNumber(phone)) {
                                    alertUtil.alertUtil("Phone-Number-Already-Exist");
                                    alertUtil.alertUtil("Phone-Number");
                                    phone = input.nextLine();
                                }
                                break;
                            } while (true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        newUser.setUserPhoneNumber(phone);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("Phone-Number-Edit-Success");
                        break;
                    case "3":
                        alertUtil.alertUtil("Address");
                        String address = input.nextLine();
                        newUser.setUserAddress(address);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("Address-Edit-Success");
                        break;
                    case "4":
                        alertUtil.alertUtil("Email");
                        String email = input.nextLine();
                        try {
                            do {
                                if (!ValidateUtil.isEmailValid(email)) {
                                    alertUtil.alertUtil("Email-Require");
                                    alertUtil.alertUtil("Email");
                                    email = input.nextLine();
                                }
                                if (userService.existsUserEmail(email)) {
                                    alertUtil.alertUtil("Email-Already-Exist");
                                    alertUtil.alertUtil("Email");
                                    email = input.nextLine();
                                }
                                break;
                            } while (true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        newUser.setUserEmail(email);
                        userService.editUser(newUser);
                        alertUtil.alertUtil("Email-Edit-Success");
                        break;
                    case "r":
                        returnUtil("Admin-Acc-Return");
                        break;
                    case "e":
                        exitUtil("Staff-Menu-Exit");
                        break;
                    default:
                }

            }
        } catch (Exception e) {
            System.out.println("Nhập sai! vui lòng nhập lại");
        }
        menuUtil.menuUtil("Add-Update");
        isRetry();
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
                if (option.equals("Admin-Menu-Exit")) adminLogInView();
                if (option.equals("Staff-Menu-Exit")) usersLogInView();
                break;
            default:
        }
    }

    public void returnUtil(String option) {
        if (option.equals("Admin-Return")) {
            alertUtil.alertUtil("Return-Success");
            adminLogInView();
        }
        if (option.equals("Admin-Main-Return")) {
            alertUtil.alertUtil("Return-Success");
            mainMenuView.mainMenuView();
        }
        if (option.equals("Staff-Return")) {
            alertUtil.alertUtil("Return-Success");
            usersLogInView();
        }
        if (option.equals("Admin-Acc-Return")) {
            alertUtil.alertUtil("Return-Success");
            adminLogInView();
        }
        if (option.equals("Staff-Main-Return")) {
            alertUtil.alertUtil("Return-Success");
            authenticateView.authenticateView();
        }
        if (option.equals("Admin-Main-Return")) {
            alertUtil.alertUtil("Return-Success");

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
                        adminLogInView();
                        break;
                    default:
                }
            }
        }
//        if (option.equals("Sign-Out-User")) {
//            while (true) {
//                alertUtil.alertUtil("Sign-Out-Confirm");
//                System.out.println("■ Select : ");
//                String select = input.nextLine().toLowerCase();
//                switch (select) {
//                    case "y":
//                        alertUtil.alertUtil("Sign-Out-Confirm-Success");
//                        authenticateView.authenticateView();
//                        break;
//                    case "n":
//                        alertUtil.alertUtil("Sign-Out-Confirm-Cancel");
//                        userMenuView.userMenuView();
//                        break;
//                    default:
//                }
//            }
//        }
    }

    public static boolean isRetryDelete() {
        do {
            System.out.print(" ⭆ ");
            String option = input.nextLine();
            switch (option) {
                case "r":
                    return false;
                case "e":
                    System.exit(2022);
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        } while (true);
    }

    public static boolean isRetry() {
        do {
            System.out.print(" ⭆ ");
            String option = input.nextLine();
            switch (option) {
                case "b":
                    signInView.signInView();
                    break;
                case "r":
                    return false;
                case "e":
                    System.exit(2022);
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        } while (true);
    }
}
