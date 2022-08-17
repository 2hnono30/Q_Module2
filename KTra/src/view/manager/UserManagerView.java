package view.manager;

import util.EventUtil;
import util.MenuUtil;

import java.util.Scanner;

public class UserManagerView {
    public void userManagerView(){
        Scanner input = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        EventUtil eventUtil = new EventUtil();
        try {
            menuUtil.menuUtil("User-menu");
            while (true) {
                System.out.println("Input ==> ");
               String input2 = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (input2) {
                    case "1":
                        System.out.println("=============================================================================== Show =======================================================================");
                        eventUtil.renderStudentUtil();
                        menuUtil.menuUtil("User-menu");
                        break;
                    case "2":
                        System.out.println("=============================================================================== Search =======================================================================");
                        eventUtil.searchStudentUtil();
                        menuUtil.menuUtil("User-menu");
                        break;
                    case "3":
                        System.out.println("=============================================================================== Sort =======================================================================");
                        eventUtil.usersortUtil();
                        menuUtil.menuUtil("User-menu");
                        break;
                    case "r":
                        eventUtil.returnUtil("User-lobby");
                        break;
                    case "e":
                        eventUtil.exitUtil("User-Manager-Exit");
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
