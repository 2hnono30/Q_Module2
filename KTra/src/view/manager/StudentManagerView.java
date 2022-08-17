package view.manager;

import util.EventUtil;
import util.MenuUtil;

import java.util.Scanner;

public class StudentManagerView {
    public void studentManagerView(){
        Scanner input = new Scanner(System.in);
        EventUtil eventUtil = new EventUtil();
        MenuUtil menuUtil = new MenuUtil();
        try {
            menuUtil.menuUtil("main-menu");
            while (true) {
                System.out.println("Input ==> ");
               String input2 = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (input2) {
                    case "1":
                        System.out.println("=============================Add Student =============================== ");
                        eventUtil.addStudentUtil();
                        break;
                    case "2":
                        System.out.println("=============================================================================== Show =======================================================================");
                        eventUtil.renderStudentUtil();
                        menuUtil.menuUtil("main-menu");
                        break;
                    case "3":
                        System.out.println("=============================================================================== Search =======================================================================");
                        eventUtil.searchStudentUtil();
                        menuUtil.menuUtil("main-menu");
                        break;
                    case "4":
                        System.out.println("=============================================================================== Edit =======================================================================");
                        eventUtil.editStudentUtil();
                        break;
                    case "5":
                        System.out.println("============================================================================== Remove =======================================================================");
                        eventUtil.removeStudentUtil();
                        break;
                    case "6":
                        eventUtil.sortUtil();
                        menuUtil.menuUtil("main-menu");
                        break;
                    case "r":
                        eventUtil.returnUtil("Main-menu-Return");
                        break;
                    case "e":
                        eventUtil.exitUtil("Student-Manager-Exit");
                        break;


                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
