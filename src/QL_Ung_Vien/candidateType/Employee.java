package QL_Ung_Vien.candidateType;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    protected Long id;
    protected String fullName;
    protected String birthDay;
    protected String phone;
    protected String email;
    protected int employeeType;
    protected List<Certificate> certificates;
    public static ArrayList<Employee> employees = new ArrayList<>();
    public Employee(){}
    public Employee(Long id, String fullName, String birthDay, int employeeType) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.employeeType = employeeType;
        this.certificates = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return employeeType;
    }

    public void setCandidateType(int candidateType) {
        this.employeeType = candidateType;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        Employee.employees = employees;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public abstract void showMe();

}

