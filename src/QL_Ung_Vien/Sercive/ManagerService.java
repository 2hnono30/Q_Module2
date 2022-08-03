package QL_Ung_Vien.Sercive;

import QL_Ung_Vien.Menu.Menu;
import QL_Ung_Vien.candidateType.Employee;
import QL_Ung_Vien.candidateType.Experience;
import QL_Ung_Vien.candidateType.Fresher;
import QL_Ung_Vien.candidateType.Intern;
import QL_Ung_Vien.util.ValidateUtil;
import jdk.jfr.internal.tool.Main;

import java.util.Scanner;

public class ManagerService {
    Scanner scanner = new Scanner(System.in);
    ValidateUtil validateUtil = new ValidateUtil();
    Experience experience = new Experience();
    Fresher fresher = new Fresher();
    Intern intern = new Intern();
    Select select = new Select();
    Menu menu = new Menu();
    private final EmployeeService employeeService = new EmployeeService();

    public void insert(int type) {
        Employee employee = null;
        if (type == 0) {
            employee = insertExperience();
        }
        if (type == 1) {
            employee = insertFresher();
        }
        if (type == 2) {
            employee = insertIntern();
        }
        this.employeeService.insert(employee);
    }


    private Experience insertExperience() {
        try {
            Long id = (System.currentTimeMillis() / 1000000);
            System.out.println("Input fullName : ");
            String fullName = scanner.nextLine();
            try {
                while (!validateUtil.NameValidateUtil(fullName)) {
                    System.out.println("Invalid input name !!!");
                    System.out.println("Input FullName : ");
                    fullName = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input BirthDay : ");
            String birthDay = scanner.nextLine();
            try {
                while (!validateUtil.BirthDayValidateUtil(birthDay)) {
                    System.out.println("Invalid input birthDay !!!");
                    System.out.println("Input BirthDay : ");
                    birthDay = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input Phone : ");
            String phone = scanner.nextLine();
            try {
                while (!validateUtil.phoneNumberValidateUtil(phone)) {
                    System.out.println("Invalid input phone !!!");
                    System.out.println("Input Phone : ");
                    phone = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input Email : ");
            String email = scanner.nextLine();
            try {
                while (!validateUtil.emailvalidateUtil(email)) {
                    System.out.println("Invalid input email !!!");
                    System.out.println("Input Email : ");
                    email = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input expInYear : ");
            int expInYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Input proSkill : ");
            String proSkill = scanner.nextLine();
            Experience experience = new Experience(id, fullName, birthDay, phone, email, expInYear, proSkill);
            this.employeeService.insert(experience);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return experience;
    }

    private Fresher insertFresher() {
        try {
            Long id = (System.currentTimeMillis() / 1000000);
            System.out.println("Input fullName : ");
            String fullName = scanner.nextLine();
            try {
                while (!validateUtil.NameValidateUtil(fullName)) {
                    System.out.println("Invalid input name !!!");
                    System.out.println("Input FullName : ");
                    fullName = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input BirthDay : ");
            String birthDay = scanner.nextLine();
            try {
                while (!validateUtil.BirthDayValidateUtil(birthDay)) {
                    System.out.println("Invalid input birthDay !!!");
                    System.out.println("Input BirthDay : ");
                    birthDay = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input Phone : ");
            String phone = scanner.nextLine();
            try {
                while (!validateUtil.phoneNumberValidateUtil(phone)) {
                    System.out.println("Invalid input phone !!!");
                    System.out.println("Input Phone : ");
                    phone = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input Email : ");
            String email = scanner.nextLine();
            try {
                while (!validateUtil.emailvalidateUtil(email)) {
                    System.out.println("Invalid input email !!!");
                    System.out.println("Input Email : ");
                    email = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input graduationDate : ");
            String graduationDate = scanner.nextLine();

            System.out.println("Input graduationRank : ");
            String graduationRank = scanner.nextLine();

            System.out.println("Input education : ");
            String education = scanner.nextLine();

            Fresher fresher = new Fresher(id, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
            this.employeeService.insert(fresher);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return fresher;
    }

    private Intern insertIntern() {
        try {
            Long id = (System.currentTimeMillis() / 1000000);
            System.out.println("Input fullName : ");
            String fullName = scanner.nextLine();
            try {
                while (!validateUtil.NameValidateUtil(fullName)) {
                    System.out.println("Invalid input name !!!");
                    System.out.println("Input FullName : ");
                    fullName = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input BirthDay : ");
            String birthDay = scanner.nextLine();
            try {
                while (!validateUtil.BirthDayValidateUtil(birthDay)) {
                    System.out.println("Invalid input birthDay !!!");
                    System.out.println("Input BirthDay : ");
                    birthDay = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input Phone : ");
            String phone = scanner.nextLine();
            try {
                while (!validateUtil.phoneNumberValidateUtil(phone)) {
                    System.out.println("Invalid input phone !!!");
                    System.out.println("Input Phone : ");
                    phone = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input Email : ");
            String email = scanner.nextLine();
            try {
                while (!validateUtil.emailvalidateUtil(email)) {
                    System.out.println("Invalid input email !!!");
                    System.out.println("Input Email : ");
                    email = scanner.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Input majors : ");
            String majors = scanner.nextLine();

            System.out.println("Input semester : ");
            int semester = Integer.parseInt(scanner.nextLine());

            System.out.println("Input universityName : ");
            String universityName = scanner.nextLine();

            Intern intern = new Intern(id, fullName, birthDay, phone, email, majors, semester, universityName);
            this.employeeService.insert(intern);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return intern;
    }
    public void update(int type) {
        Employee employee = null;
        if (type == 0) {
            employee = updateExperience();
        }
        if (type == 1) {
            employee = updateFresher();
        }
        if (type == 2) {
            employee = updateIntern();
        }
        this.employeeService.insert(employee);
    }
    public Experience updateExperience() {
        try {
            while (true) {
                menu.menu("menu-Edit");
                System.out.println("Input ID to update: ");
                Long id = Long.parseLong(scanner.nextLine());
                Employee employee = this.employeeService.findById(id);
                employee.setId(id);
                System.out.println("Select Number :");
                String temp = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (temp) {
                    case "1":
                        System.out.println("Input fullName : ");
                        String fullName = scanner.nextLine();
                        try {
                            while (!validateUtil.NameValidateUtil(fullName)) {
                                System.out.println("Invalid input name !!!");
                                System.out.println("Input FullName : ");
                                fullName = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setFullName(fullName);
                        showAllEmployee();
                        break;
                    case "2":
                        System.out.println("Input BirthDay : ");
                        String birthDay = scanner.nextLine();
                        try {
                            while (!validateUtil.BirthDayValidateUtil(birthDay)) {
                                System.out.println("Invalid input birthDay !!!");
                                System.out.println("Input BirthDay : ");
                                birthDay = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setBirthDay(birthDay);
                        showAllEmployee();
                        break;
                    case "3":
                        System.out.println("Input Phone : ");
                        String phone = scanner.nextLine();
                        try {
                            while (!validateUtil.phoneNumberValidateUtil(phone)) {
                                System.out.println("Invalid input phone !!!");
                                System.out.println("Input Phone : ");
                                phone = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setPhone(phone);
                        showAllEmployee();
                        break;
                    case "4":
                        System.out.println("Input Email : ");
                        String email = scanner.nextLine();
                        try {
                            while (!validateUtil.emailvalidateUtil(email)) {
                                System.out.println("Invalid input email !!!");
                                System.out.println("Input Email : ");
                                email = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setEmail(email);
                        showAllEmployee();
                        break;
                    case "5":
                        System.out.println("Input expInYear : ");
                        int expInYear = Integer.parseInt(scanner.nextLine());
                        experience.setExpInYear(expInYear);
                        showAllEmployee();
                        break;
                    case "6":
                        System.out.println("Input proSkill : ");
                        String proSkill = scanner.nextLine();
                        experience.setProSkill(proSkill);
                        showAllEmployee();
                        break;
                    case "r":
                        System.out.println("return!!");
                        select.select();
                        break;
                    case "e":
                        employeeService.exitUtil();
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Fresher updateFresher() {
        try {
            while (true) {
                menu.menu("menu-Edit1");
                System.out.println("Input ID to update: ");
                Long id = Long.parseLong(scanner.nextLine());
                Employee employee = this.employeeService.findById(id);
                employee.setId(id);
                System.out.println("Select Number :");
                String temp = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (temp) {
                    case "1":
                        System.out.println("Input fullName : ");
                        String fullName = scanner.nextLine();
                        try {
                            while (!validateUtil.NameValidateUtil(fullName)) {
                                System.out.println("Invalid input name !!!");
                                System.out.println("Input FullName : ");
                                fullName = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setFullName(fullName);
                        break;
                    case "2":
                        System.out.println("Input BirthDay : ");
                        String birthDay = scanner.nextLine();
                        try {
                            while (!validateUtil.BirthDayValidateUtil(birthDay)) {
                                System.out.println("Invalid input birthDay !!!");
                                System.out.println("Input BirthDay : ");
                                birthDay = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setBirthDay(birthDay);
                        break;
                    case "3":
                        System.out.println("Input Phone : ");
                        String phone = scanner.nextLine();
                        try {
                            while (!validateUtil.phoneNumberValidateUtil(phone)) {
                                System.out.println("Invalid input phone !!!");
                                System.out.println("Input Phone : ");
                                phone = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setPhone(phone);
                        break;
                    case "4":
                        System.out.println("Input Email : ");
                        String email = scanner.nextLine();
                        try {
                            while (!validateUtil.emailvalidateUtil(email)) {
                                System.out.println("Invalid input email !!!");
                                System.out.println("Input Email : ");
                                email = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setEmail(email);
                        break;
                    case "5":
                        System.out.println("Input graduationDate : ");
                        String graduationDate = scanner.nextLine();
                        fresher.setGraduationDate(graduationDate);
                        break;
                    case "6":
                        System.out.println("Input graduationRank : ");
                        String graduationRank = scanner.nextLine();
                        fresher.setGraduationRank(graduationRank);
                        break;
                    case "7":
                        System.out.println("Input education : ");
                        String education = scanner.nextLine();
                        fresher.setEducation(education);
                        break;
                    case "r":
                        System.out.println("return!!");
                        select.select();
                        break;
                    case "e":
                        employeeService.exitUtil();
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Intern updateIntern() {
        try {
            while (true) {
                menu.menu("menu-Edit2");
                System.out.println("Input ID to update: ");
                Long id = Long.parseLong(scanner.nextLine());
                Employee employee = this.employeeService.findById(id);
                employee.setId(id);
                System.out.println("Select Number :");
                String temp = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (temp) {
                    case "1":
                        System.out.println("Input fullName : ");
                        String fullName = scanner.nextLine();
                        try {
                            while (!validateUtil.NameValidateUtil(fullName)) {
                                System.out.println("Invalid input name !!!");
                                System.out.println("Input FullName : ");
                                fullName = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setFullName(fullName);
                        break;
                    case "2":
                        System.out.println("Input BirthDay : ");
                        String birthDay = scanner.nextLine();
                        try {
                            while (!validateUtil.BirthDayValidateUtil(birthDay)) {
                                System.out.println("Invalid input birthDay !!!");
                                System.out.println("Input BirthDay : ");
                                birthDay = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setBirthDay(birthDay);
                        break;
                    case "3":
                        System.out.println("Input Phone : ");
                        String phone = scanner.nextLine();
                        try {
                            while (!validateUtil.phoneNumberValidateUtil(phone)) {
                                System.out.println("Invalid input phone !!!");
                                System.out.println("Input Phone : ");
                                phone = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setPhone(phone);
                        break;
                    case "4":
                        System.out.println("Input Email : ");
                        String email = scanner.nextLine();
                        try {
                            while (!validateUtil.emailvalidateUtil(email)) {
                                System.out.println("Invalid input email !!!");
                                System.out.println("Input Email : ");
                                email = scanner.nextLine();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        employee.setEmail(email);
                        break;
                    case "5":
                        System.out.println("Input majors : ");
                        String majors = scanner.nextLine();
                        intern.setMajors(majors);
                        break;
                    case "6":
                        System.out.println("Input semester : ");
                        int semester = Integer.parseInt(scanner.nextLine());
                        intern.setSemester(semester);
                        break;
                    case "7":
                        System.out.println("Input universityName : ");
                        String universityName = scanner.nextLine();
                        intern.setUniversityName(universityName);
                        break;
                    case "r":
                        System.out.println("return!!");
                        select.select();
                        break;
                    case "e":
                        employeeService.exitUtil();
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete() {
        System.out.print("Input ID to deleet: ");
        Long id = Long.parseLong(scanner.nextLine());
        this.employeeService.deleteById(id);
    }
    public void showAllEmployee() {
        this.employeeService.findAll().forEach(Employee :: showMe);
    }
}