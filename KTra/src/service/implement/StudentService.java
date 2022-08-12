package service.implement;

import model.StudentModel;
import service.interfaces.IStudent;
import util.AlertUtil;
import util.FileUtil;
import util.PathUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentService implements IStudent {
    FileUtil fileUtil = new FileUtil();

    @Override
    public ArrayList<StudentModel> getStudent() {
        StudentModel studentModel = new StudentModel();
        ArrayList<StudentModel> studentList = new ArrayList<>();
        ArrayList<String> fileRecord = fileUtil.fileRead(PathUtil.PATH_STUDENT_DATA);
        for (String temp : fileRecord) {
            studentList.add(studentModel.parseStudent(temp));
        }
        return studentList;
    }

    @Override
    public StudentModel getStudentById(long studentId) {
        ArrayList<StudentModel> studentList = getStudent();
        for (StudentModel temp : studentList) {
            if (temp.getStudentId() == studentId)
                return temp;
        }
        return null;
    }

    @Override
    public void addStudent(StudentModel student) {
        ArrayList<StudentModel> studentList = getStudent();
        studentList.add(student);
        fileUtil.fileWrite(PathUtil.PATH_STUDENT_DATA, studentList);
    }

    @Override
    public void editStudent(StudentModel student) {
        ArrayList<StudentModel> studentList = getStudent();
        AlertUtil alertUtil = new AlertUtil();
        Scanner input = new Scanner(System.in);
        for (StudentModel temp : studentList) {
            if (temp.getStudentId() == student.getStudentId()) {
                String studentName = student.getFullName();
                if (studentName != null && !studentName.isEmpty()) temp.setFullName(studentName);
                String dob = student.getDoB();
                if (dob != null && !dob.isEmpty()) temp.setDoB(dob);
                String sex = student.getSex();
                if (sex != null && !sex.isEmpty()) temp.setSex(sex);
                String phoneNumber = student.getPhoneNumber();
                if (phoneNumber != null && !phoneNumber.isEmpty()) temp.setPhoneNumber(phoneNumber);
                fileUtil.fileWrite(PathUtil.PATH_STUDENT_DATA, studentList);
                    break;
            }
        }
    }

    @Override
    public void removeStudent(StudentModel student) {
    ArrayList<StudentModel> studentList =getStudent();
    studentList.removeIf(temp -> temp.getStudentId() == student.getStudentId());
    fileUtil.fileWrite(PathUtil.PATH_STUDENT_DATA,studentList);
    }

    @Override
    public boolean existsStudentId(long studentId) {
        return getStudentById(studentId) != null;
    }

    @Override
    public ArrayList<StudentModel> studentSortByFullName() {
        ArrayList<StudentModel> studentList = new ArrayList<>(getStudent());
        studentList.sort(new Comparator<StudentModel>() {
            @Override
            public int compare(StudentModel o1, StudentModel o2) {
                return o1.getFullName().compareToIgnoreCase(o2.getFullName());
                // (A-Z : dấu - ở trước);
            }
        });
        return studentList;
    }

    @Override
    public ArrayList<StudentModel> studentSortByPhoneNumber() {
        ArrayList<StudentModel> studentList = new ArrayList<>(getStudent());
        studentList.sort(new Comparator<StudentModel>() {
            @Override
            public int compare(StudentModel o1, StudentModel o2) {
                return o1.getPhoneNumber().compareToIgnoreCase(o2.getPhoneNumber());
            }
        });
        return studentList;
    }


}

