package view;
import util.EventUtil;
import util.MenuUtil;
import view.manager.StudentManagerView;
import view.manager.UserManagerView;

import java.util.Scanner;

public class MainMenuView {
    public void mainMenuView(){
        Scanner input = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        EventUtil eventUtil = new EventUtil();
        UserManagerView userManager = new UserManagerView();
        StudentManagerView studentManager = new StudentManagerView();
        try {
            menuUtil.menuUtil("Menu-Main");
            System.out.println("■ Select : ");
            String select = input.nextLine().toLowerCase().replaceAll("\\s", "");
            switch (select){
                case "c":
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
