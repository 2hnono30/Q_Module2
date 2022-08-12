package util;

import model.UserModel;
import model.enumerate.RoleModel;
import service.implement.UserService;
import view.AuthenticateView;
import view.MainMenuView;
import view.SignInView;
import view.manager.InputOption;

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
        do {
            try {
                String username = inputUsername();
                String password = inputPassword();
                String fullName = inputFullName(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String address = inputAddress(InputOption.ADD);
                String email = inputEmail();
                UserModel newUser = new UserModel(username, password, fullName, address, email, phone, RoleModel.STAFF);
                setRole(newUser);
                userService.addUser(newUser);
                System.out.println("Đã thêm thành công!\uD83C\uDF8A");
            } catch (Exception e) {
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        } while (isRetry(InputOption.ADD));
    }

    public void addUsers() {
        do {
            try {
                String username = inputUsername();
                String password = inputPassword();
                String fullName = inputFullName(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String address = inputAddress(InputOption.ADD);
                String email = inputEmail();
                UserModel newUser = new UserModel(username, password, fullName, phone, email, address, RoleModel.STAFF);
                setUsersRole(newUser);
                userService.addUser(newUser);
                System.out.println("Đã thêm thành công!\uD83C\uDF8A");
            } catch (Exception e) {
                System.out.println("Nhập sai. vui lòng nhập lại!");
            }
        } while (isRetry(InputOption.ADD));
    }

    private String inputEmail() {
        System.out.println("Nhập email (vd: thuan@gmail.com)");
        System.out.print(" ⭆ ");
        String email;
        do {
            if (!ValidateUtil.isEmailValid(email = input.nextLine())) {
                System.out.println("Email " + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.println("Nhập email (vd: thuan@gmail.com)");
                System.out.print(" ⭆ ");
                continue;
            }
            if (userService.existsUserEmail(email)) {
                System.out.println("Email " + email + "của bạn đã tồn tại! vui lòng kiểm tra lại");
                System.out.println("Nhập email (vd: thuan@gmail.com)");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputAddress(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập địa chỉ (vd: Huế)");
                break;
            case UPDATE:
                System.out.println("Nhập địa chỉ mà bạn muốn đổi");
                break;
        }
        System.out.print(" ⭆ ");
        return input.nextLine();
    }

    public String inputPhone(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số điện thoại (vd: 0345129876): ");
                break;
            case UPDATE:
                System.out.println("Nhập số điện thoại mà bạn muốn đổi");
                break;
        }
        System.out.print(" ⭆ ");
        String phone;
        do {
            phone = input.nextLine();
            if (!ValidateUtil.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                System.out.println("Nhập số điện thoại (vd: 0345129876)");
                System.out.print(" ⭆ ");
                continue;
            }
            if (userService.existsUserPhoneNumber(phone)) {
                System.out.println("Số này đã tồn tại! Mời bạn nhập lại");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (true);

        return phone;
    }

    private String inputFullName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập họ và tên (vd: Ho Thi Thuan) ");
                break;
            case UPDATE:
                System.out.println("Nhập tên mà bạn muốn sửa đổi");
                break;
        }

        System.out.print(" ⭆ ");
        String fullName;
        while (!ValidateUtil.isNameValid(fullName = input.nextLine())) {
            System.out.println("Tên " + fullName + "không đúng định dạng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
            System.out.println("Nhập tên (vd: Ho Thuan) ");
            System.out.print(" ⭆ ");
        }
        return fullName;
    }

    private int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id : ");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa : ");
                break;
            case DELETE:
                System.out.println("Nhập id muốn xóa : ");
                break;
        }
        boolean isRetry = false;
        do {
            id = retryParseInt();
            boolean exist = userService.existsUserId(id);
            switch (option) {
                case ADD:
                    if (exist)
                        System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist)
                        System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;
    }

    public void setRole(UserModel user) {
        System.out.println("= = SET ROLE = =");
        System.out.println("∥   1. USER    ∥");
        System.out.println("∥   2. ADMIN   ∥");
        System.out.println("= = = =  = = = = ");
        System.out.println("Chọn Role: ");
        System.out.print(" ⭆ ");
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                user.setUserRole(RoleModel.STAFF);
                break;
            case 2:
                user.setUserRole(RoleModel.ADMIN);
                break;
            default:
                System.out.println("Nhập không đúng! Vui lòng nhập lại");
                setRole(user);
        }
    }

    public void setUsersRole(UserModel userModel) {
        userModel.setUserRole(RoleModel.STAFF);
    }

    private String inputPassword() {
        System.out.println("Nhập mật khẩu( mật khẩu phải > 8 kí tự )");
        System.out.print(" ⭆ ");
        String password;
        while (!ValidateUtil.isPasswordValid(password = input.nextLine())) {
            System.out.println("Mật khẩu yếu! Vui lòng nhập lại ");
            System.out.print(" ⭆ ");
        }
        return password;
    }

    public String inputUsername() {
        System.out.println("Nhập Username (không bao gồm dấu cách, kí tự đặc biệt)");
        System.out.print(" ⭆ ");
        String username;

        do {
            if (!ValidateUtil.isUsernameValid(username = retryString("Username"))) {
                System.out.println(username + " của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.print(" ⭆ ");
                continue;
            }
            if (userService.existsUserName(username)) {
                System.out.println("Username này đã tồn tại. Vui lòng nhập lại");
                System.out.print(" ⭆ ");
                continue;
            }
            break;
        } while (true);

        return username;
    }

    public void showUsers(InputOption inputOption) {
        List<UserModel> users = userService.getUser();
        int userListCount = 1;
        System.out.printf(
                "╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n" +
                        "║                                                                            DANH SÁCH NGƯỜI DÙNG                                                                ║\n" +
                        "╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n" +
                        "║\t%8s║%15s ║ %25s║ %15s║%25s║%15s║%15s║%25s %s   ║\n" +
                        "╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣\n",
                "LIST    ", "ID      ", "NAME     ", "Địa chỉ      ", "Email          ", "PHONENUMBER   ", "Người dùng     ", "Ngày tạo-Ngày cập nhật", ""
        );
        for (UserModel user : users) {
            System.out.printf("║\t%8s║%15s ║ %25s║ %15s║%25s║%15s║%15s║%25s %s   ║ \n",
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
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
        if (inputOption == InputOption.SHOW) isRetry(InputOption.SHOW);
    }

    public void deleteUsers() {
        try {
            showUsers(InputOption.DELETE);
            long id = inputId(InputOption.DELETE);
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
    }

    public void updateUser() {
        try {
            while (true) {
                showUsers(InputOption.UPDATE);
                //Nếu Id khong Ton tại sẽ không thoát ra khỏi vong lặp trong ham inputId
                int id = inputId(InputOption.UPDATE);
                menuUtil.menuUtil("Staff-Edit");
                UserModel newUser = new UserModel();
                newUser.setUserId(id);
                String option = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (option) {
                    case "1":
                        String name = inputFullName(InputOption.UPDATE);
                        newUser.setUserFullName(name);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi tên thành công!\uD83C\uDF89");
                        break;
                    case "2":
                        String phone = inputPhone(InputOption.UPDATE);
                        newUser.setUserPhoneNumber(phone);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi số điện thoại thành công\uD83C\uDF89");
                        break;
                    case "3":
                        String address = inputAddress(InputOption.UPDATE);
                        newUser.setUserAddress(address);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi địa chỉ thành công\uD83C\uDF89");
                        break;
                    case "4":
                        String email = inputEmail();
                        newUser.setUserEmail(email);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi Email thành công\uD83C\uDF89");
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
    }

    public void updateAdmin() {
        try {
            while (true) {
                showUsers(InputOption.UPDATE);
                //Nếu Id khong Ton tại sẽ không thoát ra khỏi vong lặp trong ham inputId
                int id = inputId(InputOption.UPDATE);
                menuUtil.menuUtil("Staff-Edit");
                alertUtil.alertUtil("Select");
                UserModel newUser = new UserModel();
                newUser.setUserId(id);
                String option = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (option) {
                    case "1":
                        String name = inputFullName(InputOption.UPDATE);
                        newUser.setUserFullName(name);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi tên thành công!\uD83C\uDF89");
                        break;
                    case "2":
                        String phone = inputPhone(InputOption.UPDATE);
                        newUser.setUserPhoneNumber(phone);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi số điện thoại thành công\uD83C\uDF89");
                        break;
                    case "3":
                        String address = inputAddress(InputOption.UPDATE);
                        newUser.setUserAddress(address);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi địa chỉ thành công\uD83C\uDF89");
                        break;
                    case "4":
                        String email = inputEmail();
                        newUser.setUserEmail(email);
                        userService.editUser(newUser);
                        System.out.println("Bạn đã đổi Email thành công\uD83C\uDF89");
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
//        if (option.equals("Sign-Out")) {
//            while (true) {
//                alertUtil.alertUtil("Sign-Out-Confirm");
//                System.out.println("■ Select : ");
//                String select = input.nextLine().toLowerCase();
//                switch (select) {
//                    case "y":
//                        alertUtil.alertUtil("Sign-Out-Confirm-Success");
//                       usersLogInView();
//                        break;
//                    case "n":
//                        alertUtil.alertUtil("Sign-Out-Confirm-Cancel");
//                        mainMenuView.mainMenuView();
//                        break;
//                    default:
//                }
//            }
//        }
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

    public static boolean isRetry(InputOption inputOption) {
        MenuUtil menuUtil = new MenuUtil();
        do {
            switch (inputOption) {
                case ADD:
                    menuUtil.menuUtil("Add-Update");
                    break;
                case UPDATE:
                    menuUtil.menuUtil("Add-Update");
                    break;
                case DELETE:
                    menuUtil.menuUtil("Delete-Show");
                    break;
                case SHOW:
                    menuUtil.menuUtil("Delete-Show");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + inputOption);
            }

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

    public static int retryParseInt() {
        int result;
        do {
            System.out.print(" ⭆ ");
            try {
                result = Integer.parseInt(input.nextLine());
                return result;
            } catch (Exception ex) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (true);
    }

    public static String retryString(String fieldName) {
        String result;
        System.out.print(" ⭆ ");
        while ((result = input.nextLine()).isEmpty()) {
            System.out.printf("%s không được để trống\n", fieldName);
            System.out.print(" ⭆ ");
        }
        return result;
    }
}
