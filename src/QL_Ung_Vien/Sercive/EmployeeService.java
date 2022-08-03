package QL_Ung_Vien.Sercive;


import QL_Ung_Vien.Menu.Menu;
import QL_Ung_Vien.candidateType.Employee;
import QL_Ung_Vien.candidateType.Experience;
import QL_Ung_Vien.candidateType.Fresher;
import QL_Ung_Vien.candidateType.Intern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeService {
    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    private final List<Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new ArrayList<>();
    }
    public void insert(Employee employee){
        this.employeeList.add(employee);
    }
    public Employee findById(Long id){
        return this.employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }
    public boolean deleteById(Long id){
        Employee employee = this.findById(id);
        if (employee == null){return false;}
        this.employeeList.remove(employee);
        return true;
    }
    public List<Employee> findByType (int type){
        return this.employeeList.stream().filter(employee -> {
            if (type == 0){
                return employee instanceof Experience;
            }
            if (type == 1){
                return employee instanceof Fresher;
            }
            if (type == 2){
                return employee instanceof Intern;
            }return false;
        }).collect(Collectors.toList());
    }
    public List<Employee> findAll(){
        return this.employeeList;
    }
    public void exitUtil() {
        System.out.println("Exit ???");
        System.out.println("■ Select : " + " [y].yes " + " [n].no ");
        String select = scanner.nextLine().toLowerCase();
        switch (select) {
            case "y":
                System.out.println("Exit Success");
                System.exit(2022);
                System.out.println(" thanks for using ");
                break;
            case "n":

                break;
        }
    }
}
