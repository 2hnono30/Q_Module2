package view;

import util.EventUtil;
import util.MenuUtil;
import view.manager.StudentManagerView;

import java.util.Scanner;

import static view.account.AdminLogIn.adminLogInView;

public class MainMenuView {
    public void mainMenuView(){
        Scanner input = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        EventUtil eventUtil = new EventUtil();
        StudentManagerView studentManager = new StudentManagerView();
        try {
            while (true) {
                menuUtil.menuUtil("Menu-Main");
                System.out.println("■ Select : ");
                String select = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (select) {
                    case "a":
                        adminLogInView();
                        break;
                    case "p":
                        studentManager.studentManagerView();
                        break;
                    case "o":
                        eventUtil.returnUtil("Sign-Out");
                        break;
                    case "e":
                        eventUtil.exitUtil("Main-Menu-Exit");
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
