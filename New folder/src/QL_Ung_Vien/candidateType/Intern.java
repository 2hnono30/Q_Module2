package QL_Ung_Vien.candidateType;

public class Intern extends Employee {
    private String majors;
    private int semester;
    private String universityName;

    public Intern() {
    }

    public Intern(Long id, String fullName, String birthDay, String phone, String email, String majors, int semester, String universityName) {
        super(id, fullName, birthDay, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
        this.phone = phone;
        this.email = email;
    }

    public void showSkill(){
        System.out.println("fihskuhsfh");
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "majors='" + majors + '\'' +
                ", semester=" + semester +
                ", universityName='" + universityName + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                ", certificates=" + certificates +
                '}';
    }

    @Override
    public void showMe() {
        System.out.println(this);
    }
}
