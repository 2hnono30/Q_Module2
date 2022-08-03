package QL_Ung_Vien.Sercive;

import QL_Ung_Vien.Menu.Menu;

import java.util.Scanner;

public class Select {
    public void select() {
        Menu menu = new Menu();
        ManagerService managerService = new ManagerService();
        EmployeeService employeeService = new EmployeeService();
        Scanner in = new Scanner(System.in);
        while (true) {
            menu.menu("menu-main");
            System.out.println("Select : ");
            String function = in.nextLine().toLowerCase().replaceAll("\\s", "");
            switch (function) {
                case "1":
                    System.out.println("=====Insert=====");
                    System.out.println("input Type : " + "0: Experience" + "1: Fresher" + "2:Intern");
                    int type = Integer.parseInt(in.nextLine());
                    managerService.insert(type);
                    break;
                case "2":
                    System.out.println("=====Show=====");
                    managerService.showAllEmployee();
                    break;
                case "3":
                    System.out.println("=====Edit=====");
                    System.out.println("input Type : " + "0: Experience" + "1: Fresher" + "2:Intern");
                    int type1 = Integer.parseInt(in.nextLine());
                    managerService.showAllEmployee();
                    managerService.update(type1);
                    break;
                case "4":
                    System.out.println("=====Delete=====");
                    managerService.delete();
                    break;
                case "e":
                    employeeService.exitUtil();
                    break;
            }
        }
    }
}
