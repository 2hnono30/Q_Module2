package QL_Ung_Vien.candidateType;

public class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;


    public Fresher(Long id, String fullName, String birthDay,String phone,String email, String graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
        this.phone = phone;
        this.email = email;
    }

    public Fresher() {

    }

    public void showSkill() {
        System.out.println("sgs");
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate='" + graduationDate + '\'' +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
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
