package QL_Sinh_Vien.SinhVien;

import java.util.ArrayList;

public class SinhVien {
    private int SinhVienId;
    private String FullName;
    private int Age;
    private String GioiTinh;
    private String Address;
    private float MediumScore;

    public SinhVien(){}
    public static ArrayList<SinhVien> sinhViens = new ArrayList<SinhVien>();
    public SinhVien(int SinhVienId , String FullName, int Age, String GioiTinh, String Address, float MediumScore){
    this.SinhVienId = SinhVienId;
    this.FullName = FullName;
    this.Age = Age;
    this.GioiTinh = GioiTinh;
    this.Address=Address;
    this.MediumScore=MediumScore;
    }
    public int getSinhVienId() {
        return SinhVienId;
    }

    public void setSinhVienId(int sinhVienId) {
        SinhVienId = sinhVienId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getMediumScore() {
        return MediumScore;
    }

    public void setMediumScore(float mediumScore) {
        MediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "SinhVienId=" + SinhVienId +
                ", FullName='" + FullName + '\'' +
                ", Age=" + Age +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", Address='" + Address + '\'' +
                ", MediumScore=" + MediumScore +
                '}';
    }
}
