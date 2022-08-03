package QL_Ung_Vien.candidateType;

public class Experience extends Employee {
    private int expInYear;
    private String proSkill;
public Experience(){}

    @Override
    public void showMe() {
        System.out.println(this);
    }

    public Experience(Long id, String fullName, String birthDay,String phone,String email, int expInYear, String proSkill) {
        super(id, fullName, birthDay, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
        this.phone = phone;
        this.email = email;
    }

    public void showSkill(){
        System.out.println("fkuhsfs");
    }
    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                ", certificates=" + certificates +
                '}';
    }
}
