package model;

public class StudentModel {
    private long studentId;
    private String fullName;
    private String doB;
    private String sex;
    private String phoneNumber;
    private String universityName;
    private String gradeLevel;

    public StudentModel() {
    }

    ;

    public StudentModel(long studentId, String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.doB = doB;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }

    ;

    public StudentModel parseStudent(String fileDate) {
        StudentModel studentModel = new StudentModel();
        String[] fileIndex = fileDate.split(",");
        studentModel.studentId=Long.parseLong(fileIndex[0]);
        studentModel.fullName=fileIndex[1];
        studentModel.doB=fileIndex[2];
        studentModel.sex = fileIndex[3];
        studentModel.phoneNumber=fileIndex[4];
        studentModel.universityName = fileIndex[5];
        studentModel.gradeLevel=fileIndex[6];
        return studentModel;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",studentId,fullName,doB,sex,phoneNumber,universityName,gradeLevel);
    }

}
