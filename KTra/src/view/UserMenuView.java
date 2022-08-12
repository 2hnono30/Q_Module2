package view;

import util.EventUtil;
import util.MenuUtil;
import view.manager.UserManagerView;

import java.util.Scanner;

public class UserMenuView {
    public void userMenuView(){
        Scanner input = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        EventUtil eventUtil = new EventUtil();
        UserManagerView userManager = new UserManagerView();
        try {
            while (true) {
                menuUtil.menuUtil("User-Lobby");
                System.out.println("■ Select : ");
                String select = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (select) {
                    case "c":
                        userManager.userManagerView();
                        break;
                    case "o":
                        eventUtil.returnUtil("Sign-Out-User");
                        break;
                    case "e":
                        eventUtil.exitUtil("User-Menu-Exit");
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
