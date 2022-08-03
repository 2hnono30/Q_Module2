import QL_Ung_Vien.Menu.Menu;
import QL_Ung_Vien.Sercive.EmployeeService;
import QL_Ung_Vien.Sercive.ManagerService;
import QL_Ung_Vien.Sercive.Select;
import QL_Ung_Vien.candidateType.Employee;
import QL_Ung_Vien.candidateType.Experience;
import QL_Ung_Vien.candidateType.Fresher;
import QL_Ung_Vien.candidateType.Intern;

import java.util.Scanner;

public class Main {


//    private static void showSkill(Employee employee) {
//        if (employee instanceof Experience) {
//            ((Experience) employee).showSkill();
//        }
//        if (employee instanceof Fresher) {
//            ((Fresher) employee).showSkill();
//        }
//        if (employee instanceof Intern) {
//            ((Intern) employee).showSkill();
//        }
//    }

    public static void main(String[] args) {
        Select select = new Select();
      select.select();
    }
}