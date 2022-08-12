package view.account;

import util.MenuUtil;
import util.UsersEventUtil;
import view.SignInView;

import java.util.Scanner;



public class UsersLogIn {
    static SignInView signInView = new SignInView();
    public static void usersLogInView(){
        Scanner scanner = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        UsersEventUtil usersEventUtil = new UsersEventUtil();
        try {
            while (true){
                menuUtil.menuUtil("Staff-Menu");
                System.out.println("Chọn chức năng");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (choice) {
                    case "1":
                        usersEventUtil.addUsers();
                        break;
                    case "2":
                        usersEventUtil.updateUser();
                        break;
                    case "b":
                        signInView.signInView();
                        break;
                    case "r":
                        usersEventUtil.returnUtil("Staff-Main-Return");
                        break;
                    case "e":
                        usersEventUtil.exitUtil("Staff-Menu-Exit");
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
