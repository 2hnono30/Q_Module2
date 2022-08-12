package view.account;

import util.EventUtil;
import util.MenuUtil;
import util.UsersEventUtil;

import java.util.Scanner;

public class AdminLogIn {
    static EventUtil eventUtil = new EventUtil();
    public static void adminLogInView(){
        Scanner scanner = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        UsersEventUtil usersEventUtil = new UsersEventUtil();
        try {
            while (true){
                menuUtil.menuUtil("Admin-Menu");
                System.out.println("Chọn chức năng");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (choice) {
                    case "1":
                        usersEventUtil.addAdmin();
                        break;
                    case "2":
                        usersEventUtil.updateAdmin();
                        break;
                    case "3":
                        usersEventUtil.showUsers();
                        break;
                    case "4":
                        usersEventUtil.deleteUsers();
                        break;
                    case "o":
                        usersEventUtil.returnUtil("Sign-Out");
                        break;
                    case "r":
                        usersEventUtil.returnUtil("Admin-Main-Return");
                        break;
                    case "e":
                        usersEventUtil.exitUtil("Admin-Menu-Exit");
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        adminLogInView();
    }
}
