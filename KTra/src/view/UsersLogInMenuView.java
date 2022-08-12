package view;

import util.MenuUtil;

import java.util.Scanner;

public class UsersLogInMenuView {
    public void usersLogInMenuView(){
        Scanner input = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        try {
            menuUtil.menuUtil("User-Lobby");
            System.out.println("■ Select : ");
            String select = input.nextLine().toLowerCase().replaceAll("\\s", "");
            switch (select){
//                case "c":
//                    userManager.userManagerView();
//                    break;
//                case "o":
//                    eventUtil.returnUtil("Sign-Out-User");
//                    break;
//                case "e":
//                    eventUtil.exitUtil("User-Menu-Exit");
//                    break;
//                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
