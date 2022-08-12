package service.interfaces;

import model.StudentModel;

import java.util.ArrayList;

public interface IStudent {
    ArrayList<StudentModel> getStudent();
    StudentModel getStudentById(long studentId);
    void addStudent(StudentModel student);
    void editStudent(StudentModel student);
    void removeStudent (StudentModel student);
    boolean existsStudentId(long studentId);
    ArrayList<StudentModel> studentSortByFullName();
    ArrayList<StudentModel> studentSortByPhoneNumber();
}
